package RunnerClass_one;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Hamberger_Window_all_pom.HambergerMenu_LOgoutpage_Window_pom7;
import Hamberger_Window_all_pom.Hamberger_landing_on_dashboard_pom2;
import Hamberger_Window_all_pom.Hamberger_pom1;
import LiberyFile.BaseClass;

public class hAmberger_menu_clicking_on_LOgout_POPup_menu {
 
	WebDriver driver;
	@BeforeClass
	public void openbrowser() throws InterruptedException, EncryptedDocumentException, IOException {
		
//		driver=BaseClass.Launchbrowserall("http://demo-rt-cb-qa-alb-1696234791.us-east-1.elb.amazonaws.com/#/account/email-confirmation?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InByYXZpbmxAbnUxMC5jbyIsImlhdCI6MTY2ODEzODc0OSwiZXhwIjoxNjY4MTYwMzQ5fQ.IwE8MH4aBP3_uA-FVqmgX6V-yOz1lfZhNM-Y-alr5pE");
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver=BaseClass.Nivapay_Wallet_launch(0, 0, null);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}
	
	@BeforeMethod
	public void click_on_proceed_button() {
		 Hamberger_pom1 s1=PageFactory.initElements(driver, Hamberger_pom1.class);
		  
		  s1.ClickONProceedButton();
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}
	
	@Test
	  public void click_on_logout_Menu() throws InterruptedException {
		
	  try {
		  WebElement s22 = driver.findElement(By.xpath("//div[@class='header']//div[@class='nav-bar']"));
		  s22.click();
		
	} catch (org.openqa.selenium.StaleElementReferenceException ex ) {
		 WebElement s22 = driver.findElement(By.xpath("//div[@class='header']//div[@class='nav-bar']"));
		  s22.click();
	}
	  
	  Thread.sleep(5000);
	  WebElement profile = driver.findElement(By.xpath("//li[text()='Profile']"));
	  
	  
	 
	  if (profile.isDisplayed()) {
			
		  Reporter.log("Profile menu showing ,meaning user is  landing on hamberger menu",true);
		  //Reporter.log("Passed- Hambermenu is Clickable",true);
	  }
	  
	  else {
		  Reporter.log("Profile menu not showing ,meaning user is not landing  on hamberger menu",true);
		 // Reporter.log("failed- Hambermenu is Clickable",true);
	}
	  
	  

  
  HambergerMenu_LOgoutpage_Window_pom7 s1=PageFactory.initElements(driver, HambergerMenu_LOgoutpage_Window_pom7.class);
  s1.logoutbuttonclick();
  Thread.sleep(4000);
  s1.logoutbuttonclick1popup();
  s1.validation();
  s1.after_click_on_logoutpop_validation();
}
  
  @AfterMethod
	public void screenshot() throws IOException {
		BaseClass.TakesScreenShot();
	}
  
	@AfterClass
	public void closebrowser() {
		
		driver.close();
	}
	
	  
  }













