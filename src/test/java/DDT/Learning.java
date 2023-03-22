package DDT;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generalUtility.XLUtility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Learning 
{
	static AndroidDriver driver;
	@BeforeMethod
	public void setup() throws MalformedURLException, InterruptedException
 
	{
		DesiredCapabilities  cap = new DesiredCapabilities();
		 cap.setCapability("deviceName", "Pixel 4XL API 30");
	        cap.setCapability("uuid", "emulator-5554");
	        cap.setCapability("platformName", "Android");
	       // cap.setCapability("platformVersion", "7");
	        cap.setCapability("appPackage", "com.treatians");
	        cap.setCapability("appActivity", "com.treatians.MainActivity");	        
			URL url = new URL("http://0.0.0.0:4723/wd/hub");
			 driver = new AndroidDriver(url, cap);
			// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 System.out.println("Driver is launched");
			 
	}
	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException
	{
		String path = "C:\\Users\\Fleek\\eclipse-workspace\\Testing.Treatians\\data\\LoginCredential.xlsx";
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
				return loginData;
		/*String loginData[][]= {
								{"gayaas@gmail.com","12345678","valid"},
								{"123@gmail.com","4321","invalid"},
								{"gayaas@gmail.com","87654321","invalid"},
								{"gayaas@","12345678","invalid"}
							  };
		
		return loginData;*/
	}
	
	
	@Test(dataProvider = "LoginData")
	public void loginTest(String user,String pwd,String Exp)
	{

		WebElement elipsis = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.Button"));
		elipsis.click();
		
		WebElement LoginOption = driver.findElement(By.xpath("//android.view.View[@content-desc=\"person circle Log in\"]/android.view.View"));
		LoginOption.click();
		
		WebElement loginEmail = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.ListView/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText"));
		loginEmail.click();
		loginEmail.sendKeys(user);
		
		WebElement loginPassword = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.ListView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText"));
		loginPassword.click();
		loginPassword.sendKeys(pwd);
		
		WebElement signInButton = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.ListView/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button"));
		signInButton.click();
		
//		WebElement logOutButton = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ListView/android.view.View[8]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.TextView"));
//        WebElement verify=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.Button"));
//        Actions act=new Actions(driver);
//        act.moveToElement(verify).perform();
		//WebElement lt=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.Button"));
		//lt.click();
        
	if(Exp.equals("valid"))
	{
		System.out.println("Login Credentials are "+Exp);
		WebElement menu = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.Button"));
		Assert.assertTrue(menu.isDisplayed());
		System.out.println("1st assert");
	
	}
	else if(Exp.equals("invalid"))
	{	
		System.out.println("Login Credentials are "+Exp);
		String createNew = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Create new user\"]/android.widget.TextView")).getText();
		String str="Create new user";
		Assert.assertEquals(createNew, str);
		System.out.println("2nd assert");
		
	}
		
	}
	 @AfterTest()
	public void tearDown()
	{
		driver.quit();
	}
				
			
		

		


		

}
