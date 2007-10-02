package fri.patterns.interpreter.parsergenerator.lexer;

import java.io.*;

/**
	Lexer input wrapper. The input can be InputStream, Reader, File, String or StringBuffer.
	If Input is InputStream, no Reader will be used, which means that the input reads bytes
	and not characters.
	<p>
	The read() methode returns EOF (-1) when there is no more input.
	
	@author (c) 2002, Fritz Ritzberger
*/

class Input
{
	public static final int EOF = -1;
	private InputStream inputStream;
	private Reader reader;
	private int [] buffer;
	private int readPos, readLen;
	private int readOffset;
	private boolean eof = false;
	private boolean buffering = false;
	
	
	Input(Object input)
		throws IOException
	{
		if (input instanceof InputStream)
			this.inputStream = input instanceof BufferedInputStream ? (InputStream)input : new BufferedInputStream((InputStream)input);
		else	
		if (input instanceof Reader)
			this.reader = input instanceof BufferedReader ? (Reader)input : new BufferedReader((Reader)input);
		else
		if (input instanceof File)
			this.reader = new BufferedReader(new FileReader((File)input));
		else
		if (input instanceof StringBuffer || input instanceof String)
			this.reader = new StringReader(input.toString());
		else
			throw new IllegalArgumentException("Unknown input object: "+(input != null ? input.getClass().getName() : "null"));
	}	


	/** Returns next character or byte from input. Closes input when EOF is reached. */
	public int read()
		throws IOException
	{
		int i;

		if (readLen > readPos)	{	// use buffer if buffer is not at end
			i = buffer[readPos];
			readPos++;
			return i;
		}
		
		if (eof)
			return EOF;

		// read one character from input
		i = (reader != null) ? reader.read() : inputStream.read();
		
		// recognize end of input
		if (i == -1)	{
			eof = true;
			
			try	{
				if (reader != null)
					reader.close();
				else
					inputStream.close();
			}
			catch (IOException e)	{
			}
		}
		else	{
			readOffset++;
			convertInput(i);	// input hook for subclasses
			
			if (buffering)	// store character if in buffering state
				storeRead(i);
			else
				readPos = readLen = 0;
		}
		
		return i;
	}


	/** Read a lookahead character and reset mark after. */
	public int peek()
		throws IOException
	{
		int mark = getMark();
		int c = read();
		setMark(mark);
		return c;
	}

	/** Override this to buffer lines or convert any read int. */
	protected int convertInput(int i)	{
		return i;
	}


	/** Returns the offset of the last scanned char/byte, less or equal the read offset. */
	public int getScanOffset()	{
		return getReadOffset() - getUnreadLength();
	}

	/** Returns the offset of the last read char/byte (bigger or equal to scan offset). */
	public int getReadOffset()	{
		return readOffset;
	}


	/** Get the current read mark and turn on buffering. The mark is a relative offset, not an absolute read position.  */
	public int getMark()	{
		buffering = true;
		return readPos;
	}
	
	/** Set read position to passed mark. Needed when trying more scan items. This does not turn on buffering like getMark()! */
	public void setMark(int mark)	{
		readPos = mark;
	}
	
	
	/** Resolve buffer, skip rest of unread int's to buffer start. */
	public void resolveBuffer()	{
		buffering = false;
		
		if (readLen > readPos)	{
			if (readPos > 0)	{	// copy unread buffer to bottom
				int diff = getUnreadLength();
				System.arraycopy(buffer, readPos, buffer, 0, diff);
				readLen = diff;
				readPos = 0;
			}
		}
		else	{
			readPos = readLen = 0;
		}
	}
	
	
	// store the int to buffer
	private void storeRead(int i)	{
		if (buffer == null)	// allocate buffer
			buffer = new int [128];
		
		if (readPos == buffer.length)	{	// reallocate buffer as it is too small
			//System.err.println("enlarging lexer buffer from "+buffer.length);
			int [] old = buffer;
			// the buffer must not be as long as the input, it just serves as lookahead buffer.
			buffer = new int[old.length * 2];
			System.arraycopy(old, 0, buffer, 0, old.length);
		}
		
		if (readPos != readLen)
			throw new IllegalStateException("Can not read to buffer when it was not read empty!");
			
		buffer[readPos] = i;
		readPos++;
		readLen++;
	}


	/** Returns the part of the buffer that was not yet consumed. */
	public int [] getUnreadBuffer()	{
		int diff;
		if (buffer == null || (diff = getUnreadLength()) <= 0)
			return new int [0];
		
		int [] ret = new int[diff];
		System.arraycopy(buffer, readPos, ret, 0, diff);

		return ret;
	}

	/** Returns the length that was not yet consumed. */
	protected int getUnreadLength()	{
		return readLen - readPos;
	}

}