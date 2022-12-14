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

import DAshBoard_pom.Deposit_button_functinality_pom4;
import DAshBoard_pom.Deposit_screen_pom5;
import DAshBoard_pom.Verify_proced_button_pom1;
import LiberyFile.BaseClass;

public class Deposite_hamberger_menu_click {
 
	 WebDriver driver;
		
		@BeforeClass
		public void launchbrowser() throws InterruptedException, EncryptedDocumentException, IOException {
			
		  // driver=BaseClass.Launchbrowserall("http://demo-rt-cb-qa-alb-1696234791.us-east-1.elb.amazonaws.com/#/account/email-confirmation?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InByYXZpbmxAbnUxMC5jbyIsImlhdCI6MTY2Njg0NDI3OCwiZXhwIjoxNjY2ODY1ODc4fQ.JoSu7zfXlzm6p1S4L8mx5DROlMPxzDI114gcTz3IIXw");
			driver=BaseClass.Nivapay_Wallet_launch(0, 0, null);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));	
		}
		
		@BeforeMethod
		public void clickonprocedbutton() throws InterruptedException {
			
			Verify_proced_button_pom1 s1 = PageFactory.initElements(driver, Verify_proced_button_pom1.class);
	        s1.ClickONProceedButton();
	        Thread.sleep(3000);
	        Deposit_button_functinality_pom4 s2=PageFactory.initElements(driver,Deposit_button_functinality_pom4.class);
	         s2.clickon_BTC_deposit_Button();
		}
		
		@Test
		public void user_LANDING_STATUS() throws InterruptedException {
			
			Thread.sleep(3000);
			Deposit_screen_pom5 s3=PageFactory.initElements(driver, Deposit_screen_pom5.class);
			s3.status_clickon_BTC_Deposit_Button();
			//Reporter.log( "Passed-Check that functinality of Deposit button.(btc )", true ); 

			 try {
				  WebElement s22 = driver.findElement(By.xpath("//div[@class='header']//div[@class='nav-bar']"));
				  s22.click();
				
			} catch (org.openqa.selenium.StaleElementReferenceException ex ) {
				 WebElement s22 = driver.findElement(By.xpath("//div[@class='header']//div[@class='nav-bar']"));
				  s22.click();
			}
			  
			  WebElement profile = driver.findElement(By.xpath("//li[text()='Profile']"));
			  
			  
			 
			  if (profile.isDisplayed()) {
					
				  Reporter.log("Profile menu showing ,meaning user is  landing on hamberger menu",true);
				  Reporter.log("Passed- Hambermenu is Clickable",true);
			  }
			  
			  else {
				  Reporter.log("Profile menu not showing ,meaning user is not landing  on hamberger menu",true);
				  Reporter.log("failed- Hambermenu is Clickable",true);
			}
			  }
		
		
		@AfterMethod
		public void takescreenshot() throws IOException {
			BaseClass.TakesScreenShot();
		}
		@AfterClass
		public void closebrowser() {
			
			driver.close();
		}
}


