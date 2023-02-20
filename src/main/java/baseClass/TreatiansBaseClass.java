package baseClass;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;

public class TreatiansBaseClass 
{
		public static AndroidDriver driver;
		@SuppressWarnings("deprecation")
		@BeforeClass
		public static void setup() throws MalformedURLException, InterruptedException
	 
		{
			DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("deviceName", "Pixel 4XL API 30");
		        cap.setCapability("uuid", "emulator-5554");
		        cap.setCapability("platformName", "Android");
		       // cap.setCapability("platformVersion", "7");
		        cap.setCapability("appPackage", "com.treatians");
		        cap.setCapability("appActivity", "com.treatians.MainActivity");	        
				URL url = new URL("http://0.0.0.0:4723/wd/hub");
				 driver = new AndroidDriver(url, cap);
				 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				 System.out.println("Driver is launched");
		}
		public void failedTest(String testMethod , AndroidDriver driver) throws IOException
		{
			
			TreatiansBaseClass.driver = driver;
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Date currentdate = new Date();
			String screenshotFileName = currentdate.toString().replace(" ", "_").replace(":", "_");;
			FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenshotFileName+".png"));
			Allure.attachment(screenshotFileName, new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));		
		}	
		
		@AfterTest
		public void tearDown()
		{
			driver.quit();
		}
		
		public void onTestFailure(ITestResult result) 
		{
			// TODO Auto-generated method stub
		}

}

