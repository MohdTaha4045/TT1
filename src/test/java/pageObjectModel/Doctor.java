package pageObjectModel;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class Doctor 
{
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Dr. Tanvi Bhatt \")")
	public WebElement drTanviBhatt ;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Book Appointment\")")
	public WebElement bookAppointment ;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[2]")
	public WebElement appointments;
	

}
