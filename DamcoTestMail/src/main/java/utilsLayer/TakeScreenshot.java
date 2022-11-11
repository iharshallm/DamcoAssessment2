package utilsLayer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import baseLayer.BaseClass;

public class TakeScreenshot extends BaseClass {
	
	public static void getElementSS (WebElement e) throws IOException {
		File f = e.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("\\Screenshots\\"+ new SimpleDateFormat("ddMMyyyy_HHmmSS").format(new Date()) +"mailSS.png"));
		
	}

}
