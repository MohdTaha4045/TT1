package test;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Web.WebTest;
import baseClass.TreatiansBaseClass;
import generalUtility.CustomListener;
import generalUtility.XLUtility;
import io.qameta.allure.Allure;
import pageObjectModel.Login;
import pageObjectModel.SignUp;
import pageObjectModel.TreatiansPOM;

@Listeners(CustomListener.class)


public class testTreatians extends TreatiansBaseClass 
{
	public static String USERNAME ="gayaskhan@gmail.com";
	public static String PASSWORD ="12345678";
	public static String firstname ="gayas";
	public static String lastname ="khan";
	
	@Test(priority = 1)
	public void webVerification() throws InterruptedException
	{
		 WebTest web = new WebTest(driver1);
		 web.webcall();
		 System.out.println("webdriver is called");
	}
	
	@Test(priority = 2)
	public void signUpTest() throws InterruptedException
	{
		System.out.println("Sign in Test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		SignUp repo=new SignUp(driver);
		repo.createANewUser(firstname,lastname,USERNAME,"9891554489",PASSWORD,PASSWORD,"97/127 purani Delli 110048" );
		Thread.sleep(3000);
		Login l2=new Login(driver);
		l2.loginAfterSignUp.click();	
	}
	@Test(priority = 3)
	public void WebUser_Verification() throws InterruptedException {
	
		 WebTest web = new WebTest(driver1);
		 web.WebVerification(USERNAME, PASSWORD);
		
	}

	@Test(priority = 4)
	public void signInTest() throws InterruptedException
	{
		Allure.step("LOgin Test");

		System.out.println("Sign in Test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Login repo=new Login(driver);
		repo.signIN(USERNAME, PASSWORD);
		String expectedText = repo.homePageText.getText(); 
		String actualText = "Treatians";
		Assert.assertEquals(expectedText,actualText);
		System.out.println("Sign in Successful");
			
	}
	public void AdminVerification() throws InterruptedException {
		
		WebTest web1 = new WebTest(driver1);
		web1.userImage.click();
		web1.logout.click();
		web1.WebVerification("admin@rlv.com", "password");
		web1.userButtonAdmin.click();
		
		
	}
	
	
}

	
	
	
	

	

