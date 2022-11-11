package pageLayer;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseLayer.BaseClass;
import utilsLayer.GetProp;
import utilsLayer.TakeScreenshot;

public class TempMailPage extends BaseClass {
	
	@FindBy(xpath = "//div[@class='input-box-col hidden-xs-sm']")
	WebElement tempID;
	
	@FindBy(xpath = "//div[@class='inbox-area maillist']")
	WebElement tempInbox;
	
	@FindBy(xpath = "//div[@class='inbox-dataList']//following::li[2]")
	WebElement tempNewMail;
	
	@FindBy(xpath = "//div[@class='inbox-area onemail']")
	WebElement tempMailBody;
	
	@FindBy(xpath = "//div[@class='user-data-subject']//following::h4")
	WebElement mailSubject;
	
	@FindBy(xpath = "//div[@class='inbox-data-content-intro']")
	WebElement mailBody;

	public TempMailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void getTempMail() throws IOException {
		try {
			driver.get(GetProp.get("tempUrl"));
		} catch (UnhandledAlertException e) {
			driver.switchTo().alert().accept();
			driver.get("https://temp-mail.org/en/");
		}
	}
	
	public void copyTempID() {
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(tempID)).click();
	}
	
	public void openNewMail() {
		tempNewMail.click();
	}
	
	public void getMailSS() throws IOException {
		TakeScreenshot.getElementSS(tempMailBody);
	}
	
	public String getMailSubject() {
		return mailSubject.getText();
	}
	
	public String getMailBody() {
		return mailBody.getText();
	}

}
