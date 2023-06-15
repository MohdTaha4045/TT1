package pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import baseClass.TreatiansBaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUp extends TreatiansBaseClass 
{
	public SignUp(AndroidDriver driver) 
	{	
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign up\")")
	public WebElement signUp;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"First name*\")")
	public WebElement firstName;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Last name*\")")
	public WebElement lastName;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"E-mail*\")")
	public WebElement email;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Mobile number*\")")
	public WebElement mobileNumber;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Select Country\")")
	public WebElement selectCountry;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView")
	public WebElement india ;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Select City\")")
	public WebElement selectCity;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Password*\")")
	public WebElement password;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Confirm Password*\")")
	public WebElement confirmPassword;
	
	
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Address\")")
	public WebElement address;
	

	public void createANewUser(String first,String last,String eMail,String number,String pass,String conpass,String add ) throws InterruptedException
	{
		signUp.click();
		firstName.sendKeys(first);
		lastName.sendKeys(last);
		email.sendKeys(eMail);
		mobileNumber.sendKeys(number);
		selectCountry.click();
		india.click();
		password.sendKeys(pass);
		confirmPassword.sendKeys(conpass);
		Thread.sleep(2000);
		scrollWindow();
		address.sendKeys(add);
		signUp.click();

		
	}

}
