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
import pages.Login;
import pages.SignUp;
import pages.TreatiansPOM;

@Listeners(CustomListener.class)


public class testTreatians extends TreatiansBaseClass 
{
	public static String USERNAME ="gayaskhan1@gmail.com";
	public static String PASSWORD ="12345678";
	public static String firstname ="gayas";
	public static String lastname ="khan";
	public static String MOBNUMBER ="9837462894";
	public static String ADDRESS ="fleek IT Solutions NOIDA";
	public static String UPDATEDNUMBER ="000000000";
	
	
	@Test(priority = 0)
	public void openWebApp() throws InterruptedException
	{
		 WebTest web = new WebTest(driver1);
		 web.webcall();
		 System.out.println("webdriver is called");
	}
	
	@Test(priority = 1)
	public void MobileSignUp() throws InterruptedException
	{
		System.out.println("Sign in Test Through Mobile");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		SignUp repo=new SignUp(driver);
		repo.createANewUser(firstname,lastname,USERNAME,MOBNUMBER,PASSWORD,PASSWORD,ADDRESS );
		Thread.sleep(3000);
		Login l2=new Login(driver);
		l2.loginAfterSignUp.click();	
	}
	
	@Test(priority = 2)
	public void UserListingVerification() throws InterruptedException {
		
		WebTest web1 = new WebTest(driver1);

		web1.AdminWebVerification();
		Thread.sleep(2000);
		web1.userButtonAdmin.click();
		web1.emailVerification();
		
	}
	
	@Test(priority = 3)
	public void UpdateUserDetails() throws InterruptedException {
		WebTest web2 = new WebTest(driver1);
		web2.UpdateUserDetailsFromAdminSide(UPDATEDNUMBER);
		
	}
	
	@Test(priority = 4) 
	public void MobileLogInAndVerification() throws InterruptedException { 
	
	Allure.step("Login In Mobile");
	  
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	Login log=new Login(driver); 
	log.signIN(USERNAME, PASSWORD); 
	Thread.sleep(2000);
	log.userDetailsUpdatedVerify();
	  
  }
	
}

	
	















 
	

/*
 * @Test(priority = 4) public void WebUser_Verification() throws
 * InterruptedException {
 * 
 * WebTest web = new WebTest(driver1); web.WebLogin(USERNAME, PASSWORD);
 * Thread.sleep(4000);
 * 
 * }
 */

	

