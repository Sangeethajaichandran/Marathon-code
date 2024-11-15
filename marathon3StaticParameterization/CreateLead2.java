package marathon3StaticParameterization;

import org.openqa.selenium.By;
import org.testng.annotations.Test;



public class CreateLead2 extends BaseClass{
@Test

	public void newCreate() {
		
	driver.findElement(By.linkText("Leads")).click();
	driver.findElement(By.linkText("Create Lead")).click();
	driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
	driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Dilip");
	driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Kumar");
	driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("99");
	driver.findElement(By.name("submitButton")).click();
	String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
	if (text.contains("Testleaf")) {
		System.out.println("Lead created successfully");
	}
	else {
		System.out.println("Lead is not created");
	}
	
		
		}
}






