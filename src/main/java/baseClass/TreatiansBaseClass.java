package baseClass;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;


import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;

public class TreatiansBaseClass 
{
		public static  AndroidDriver driver;
		public static WebDriver driver1;
		
		@SuppressWarnings("deprecation")
		@BeforeClass
		public void setup() throws MalformedURLException, InterruptedException
	 
		{
			DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("deviceName", "Pixel 3 XL API 30");
		        cap.setCapability("uuid", "emulator-5554");
		        cap.setCapability("platformName", "Android");
		        cap.setCapability("platformVersion", "11.0");
		        cap.setCapability("appPackage", "com.treatians");
		        cap.setCapability("appActivity", "com.treatians.MainActivity");	        
				URL url = new URL("http://0.0.0.0:4723/wd/hub");
				 driver = new AndroidDriver(url, cap);
				 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				 System.out.println("Driver is launched");
		}
		
		public void scrollWindow()
		{
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			   Sequence tap = new Sequence(finger, 1);
			   tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
			   PointerInput.Origin.viewport(), 655, 1920));
			   tap.addAction(finger.createPointerDown(0));
			   tap.addAction(finger.createPointerMove(Duration.ofMillis(100),
			   PointerInput.Origin.viewport(),655, 1520));
			   tap.addAction(finger.createPointerUp(0));
			   driver.perform(Arrays.asList(tap));	
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
		
		/*
		 * @AfterTest public void tearDown() { driver.quit(); }
		 */
		
		public void onTestFailure(ITestResult result) 
		{
			// TODO Auto-generated method stub
		}
 
}

