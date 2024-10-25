package marathonTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement search=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("bags for boys");
		search.sendKeys(Keys.ARROW_DOWN);
		
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		//Requirement1:Printing the search result
		WebElement resul=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
		System.out.println("Search Result:"+resul.getText());		
		
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[3]")).click();
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[4]")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		//Requirement2:Print the first info of the bag -name and price
		WebElement prodname=driver.findElement(By.xpath("(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'])[1]"));
		String Productname=prodname.getText();
		System.out.println("Name of the product:"+Productname);
		
		WebElement price=driver.findElement(By.xpath("//span[@class='a-price-whole']"));
		String Offerprice = price.getText();
		System.out.println("Price of the product:"+Offerprice);
		
		//Requirement3:Print title of the page
		System.out.println("Title of the Page:"+driver.getTitle());
		driver.close();
	}

}
