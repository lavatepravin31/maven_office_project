package Payment_gatwway_all_pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class lastname_field_enter_sp_symbol {
WebDriver driver;
	
	@FindBy(id="cardNumber")
	WebElement cardnumber;
	
	@FindBy(xpath="//input[@placeholder='Expiry']")
	WebElement Expirydate;
	
	@FindBy(xpath="//input[@placeholder='cvv*']")
	WebElement CVV;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement FIRSTname;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement LAstname;
	
	@FindBy(xpath="(//select[@class='ng-untouched ng-pristine ng-invalid'])[1]")
	WebElement CountryDropdown;
	
	@FindBy(xpath="//select[@formcontrolname='state']")
	WebElement STatedropdown;
	
	@FindBy(xpath="//select[@formcontrolname='city']")
	WebElement CITYdropdown;
	
	@FindBy(xpath="//input[@formcontrolname='zip']")
	WebElement zipcode;
	
	@FindBy(xpath="//input[@formcontrolname='street']")
	WebElement STREETfield;
	
	@FindBy(xpath="//input[@formcontrolname='emailAddress']")
	WebElement Emailid;
	
	@FindBy(xpath="//input[@formcontrolname='phoneNumber']")
	WebElement phonenumber;
	
	@FindBy(xpath="//input[@data-mat-calendar='mat-datepicker-0']")
	WebElement Calender;
	
	@FindBy(xpath="//button[text()='Continue']")
	WebElement continuebutton;

	@FindBy(xpath = "//mat-error[text()='Enter valid Last Name']")
	WebElement lastname_field_errorMessage;
	
	
	
	public lastname_field_enter_sp_symbol(WebDriver driver) {
		this.driver=driver;
	}
	
	public void enterDATA() throws InterruptedException {
		cardnumber.sendKeys("4001919257537193");
		Expirydate.sendKeys("12/26");
		CVV.sendKeys("465");
		FIRSTname.sendKeys("pravin");
		LAstname.sendKeys("@#$%^&*");
		Reporter.log("Enter sp symbol value in last name field",true);
		Thread.sleep(2000);
		Select s=new Select(CountryDropdown);
		s.selectByVisibleText("India");
		Thread.sleep(2000);
		
		Select s1=new Select(STatedropdown);
		s1.selectByVisibleText("Maharashtra");
		Thread.sleep(2000);
		
		Select s2=new Select(CITYdropdown);
		s2.selectByVisibleText("Achalpur");
		Thread.sleep(2000);
		zipcode.sendKeys("1234567");
		STREETfield.sendKeys("mg road ");
		Emailid.sendKeys("pravinl@nu10.co");
		phonenumber.sendKeys("9970076686");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@aria-label='Open calendar']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='Choose month and year']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='1999']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()=' JAN ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()=' 1 ']")).click();
		
		Thread.sleep(4000);
	}
	
	public void clickoncontinuebutton() {
		continuebutton.click();
	}
	public void continuebutton_status() {
	
		if (continuebutton.isEnabled()) {
			
			System.out.println("contiune button is enable " );
			Reporter.log("contiune button is enable",true);
		}
		else {
			System.out.println("contiune button is disable");
			Reporter.log("contiune button is disable",true);
		}
	}
	public void lastname_error_message() {
	       if (lastname_field_errorMessage.isDisplayed()) {
	    	   String mesg = lastname_field_errorMessage.getText();
	    	   System.out.println("Error message is  :: "+mesg);
				
				System.out.println("lastname field Error message is showing when user enter interger value " );
				Reporter.log("passed-Verify user should not enter special character in last name field on screen.",true);	
			}
			else {
				System.out.println("lastname field  Error message is not showing ");
				Reporter.log("failed-Verify user should not enter special character in last name field on screen.",true);
			}
}}

//TC 18.1.50-Verify user should not enter special character in last name field on screen.


