package fri.patterns.interpreter.parsergenerator.builder;

import java.io.*;
import java.util.*;
import fri.util.props.ConfigDir;
import fri.patterns.interpreter.parsergenerator.syntax.*;
import fri.patterns.interpreter.parsergenerator.syntax.builder.*;

/**
	Base class for serialization and deserialisation of Java-objects.
	
	@author (c) 2000, Fritz Ritzberger
*/

class SerializedObject
{
	/** Do-nothing constructor. */
	public SerializedObject()	{
	}
	
	/**
		Deserializes an object from filesystem.
		@return deserialized object.
	*/
	protected Object read(String fileName)	{
		fileName = makeFilePath(fileName);
		System.err.println("deserializing object from "+fileName);
		ObjectInputStream oin = null;
		try	{
			FileInputStream in = new FileInputStream(fileName);
			oin = new ObjectInputStream(in);
			return oin.readObject();
		}
		catch (Exception e)	{
			System.err.println(e.getMessage());	// tolerate non-existing object
			return null;
		}
		finally	{
			try	{	oin.close();	}	catch (Exception e)	{}
		}
	}
	
	/**
		Serializes an object to filesystem.
		@return true on success.
	*/
	protected boolean write(String fileName, Object o)	{
		fileName = makeFilePath(fileName);
		System.err.println("serializing object to "+fileName);
		ObjectOutputStream oout = null;
		try	{
			ensureDirectory(fileName);
			FileOutputStream out = new FileOutputStream(fileName);
			oout = new ObjectOutputStream(out);
			oout.writeObject(o);
			return true;
		}
		catch (IOException e)	{
			e.printStackTrace();
			return false;
		}
		finally	{
			try	{	oout.flush(); oout.close();	}	catch (Exception e)	{}
		}
	}


	/**
		When syntaxInput is a File, the name of the serialization file is created
		from its basename (without any extension), else "Unknown" is assumed as basename.
		The returned name has no path.
	*/
	public static String baseNameFromSyntax(Object syntaxInput)	{
		String name;
		if (syntaxInput instanceof File)	{
			File f = (File) syntaxInput;
			name = f.getName();
			int i = name.indexOf(".");
			if (i > 0)
				name = name.substring(0, i);
		}
		else	{
			name = "Unknown";
		}
		return name;
	}


	/** Converts a File, InputStream, Reader, String, StringBuffer, List of Lists or String[][] to a Syntax. */
	public static Syntax toSyntax(Object syntaxInput)
		throws Exception
	{
		Syntax syntax;
		if (syntaxInput instanceof Syntax)
			syntax = (Syntax) syntaxInput;
		else
		if (syntaxInput instanceof String[][])
			syntax = new Syntax((String[][]) syntaxInput);
		else
		if (syntaxInput instanceof List)
			syntax = new Syntax((List)syntaxInput);
		else
			syntax = new SyntaxBuilder(syntaxInput).getSyntax();
			
		syntax.resolveSingulars();
		return syntax;
	}
	
	
	/** Puts the file into ".friware/parsers" directory in "user.home". */
	protected String makeFilePath(String fileName)	{
		return ConfigDir.dir()+"parsers"+File.separator+fileName;
	}
	
	/** Creates the directory of passed filename if it does not exist. @return the directory name. */
	protected String ensureDirectory(String fileName)	{
		File file = new File(fileName);
		String dir = file.getParent();
		
		if (dir != null)	{
			File directory = new File(dir);
			if (directory.exists() == false)
				directory.mkdirs();
		}
		
		return dir;
	}
	
}