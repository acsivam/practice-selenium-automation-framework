package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.ContactUsPage;
import com.automation.pages.HomePage;

public class TC06_Contactus extends BaseTest{

	@Test
	public void verifyUserCanSubmitMessage() {
		HomePage homePage = new HomePage(driver);
		String title = homePage.getPageTitle();
		Assert.assertEquals(title, "Automation Exercise");
		
		ContactUsPage contactUsPage = homePage.topMenu.goToContactUsPage();
		String getIn = contactUsPage.getGetInTouchGeading();
		Assert.assertEquals(getIn, "GET IN TOUCH");
		
		String filePath = System.getProperty("user.dir") + "/varanda.jpg";
		System.out.println(filePath);
		contactUsPage.submitMessage("Jogn", "abc@gmail.com", "Boom boom", "Exiciting offer!", filePath);
		String successMessage = contactUsPage.getSubmitSuccessMessage();
		System.out.println(successMessage);
		Assert.assertEquals(successMessage, "Success! Your details have been submitted successfully.");
		
		homePage = contactUsPage.clickHomeButton();
		title = homePage.getPageTitle();
		Assert.assertEquals(title, "Automation Exercise");
	}

}
