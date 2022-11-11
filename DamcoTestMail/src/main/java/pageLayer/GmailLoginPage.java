package pageLayer;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLayer.BaseClass;
import utilsLayer.GetProp;

public class GmailLoginPage extends BaseClass {
	@FindBy(xpath = "//div[text() = 'Email or phone']")
	WebElement loginMail;
	
	@FindBy(xpath = "//span[text() = 'Next']")
	WebElement mailNext;
	
	@FindBy(xpath = "//div[text() = 'Enter your password']")
	WebElement loginPass;
	
	@FindBy(xpath = "//div[@id='passwordNext']")
	WebElement passNext;
	
	public GmailLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void gmailLogin() throws IOException {
		loginMail.sendKeys(GetProp.get("email"));
		mailNext.click();
		
		loginPass.sendKeys(GetProp.get("password"));
		passNext.click();	
	}
	
}
