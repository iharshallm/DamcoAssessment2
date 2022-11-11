package pageLayer;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseLayer.BaseClass;

public class GmailInboxPage extends BaseClass{
	
	@FindBy(xpath = "//iframe[@name='callout']")
	WebElement gmailFrame;
	
	@FindBy(xpath = "//button[text() = \\\"Don't Switch\\\"]")
	WebElement gmailPop;

	@FindBy(xpath = "//div[@class='T-I T-I-KE L3']")
	WebElement compose;
	
	@FindBy(xpath = "//input[@class='agP aFw']")
	WebElement composeTo;
	
	@FindBy(xpath = "//input[@name='subjectbox']")
	WebElement composeSubject;
	
	@FindBy(xpath = "//div[@class='Am Al editable LW-avf tS-tW']")
	WebElement composeBody;
	
	@FindBy(xpath = "//div[@class='dC'] ")
	WebElement composeSend;
	
	public String gmailSubject = "test Mail";
	public String gmailBody = "This is a test mail for DamcoAssessment.";
	
	public GmailInboxPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void closePopup() {
		driver.switchTo().frame(gmailFrame);
		gmailPop.click();
		driver.switchTo().parentFrame();
	}
	
	public void sendMail() {
		compose.click();
		try {
			composeTo.sendKeys(Keys.CONTROL + "v");
		} catch (StaleElementReferenceException e) {
			new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(composeTo)).sendKeys(Keys.CONTROL + "v");
		}
		composeSubject.sendKeys(gmailSubject);
		composeBody.sendKeys(gmailBody);
		composeSend.click();
	}
}
