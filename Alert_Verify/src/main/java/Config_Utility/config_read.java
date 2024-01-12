package Config_Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class config_read {

	public static String read_configvalue(String Key) throws Exception {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("/Users/testingwimate/eclipse-workspace/Alert_Verify/src/main/resources/config.properties");
		prop.load(ip);
		String value = prop.getProperty(Key);
		return value;
	}

}
