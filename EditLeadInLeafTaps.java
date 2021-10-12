package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeadInLeafTaps {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("//a[text()='Leads']")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.linkText("Find Leads")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("(//input[@type='text' and @name='firstName'])[3]")).sendKeys("Christy");
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("//button[@type='button' and text()='Find Leads']")).click();
		Thread.sleep(4000);
	    
	    driver.findElement(By.xpath("(//a[@href='/crmsfa/control/viewLead?partyId=16876'])[1]")).click();
	    Thread.sleep(2000);
	    
	    String text = driver.findElement(By.xpath("//div[@id='sectionHeaderTitle_leads']")).getText();
		System.out.println(text);
		Thread.sleep(4000);
		
		String company = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(company);
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(" Updated ");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//input[@class='smallSubmit' and @name='submitButton'])[1]")).click();
		Thread.sleep(4000);
		
		
		String updateCompany = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Updated Company:" +updateCompany);
		
	    

	}

}
