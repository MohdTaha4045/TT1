package Web;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTest 
{
	WebDriver driver = null ;
	public void webcall() throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rlv-01-core-shared-ui-cia-test.azurewebsites.net/#/cms/home?country=IN");
		
		Thread.sleep(3000);
	}
	
	

}
