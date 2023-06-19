package Web;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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
	

	@FindBy(xpath ="//input[@type='text']")
	public WebElement emailAdminTextFeild;
	
	@FindBy(xpath = "//input[@type='password']")
	public WebElement passwordAdminTextFeild;
	
	@FindBy(xpath = "//input[@type='password']")
	public WebElement password;
	
	@FindBy(xpath = "//button[normalize-space()=\"Sign In\"]")
	public WebElement signInButton;
	

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
	
	@FindBy(xpath = "//div[@class= 'row'][3]/div[2]/mat-form-field/div")
	public WebElement dropdown;
	
	@FindBy(xpath ="//span[text()='Gurugram']")
	public WebElement updateCity;
		
	@FindBy(xpath = "//button[text()='Save']")
	public WebElement saveButton;

	
	public void webcall() throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		driver1=new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver1.get("https://rlv-01-core-shared-ui-cia-test.azurewebsites.net/#/cms/login?country=IN");
		
		Thread.sleep(3000);
	}
	
	
	public void WebLogin(String username, String pass) throws InterruptedException 
	{	
		email.click();
		email.sendKeys(username);
		
		password.click();
		password.sendKeys(pass);
		
		signInButton.click();
	}
	
	public void emailVerification() throws InterruptedException 
	{	
		
		
		String VerifyUsername = driver1.findElement(By.xpath("//div[@title='" + testTreatians.USERNAME +"']")).getText();
		Assert.assertEquals(VerifyUsername, testTreatians.USERNAME, "User Is Listed");
		
	}
	public void UpdateUserDetailsFromAdminSide(String updatedNumber) throws InterruptedException {
		
		WebElement element=driver1.findElement(By.xpath("//tbody[1]/tr[1]/th[1]"));
		Thread.sleep(2000);
		element.click();
		
				
		WebElement e1 = driver1.findElement(By.xpath("//input[@type='number']"));
		e1.clear();
		e1.sendKeys(updatedNumber);
		Thread.sleep(3000);
 
		dropdown.click();
		updateCity.click();
		
		saveButton.click();
	}
	
	public void AdminWebVerification() throws InterruptedException 
	{	
		emailAdminTextFeild.clear();
		emailAdminTextFeild.click();
		emailAdminTextFeild.sendKeys("admin@rlv.com");
		
		passwordAdminTextFeild.clear();
		passwordAdminTextFeild.click();
		passwordAdminTextFeild.sendKeys("password");
		
		signInButton.click();
		
		
	}

}




















//div[@title='"+testTretians.firstname+" "+testTreatians.lastname+"']"

//div[@title="gayas khan"]
		//div[@title='" + testTreatians.firstname + " " + testTreatians.lastname + "']
