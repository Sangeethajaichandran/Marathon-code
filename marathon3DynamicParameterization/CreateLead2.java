package marathon3DynamicParameterization;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class CreateLead2 extends BaseClass{
	@DataProvider(name="newlead")
	public String[][] senddatas() {
		String[][] leads=new String[2][4];
		leads[0][0]= "hewitt";
		leads[0][1]= "Sangeetha";
		leads[0][2]= "E";
		leads[0][3]= "98";
		leads[1][0]= "excelacom";
		leads[1][1]= "hema";
		leads[1][2]= "s";
		leads[1][3]= "97";
		return leads;
		}
	
@Test(dataProvider="newlead")
public void newCreate(String cname,String fname,String lname,String phnum) {
		
	driver.findElement(By.linkText("Leads")).click();
	driver.findElement(By.linkText("Create Lead")).click();
	driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
	driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
	driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
	driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phnum);
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






