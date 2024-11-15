package marathon3DynamicParameterization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class EditLead extends BaseClass {
	@DataProvider
	public String[][] senddatas() {
		String[][] data=new String[2][2];
		data[0][0]= "hewitt";
		data[0][1]= "98";
		data[1][0]= "excelacom";
		data[1][1]= "97";
		
		return data;
		}
@Test(dataProvider="senddatas")
	public void newEdit(String cname,String phname) throws InterruptedException {
		
		
	driver.findElement(By.linkText("Leads")).click();
	driver.findElement(By.linkText("Find Leads")).click();
	driver.findElement(By.xpath("//span[text()='Phone']")).click();
	driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phname);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.findElement(By.linkText("Edit")).click();
	WebElement companyName = driver.findElement(By.id("updateLeadForm_companyName"));
	companyName.clear();
	companyName.sendKeys(cname);
	driver.findElement(By.name("submitButton")).click();
	String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
	if (text.contains("TCS")) {
		System.out.println("Lead is edited successfully");
	}
	else {
		System.out.println("Lead is not edited");
	}
	



}
}






