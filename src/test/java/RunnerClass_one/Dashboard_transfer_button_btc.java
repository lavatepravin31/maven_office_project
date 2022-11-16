package RunnerClass_one;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DAshBoard_pom.Deposit_button_functinality_pom4;
import DAshBoard_pom.Deposit_screen_pom5;
import DAshBoard_pom.Transfer_button_functinality_pom6;
import DAshBoard_pom.Transfer_screen_pom7;
import DAshBoard_pom.Verify_proced_button_pom1;
import LiberyFile.BaseClass;

public class Dashboard_transfer_button_btc {
  
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
	        Transfer_button_functinality_pom6 s2=PageFactory.initElements(driver,Transfer_button_functinality_pom6.class);
	        s2.clickonBTC_Transfer_Button();
		}
		
		@Test
		public void user_LANDING_STATUS() throws InterruptedException {
			
			Thread.sleep(3000);
			Transfer_screen_pom7 s3=PageFactory.initElements(driver, Transfer_screen_pom7.class);
			s3.status_clickon_BTC_Transfer_Button();
//			Reporter.log( "btc tranfer button is clickable user land on deposit page,test case pass", true ); 
//
//			Reporter.log("Passed- Check that functionality of transfer button.(BTC ).",true);

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
