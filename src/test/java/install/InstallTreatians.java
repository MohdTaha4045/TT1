package install;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class InstallTreatians 
{
	public static void main(String[] args) throws MalformedURLException 
	{
		 {
				DesiredCapabilities dc = new DesiredCapabilities();
			
				dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
				dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); 
				//dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "Tiramisu");
				dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
				dc.setCapability("androidInstallTimeout", 120000); // Set the timeout to 120 seconds (adjust as needed)

				dc.setCapability(MobileCapabilityType.APP, "C:\\APKfiles\\app-release-14-06-2023.apk");				
				
				URL url = new URL("http://127.0.0.1:4723/wd/hub");
				
				AndroidDriver driver = new AndroidDriver(url,dc);
				System.out.println("App installed");
				
				driver.quit();
		}


	}
}
