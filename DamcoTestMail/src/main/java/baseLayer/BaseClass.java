package baseLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {
	
	protected static WebDriver driver;
	
	public static void initialize() {
		System.setProperty("webdriver.edge.driver", "Drivers\\msedgedriver.exe");
		
		driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.manage().window().maximize();
	}
	
	public static void tearDown() {
		driver.quit();
	}


}
