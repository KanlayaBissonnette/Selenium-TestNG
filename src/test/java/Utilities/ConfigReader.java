package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	private static Properties config_file;

	static {
		try {

			String filepath = Constants.FILE_PATH;
			FileInputStream input = new FileInputStream(filepath);
			config_file = new Properties();
			config_file.load(input);
			input.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String getProperties(String key) {
		return config_file.getProperty(key);
	}
}
