package pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUp 
{
	public SignUp(AndroidDriver driver) 
	{	
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView")
	public WebElement signUp ;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign up\")")
	public WebElement signUp;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign up\")")
	public WebElement signUp;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign up\")")
	public WebElement signUp;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign up\")")
	public WebElement signUp;

}
