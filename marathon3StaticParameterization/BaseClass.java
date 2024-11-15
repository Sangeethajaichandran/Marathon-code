package marathon3StaticParameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
public class BaseClass {
public RemoteWebDriver driver;

@Parameters({"browser","url","username","password"})

@BeforeMethod
public void preconditions(String browser,String url,String uname,String pword)
	{
	if(browser.equalsIgnoreCase("Chrome")) {
		driver = new ChromeDriver();
	}
	if(browser.equalsIgnoreCase("Edge")) {
		driver = new EdgeDriver();
	}
		if(browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();}
@AfterMethod
public void postcondition()
{driver.close();
	}
}
