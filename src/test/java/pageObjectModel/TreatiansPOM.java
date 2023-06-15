package pageObjectModel;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.TreatiansBaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TreatiansPOM extends TreatiansBaseClass
{
	@AndroidFindBy(className="android.widget.TextView")
	public List<WebElement> allText; 
	
	public void TodayDate() 
   	{
        Date today = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd");
        String todayStr = dateFormat.format(today);
        
         
         for(WebElement text: allText)
         {
        	 String name = text.getText();
        	 if(name.equals(todayStr))
        	 {
        		 text.click();
        	 }
         }
   	} 
	//private static final String todaysDate = "23" ;

	public TreatiansPOM(AndroidDriver driver) 
	{	
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.Button")
	public WebElement elipsis ;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"person circle Log in\"]/android.view.View")
	public WebElement LoginOption;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Create new user\"]/android.widget.TextView")
	public WebElement createNewUserButton;
	
	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.widget.ListView/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	public WebElement firstName;
	
	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.widget.ListView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	public WebElement lastName;
	
	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.widget.ListView/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	public WebElement email;
	
	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.widget.ListView/android.view.View[4]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	public WebElement phone;
	
	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.widget.ListView/android.view.View[5]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	public WebElement password;
	
	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.widget.ListView/android.view.View[6]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	public WebElement confirmPassword;
	
	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.widget.ListView/android.view.View[7]/android.view.View/android.view.View/android.view.View/android.view.View")
	public WebElement selectCountry;
	
	@AndroidFindBy(xpath = "//android.view.View[1]/android.widget.Button[2]")
	public WebElement india;
	
	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.widget.ListView/android.view.View[8]/android.view.View/android.view.View/android.view.View/android.view.View")
	public WebElement selectCity;
	
	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.widget.ListView/android.view.View[9]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	public WebElement Address;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Register\")")
	public WebElement register;

	@AndroidFindBy(xpath = "//android.view.View[1]/android.widget.Button[6]")
	public WebElement Gurugram;

	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.widget.ListView/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	public WebElement loginEmail;
	
	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	public WebElement loginPassword;
	
	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.widget.ListView/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button")
	public WebElement signInButton;
	
	@AndroidFindBy(xpath = "//android.view.View[1]/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.EditText")
	public WebElement searchField;
	
	@AndroidFindBy(xpath = "//android.view.View[1]/android.view.View[2]/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.widget.TextView")
	public WebElement citiesScrollDown;
	
	@AndroidFindBy(xpath = "//android.view.View[1]/android.widget.Button[4]")
	public WebElement FaridaBad;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(android.widget.Button).instance(0)")
	public WebElement slotwhenarrownotvisible;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"chevron back\")")
	public WebElement arrow;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(android.widget.Button).instance(2)")
	public WebElement slotwhenarrowvisible;
	

	@AndroidFindBy(xpath = "//android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Button")
	public WebElement backButton;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Adhishwar Sharmaaaa\")")
	public WebElement drAdhishwar;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Dr. Tanvi Bhatt\")")
	public WebElement drTanvi;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Book Appointment\")")
	public WebElement bookAppoinmentButton;
	
	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.widget.Button")
	public WebElement bookAppointment;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"medkit Treatments\"]/android.view.View")
	public WebElement Treatment;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Oncology\")")
	public WebElement Oncology; 
	 
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Urology\")")
	public WebElement Urology;
	   
	//@AndroidFindBy(uiAutomator = "new UiSelector().text(\"" + todaysDate + "\")")
	//public WebElement availableDate;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"My Appointments\")")
	public WebElement myAppointment;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"calendar My Appointments\"]/android.view.View")
	public WebElement appointment;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Home\")")
	public WebElement home;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Appointment Date : 21-Feb-2023\")")
	public WebElement ActDate;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Appointment Time : 08:00 - 08:15\")")
	public WebElement ActTime;
	
	

	public void loginPage()
	{	
		elipsis.click();
		LoginOption.click();
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"menu\")")
	public WebElement menu;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Log out\")")
	public WebElement logoutButton;
	
	public void logoutPage()
	{	
		menu.click();
		logoutButton.click();
	}

	

	public void signUp()
	{	
		elipsis.click();
		LoginOption.click();
		createNewUserButton.click();		
	}
	
	public void createFirstName()
	{
		firstName.click();
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys("Mohd Taha");	
	}
	
	public void createLastName()
	{
		lastName.click();
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.sendKeys("Khan");	
	}
	
	public void passEmail()
	{
		email.click();
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(email));
		email.sendKeys("md@gmail.com");	
	}
	
	public void passPhone()
	{
		phone.click();
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_7));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_7));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_7));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));

	}
	
	public void passPassword()
	{
		password.click();
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys("12345678");
		
	}
	
	public void passconfirmPassword()
	{
		confirmPassword.click();
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(password));
		confirmPassword.sendKeys("12345678");
	}
	
	public void selectCountryScrollDown()
	{
		selectCountry.click();
	}
	
	public void selectIndia()
	{
		india.click();
	}
	
	public void selectCityScrollDown()
	{
		selectCity.click();
	}
	
	public void clickGurugram()
	{
		Gurugram.click();
	}
	
	public void passsAddress()
	{
		//Address.click();
		Address.sendKeys("12/486 Gulzaar baagh, Kathmandu 44600");
	}
	
	public void clickRegister()
	{
		register.click();
	}
	
	
	public void emailEnter()
	{
		loginEmail.click();
		loginEmail.sendKeys("gayaas@gmail.com");
	}
	
	public void passwordEnter()
	{
		loginPassword.click();
		loginPassword.sendKeys("12345678");
	}
	
	public void loginDone()
	{	
		menu.click();
		LoginOption.click();
		loginEmail.sendKeys("gayaas@gmail.com");
		loginPassword.sendKeys("12345678");
		signInButton.click();
	}
	
	public void clickSignInButton()
	{
		signInButton.click();
	}
	
	public void passInSearch()
	{
		searchField.click();
		searchField.sendKeys("adhishwar");
	}
	
	public void selectCity()
	{
		citiesScrollDown.click();
		FaridaBad.click();
	}
	
	public void bookAppoitment()
	{
		bookAppoinmentButton.click();
	}
	

	
	public void scrollWindow()
	{
		WebElement ele01 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.app.Dialog/android.view.View/android.view.View/android.view.View"));
		int centerX = ele01.getRect().x + (ele01.getSize().width/2);
		double startY = ele01.getRect().y + (ele01.getSize().height*0.9);
		double endY = ele01.getRect().y + (ele01.getSize().height*0.1);
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
		Sequence swipe = new Sequence(finger,1);
		swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(),centerX,(int)startY));
		swipe.addAction(finger.createPointerDown(0));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(700),PointerInput.Origin.viewport(),centerX,(int)endY));
		swipe.addAction(finger.createPointerUp(0));
		driver.perform(Arrays.asList(swipe));	
	}
	
	public void logOut()
	{
		elipsis.click();
		logoutButton.click();	
	}
	
	public void loginParameter(String a, String b)
	{
		loginEmail.sendKeys(a);
		loginPassword.sendKeys(b);
		signInButton.click();
	}

	public void docVeri()
	{
		List<WebElement> index = driver.findElements(By.className("android.widget.TextView"));
	}
		
	public void clickslot() 
	{
	PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
	Sequence scrolla = new Sequence(finger1, 1);
	scrolla.addAction(finger1.createPointerMove(Duration.ofMillis(0),
	PointerInput.Origin.viewport(), 500, 1700));
	scrolla.addAction(finger1.createPointerDown(0));
	scrolla.addAction(finger1.createPointerMove(Duration.ofMillis(500),
	PointerInput.Origin.viewport(),500, 300));
	scrolla.addAction(finger1.createPointerUp(0));
	driver.perform(Arrays.asList(scrolla));
	try {
	if(arrow.isDisplayed()) {
		slotwhenarrowvisible.click();
	}
	}
	catch(NoSuchElementException e) 
	{
		slotwhenarrownotvisible.click();
	}

	
	
 }
}

