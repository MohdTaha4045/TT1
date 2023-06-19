package pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage 

{
	@AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.ImageView")
	public WebElement menu ;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Home\")")
	public WebElement home;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Wallet\")")
	public WebElement wallet;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Pharmacy\")")
	public WebElement pharmacy;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enquiry\")")
	public WebElement enquiry;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Our Services\")")
	public WebElement ourServices;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Change Password\")")
	public WebElement changePassword;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Logout\")")
	public WebElement logout;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[2]")
	public WebElement appointments ;
	
	@AndroidFindBy(xpath = "/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[3]")
	public WebElement doctor ;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[4]")
	public WebElement hospitals ;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[5]")
	public WebElement treatments ;
	
	

	
}
