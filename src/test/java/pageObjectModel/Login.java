package pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

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
	
	public void signIN(String username , String pass)
	{
	
		email.sendKeys(username);
		click.click();
		password.sendKeys(pass);
		signInButton.click();
	}
}
