package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import test.testTreatians;

public class Login 
{

	public Login(AndroidDriver driver) 
	{	
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView")
	public WebElement signin ;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Email*\")")
	public WebElement email;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login\")")
	public WebElement loginAfterSignUp;
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.ImageView")
	public WebElement click ;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Password*\")")
	public WebElement password;
	

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign In\")")
	public WebElement signInButton;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Treatians\")")
	public WebElement homePageText;
    
    
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.Button")
	public WebElement menu ;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
	public WebElement profileButton;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView")
	public WebElement openProfileButton;
	
	
	@AndroidFindBy(xpath="//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView[2]")
	public WebElement UpdatedNumber;
	
	public void signIN(String username , String pass) throws InterruptedException
	{
	
		email.sendKeys(username);
		click.click();
		password.sendKeys(pass);
		signInButton.click();
		Thread.sleep(2000);
	}
	public void userDetailsUpdatedVerify() throws InterruptedException 
	{
		testTreatians tt1 = new testTreatians();
		profileButton.click();
		Thread.sleep(2000);
		openProfileButton.click();
		String numberUpdated =UpdatedNumber.getText();
		System.out.println(numberUpdated);
		System.out.println(tt1.UPDATEDNUMBER);
		
		if(numberUpdated.contains(tt1.UPDATEDNUMBER))
		{	
		Assert.assertTrue(true);
		System.out.println("Number is Verified");
		}
		  else Assert.assertFalse(true);
		 
	}
}
