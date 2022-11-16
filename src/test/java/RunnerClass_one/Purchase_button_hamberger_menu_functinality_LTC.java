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

import DEmo_QA_POM.Amount_String_error_messagePOM6;
import DEmo_QA_POM.Verifying_Page_pom1;
import LiberyFile.BaseClass;

public class Purchase_button_hamberger_menu_functinality_LTC {
WebDriver driver;
	
	@BeforeClass
	public void launchbrwser() throws InterruptedException, EncryptedDocumentException, IOException {
		
		//driver=BaseClass.Launchbrowserall("http://demo-rt-cb-qa-alb-1696234791.us-east-1.elb.amazonaws.com/#/account/email-confirmation?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InByYXZpbmxAbnUxMC5jbyIsImlhdCI6MTY2NjM0Njk5MSwiZXhwIjoxNjY2MzY4NTkxfQ.hIt33j_AAKUZpqpg2_roIFSvNxHwDjy7EngZOWbUmWo");
		driver=BaseClass.Nivapay_Wallet_launch(0, 0, null);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}
	
	@BeforeMethod
	public void clickonPRoceedButtton() {
		Verifying_Page_pom1 p1=PageFactory.initElements(driver, Verifying_Page_pom1.class);
		p1.ClickONProceedButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(9000));
//		DEmo_DashBoard_page_pom2 p2=PageFactory.initElements(driver, DEmo_DashBoard_page_pom2.class);
//		p2.clickonLTCPurchaseButton();
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
	}
	@Test
	public void checkstatus() throws InterruptedException {
		Amount_String_error_messagePOM6 p3=PageFactory.initElements(driver, Amount_String_error_messagePOM6.class);
		p3.enteramount2();
		

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
		  
		
		
		
		
		p3.functionality_pruchseButton();
		
	}
	
	@AfterMethod
	public void screencshot() throws IOException {
		BaseClass.TakesScreenShot();
		
		//Reporter.log("Passed- Verify that user should enter valid amount then purchase button enable", true );

	}
	
	@AfterClass
	public void closebrowser() {
		driver.close();
	}
}

