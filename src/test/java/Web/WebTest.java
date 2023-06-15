package Web;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.TreatiansBaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import test.testTreatians;

public class WebTest extends TreatiansBaseClass 
{	
	
	public WebTest(WebDriver driver1)
	{
		this.driver1=driver1;
		PageFactory.initElements(driver1, this);
	}
	
	testTreatians tt1 = new testTreatians();
	
	@FindBy(id = "mat-input-0")
	public WebElement email;
	
	@FindBy(xpath = "//input[@type='password']")
	public WebElement password;
	
	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	public WebElement signIn;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	public WebElement logInButtonHomePage;
	
	@FindBy(xpath = "//img[@alt='User image']")
	public WebElement userImage;
	
	@FindBy(xpath = "/a[normalize-space()='Profile']")
	public WebElement Profile;
	
	@FindBy(xpath = "//a[normalize-space()='Log out']")
	public WebElement logout;
	
	@FindBy(xpath = "//span[text()='Users']")
	public WebElement userButtonAdmin;

	
	public void webcall() throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		driver1=new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver1.get("https://rlv-01-core-shared-ui-cia-test.azurewebsites.net/#/cms/login?country=IN");
		
		Thread.sleep(3000);
	}
	
	public void emailVerification() throws InterruptedException 
	{	
		driver1.findElement(By.xpath("//div[contains(text(),'" + tt1.USERNAME + "')]"));
	}
	
	public void WebVerification(String username, String pass) throws InterruptedException 
	{	
		email.click();
		email.sendKeys(username);
		
		password.click();
		password.sendKeys(pass);
		
		signIn.click();
	}

}
