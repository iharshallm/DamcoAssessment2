package testLayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseLayer.BaseClass;
import pageLayer.GmailInboxPage;
import pageLayer.GmailLoginPage;
import pageLayer.TempMailPage;

public class tempMailEtoE extends BaseClass{

	protected TempMailPage temp;
	protected GmailLoginPage gLog;
	protected GmailInboxPage gInbox;
	
	@BeforeTest
	public void setUp() {
		BaseClass.initialize();
	}
	@Test(priority = 1)
	public void tempMailCreate() throws IOException {
		temp = new TempMailPage(driver); 
		temp.getTempMail();
		temp.copyTempID();
	}
	
	@Test(priority = 2)
	public void gmailLogin() throws IOException {
		gLog = new GmailLoginPage(driver);
		gLog.gmailLogin();
	}

	@Test(priority = 3)
	public void gmailCompose() {
		gInbox = new GmailInboxPage(driver);
		gInbox.closePopup();
		gInbox.sendMail();
	}
	
	@Test(priority = 4)
	public void tempInbox() throws IOException  {
		temp = new TempMailPage(driver);
		
		temp.getTempMail();
		temp.openNewMail();
	}
	
	@Test(priority = 5)
	public void verifyMailSubject() {
		Assert.assertEquals(temp.getMailSubject(), gInbox.gmailSubject);
	}
	
	@Test(priority = 6)
	public void verifyMailBody() {
		Assert.assertEquals(temp.getMailBody(), gInbox.gmailBody);
	}
	
	@Test(priority = 7)
	public void tempMailSS() throws IOException {
		temp.getMailSS();
	}
	
	@AfterTest
	public void tear() {
		BaseClass.tearDown();
	}
}
