package marathonTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PVRCinemas {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//span[@class='cinemas-inactive']")).click();
		driver.findElement(By.xpath("//span[text()='Select Cinema']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='INOX National,Virugambakkam Chennai']")).click();
		
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//span[text()='Select Date']")).click();
		driver.findElement(By.xpath("//span[text()='Tomorrow']")).click();
		
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//span[text()='Select Movie']")).click();
		driver.findElement(By.xpath("(//span[text()='BLACK'])[2]")).click();
		
		//driver.findElement(By.xpath("(//span[text()='Select Timing']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='10:30 PM']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Book']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		
		WebElement Seat=driver.findElement(By.xpath("(//span[text()='13'])[5]"));
		Seat.click();
		String Seatnum=Seat.getText();
		
		//Requirement1:Printing Seat NUmber
		System.out.println("Seat Number:"+Seatnum);
		//Requirement2:printing GrandTotal
		WebElement grand=driver.findElement(By.xpath("//div[@class='grand-prices']"));
		String grandtotal=grand.getText();
		System.out.println("grandtotal:"+grandtotal);
		
		//Requirement3:printing home page title
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//i[@class='pi pi-times'])[2]")).click();
		Thread.sleep(5000);
		System.out.println("Title of the page:"+driver.getTitle());
	}

}
