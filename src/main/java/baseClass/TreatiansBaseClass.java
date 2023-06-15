package baseClass;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;


import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;

public class TreatiansBaseClass 
{
		public static  AndroidDriver driver;
		/*@BeforeSuite
		public void setUp() {
		    // Start Appium server in a separate thread
		    Thread appiumThread = new Thread(this::startAppium);
		    appiumThread.start();

		    // Start emulator in a separate thread
		    Thread emulatorThread = new Thread(this::startEmulator);
		    emulatorThread.start();

		    // Wait for both threads to finish
		    try {
		        appiumThread.join();
		        emulatorThread.join();
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		}

		public void startAppium() {
		    try {
		        // Start the Appium server
		        String command = "appium -a 127.0.0.1 -p 4723";
		        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
		        Process process = builder.start();

		        // Read the output of the window
		        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		        String line;
		        while ((line = reader.readLine()) != null) {
		            System.out.println(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}

		public void startEmulator() {
		    try {
		        // Navigate to the emulator directory
		        String command1 = "cd C:\\Users\\Fleek\\AppData\\Local\\Android\\Sdk\\emulator";
		        ProcessBuilder builder1 = new ProcessBuilder("cmd.exe", "/c", command1);
		        builder1.directory(new File("C:\\Users\\Fleek\\AppData\\Local\\Android\\Sdk\\emulator"));
		        builder1.start();

		        // Start the emulator
		        String command2 = "emulator -avd Pixel_4_XL_API_30";
		        ProcessBuilder builder2 = new ProcessBuilder("cmd.exe", "/c", command2);
		        builder2.directory(new File("C:\\Users\\Fleek\\AppData\\Local\\Android\\Sdk\\emulator"));
		        Process process = builder2.start();

		        // Read the output of the window
		        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		        String line;
		        while ((line = reader.readLine()) != null) {
		            System.out.println(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}*/
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
		
		public void webSetUp()
		{
			
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

