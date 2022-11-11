package utilsLayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import baseLayer.BaseClass;

public class GetProp extends BaseClass {
	
	public static String get(String key) throws IOException {
		FileInputStream f = new FileInputStream("src\\main\\java\\configLayer\\config.property");
		Properties p = new Properties();
		p.load(f);
		return p.getProperty(key);
	}

}
