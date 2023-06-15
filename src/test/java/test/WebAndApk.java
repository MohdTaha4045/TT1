package test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Allure;
import pageObjectModel.Login;

public class WebAndApk 
{
	/*@Test(priority = 1)
	public void Signin()
	{
		//this.driver=driver;
		Allure.step("LOgin Test");

		System.out.println("Sign in Test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Login repo=new Login(driver);
		repo.signIN("Gayaas@gmail.com", "12345678");
		String expectedText = repo.homePageText.getText(); 
		String actualText = "Treatians";
		Assert.assertEquals(expectedText,actualText);
		System.out.println("Sign in Successful");
		
		
	}*/
	
	@Test(priority = 2)
	public void webTest()
	{
		WebDriver driver2 = null ;
		String projectPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver",projectPath+"\\drivers\\chromedriver.exe");
		driver2 = new ChromeDriver();
		driver2.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver2.get("https://rlv-01-core-shared-ui-cia-test.azurewebsites.net/#/cms/home?country=IN");
	}
	
}
