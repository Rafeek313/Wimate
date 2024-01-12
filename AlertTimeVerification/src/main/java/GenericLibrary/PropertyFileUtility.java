package GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	/**
	 * this method will read data from property file for the key given by user and
	 * return value to user
	 * 
	 * @author rafeek
	 * @param key
	 * @throws Throwable
	 * @return
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IpathConstants.PropertyFilePath);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;

	}
}
