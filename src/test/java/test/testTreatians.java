package test;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseClass.TreatiansBaseClass;
import generalUtility.CustomListener;
import generalUtility.XLUtility;
import io.qameta.allure.Allure;
import pageObjectModel.TreatiansPOM;

@Listeners(CustomListener.class)
public class testTreatians extends TreatiansBaseClass
{
	

	@Test(priority = 1) 
	public void creatingNewUser() throws InterruptedException
	{
		Allure.step("SingnUp");

		System.out.println("Creating new user");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		TreatiansPOM repo=new TreatiansPOM(driver);
		
		repo.signUp();
		
		repo.createFirstName();
		
		repo.createLastName();
		
		repo.passEmail();

		repo.passPhone();
		
		repo.passPassword();
		
		repo.passconfirmPassword();
		
		repo.selectCountryScrollDown();
		
		repo.selectIndia();
		
		repo.selectCityScrollDown();
		
		repo.clickGurugram();
		
		repo.passsAddress();
		
		repo.clickRegister();
			
		System.out.println("Accound successfully Created");
		
		repo.backButton.click();
		Thread.sleep(3000);
		repo.backButton.click();

	}
	
	
	@DataProvider(name = "logindata")
	public String[][]  getData() throws IOException
	{
		String path = ".\\data\\LoginCredential.xlsx";
		XLUtility xlutil = new XLUtility(path);
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcolumn = xlutil.getCellCount("Sheet1", 1);
		
		String loginData[][] = new String [totalrows][totalcolumn];
				for(int i = 1; i<=totalrows ; i++)
				{
					for (int j = 0 ; j<totalcolumn;j++)
					{
						loginData [i-1][j] = xlutil.getCellData(path,"Sheet1", i, j);
					}
				}
				return (loginData);
	}
	
	@Test(dataProvider = "logindata", priority = 2)
	public void loginTest1(String Email,String Password,String Exp) throws InterruptedException
	{			
		Allure.step("Sign In");

		System.out.println("Login Test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		TreatiansPOM repo=new TreatiansPOM(driver);
		
		repo.loginPage();
		repo.loginEmail.sendKeys(Email);
		repo.loginPassword.sendKeys(Password);
		repo.clickSignInButton();

		//Thread.sleep(3000);
		
		if(Exp.equals("valid"))
		{
			System.out.println("Login Credentials are "+Exp);
			String hompage = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[2]/android.widget.TextView")).getText();
			String str1="Home";
			Assert.assertEquals(hompage, str1);
	
				System.out.println("Login Successful");
				repo.elipsis.click();
				repo.logoutButton.click();				
		}
		else if(Exp.equals("invalid"))
		{	
			System.out.println("Login Credentials are "+Exp);
			String createNew = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Create new user\"]/android.widget.TextView")).getText();
			String str2="Create new user";
			Assert.assertEquals(createNew, str2);
			System.out.println("Login Fail");
			repo.backButton.click();
		}

	}
	
		
	@Test(priority = 3)
	public void BookAppointment()
	{
		//this.driver=driver;
		Allure.step("Booking Appointment");

		System.out.println("Booking Appointment");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		TreatiansPOM repo=new TreatiansPOM(driver);
		
		repo.loginDone();

		repo.drAdhishwar.click();

		
		repo.bookAppointment.click();
		
		repo.availableDate.click();
		repo.scrollWindow();
		repo.clickslot();
		repo.bookAppoinmentButton.click();
		System.out.println("booking successful");
		repo.logoutPage();	
	}
	
	@Test(priority = 4)
	public void verifyAppointment()
	{
		Allure.step("Verifying appointment Details");
		System.out.println("Appointment Verification");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		TreatiansPOM repo=new TreatiansPOM(driver);
		
		repo.menu.click();
		repo.LoginOption.click();
		repo.emailEnter();
		repo.passwordEnter();
		repo.clickSignInButton();

		repo.menu.click();
		repo.appointment.click();
		String expDate = "21";
		String expTime = "08:00 - 08:15";
		String actDate = repo.ActDate.getText();
		System.out.println(actDate);
		String actTime = repo.ActTime.getText();
		System.out.println(actTime);
		String expDr = "Adhishwar Sharmaaaa";
		String actDr = repo.drAdhishwar.getText();
		
		if(actDate.contains(expDate))
		{
			if(actTime.contains(expTime))
			{
				Assert.assertEquals(actDr, expDr);
			}
		}
		else
			Assert.assertTrue(2 == 1 );
		
		
		}

	
}
