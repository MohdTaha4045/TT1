package test;

import java.time.Duration;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Web.WebTest;
import baseClass.TreatiansBaseClass;
import generalUtility.CustomListener;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import pages.Login;
import pages.SignUp;

@Listeners(CustomListener.class)


public class testTreatians extends TreatiansBaseClass 
{
	public static String USERNAME ="gayaskhan1@gmail.com";
	public static String PASSWORD ="12345678";
	public static String firstname ="gayas";
	public static String lastname ="khan";
	public static String MOBNUMBER ="983568483";
	public static String ADDRESS ="fleek IT Solutions NOIDA";
	public static String UPDATEDNUMBER ="7867563423";
	
	
	@Test(priority = 0)
	@Step("Open WebApp")
	public void openWebApp() throws InterruptedException
	{
		 WebTest web = new WebTest(driver1);
		 web.webcall();
		 System.out.println("webdriver is called");
	}
	
	@Test(priority = 1)
	@Step("Mobile SignUp")
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
	@Step("User Listing Verification")
	public void UserListingVerification() throws InterruptedException {
		
		WebTest web1 = new WebTest(driver1);

		web1.AdminWebVerification();
		Thread.sleep(2000);
		web1.userButtonAdmin.click();
		web1.emailVerification();
		
	}
	
	@Test(priority = 3)
	@Step("Update User Details")
	public void UpdateUserDetails() throws InterruptedException {
		WebTest web2 = new WebTest(driver1);
		web2.UpdateUserDetailsFromAdminSide(UPDATEDNUMBER);
		
	}
	
	@Test(priority = 4) 
	@Step("Mobile Verification")
	public void MobileLogInAndVerification() throws InterruptedException { 
	
	Allure.step("Login In Mobile"); 
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	Login log=new Login(driver); 
	log.signIN(USERNAME, PASSWORD); 
	Thread.sleep(2000);
	log.userDetailsUpdatedVerify();
	  
  }
	
}

	

