package fri.patterns.interpreter.parsergenerator.lexer;

import java.util.*;
import java.io.IOException;

/**
	Input for text lines. Line number, line position, current line and
	previous line are available.
		
	@author (c) 2002, Fritz Ritzberger
*/

class InputText extends Input
{
	private int [] line;	// current line buffer
	private int [] prevLine;	// previous line buffer
	private int prevLength;
	private boolean wasCr = false;	// flag if '\r' occured
	private int column;	// line position
	private List lineLengths = new ArrayList();	// list of Integer containing line lengths including newline sequence
	private int [] scanPoint;


	InputText(Object input)
		throws IOException
	{
		super(input);
	}


	protected int convertInput(int i)	{
		if (i == '\r')	{
			wasCr = true;
			newLine();
		}
		else	{
			if (i == '\n')	{
				if (wasCr == false)	// on UNIX
					newLine();
				else	// on WINDOWS, ignore \n after \r, but adjust previous line length
					lineLengths.set(
							lineLengths.size() - 1,
							new Integer( ((Integer) lineLengths.get(lineLengths.size() - 1)).intValue() + 1 )
							);
			}
			else	{
				storeRead(i);
			}
			wasCr = false;
		}

		scanPoint = null;	// force new scan point calculation
		return i;
	}

	private void newLine()	{
		lineLengths.add(new Integer(column + 1));	// line length plus one for the newline, will be adjusted when \r\n

		prevLength = column;
		column = 0;	// reset current line offset

		if (line == null)
			line = new int[64];
		
		if (prevLine == null || prevLine.length < line.length)
			prevLine = new int [Math.max(line.length, 64)];
		
		System.arraycopy(line, 0, prevLine, 0, prevLength);
	}
	
	private void storeRead(int i)	{
		if (line == null)	{	// allocate buffer
			line = new int [64];
		}
		else
		if (column == line.length)	{	// reallocate line buffer
			int [] old = line;
			line = new int[old.length * 2];
			System.arraycopy(old, 0, line, 0, old.length);
		}
		
		line[column] = i;
		column++;
	}


	/** Returns the current read line number (1-n). This is always bigger equal than scan line. */
	public int getReadLine()	{
		return lineLengths.size() + 1;
	}

	/** Returns the current read position (0-n). This is different from scan position. */
	public int getReadColumn()	{
		return column;
	}

	/** Returns the current scan line number (1-n). This is always smaller equal than read line. */
	public int getScanLine()	{
		return calculateScanPoint()[0];
	}

	/** Returns the current scan position (0-n). This is different from read position. */
	public int getScanColumn()	{
		return calculateScanPoint()[1];
	}
	
	private int [] calculateScanPoint()	{	// returns line/column
		if (scanPoint != null)	// use buffered scan pointer when possible, as line/column requests always are coupled
			return scanPoint;
			
		int diff = getReadColumn() - getUnreadLength();
		if (diff >= 0)
			return scanPoint = new int[] { getReadLine(), diff };
		
		for (int i = lineLengths.size() - 1; i >= 0; i--)	{	// loop back all lines
			int len = ((Integer) lineLengths.get(i)).intValue();
			diff += len;
			if (diff >= 0)
				return scanPoint = new int[] { i + 1, diff };
		}
		throw new IllegalStateException("Something went wrong when calculating scan point: "+diff);
	}

	/** Overridden to resolve scan pointer. Delegates to super. */
	public int read()	throws IOException	{
		scanPoint = null;
		return super.read();
	}

	/** Overridden to resolve scan pointer. Delegates to super. */
	public void setMark(int mark)	{
		scanPoint = null;
		super.setMark(mark);
	}


	/** Returns a String representing current line up to read position. */
	public String getLine()	{
		return createLineString(line, column);
	}

	/** Returns a String representing previous line. */
	public String getPreviousLine()	{
		return createLineString(prevLine, prevLength);
	}

	/** Returns all unscanned input in buffer. */
	public String getUnreadText()	{
		int [] buf = getUnreadBuffer();
		return createLineString(buf, buf.length);
	}

	private String createLineString(int [] line, int end)	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < end; i++)
			sb.append((char) line[i]);
		return sb.toString();
	}

}