package fri.util.props;

import java.io.File;

public abstract class ConfigDir
{
	private static String dir = null;
	
	public static String dir()	{
		if (dir == null)	{
			dir = System.getProperty("user.home");

			if (dir.endsWith(File.separator) == false)
				dir = dir+File.separator;
				
			dir = dir+".friware"+File.separator;
		}
		
		return dir;
	}
	
	private ConfigDir()	{}
}
