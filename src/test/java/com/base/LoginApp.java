package com.base;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginApp {
	public static WebDriver driver;
	
public static void switchtochildwindows() {
		
		String parentwindowid=driver.getWindowHandle();
		
		System.out.println(parentwindowid);
		
		java.util.Set<String> allwindowids=driver.getWindowHandles();
		
		System.out.println(allwindowids);
		
		for(String each:allwindowids)
			
		{
			
			if(!parentwindowid.equals(each))
				
			{
				
				driver.switchTo().window(each);

			}
		}
			
		}


public static void switchtomainwindow() {
	
	String parentwindowid=driver.getWindowHandle();
	
	System.out.println(parentwindowid);
	
	java.util.Set<String> allwindowids=driver.getWindowHandles();
	
	System.out.println(allwindowids);
	
	for(String each:allwindowids)
		
	{
		
		if(!parentwindowid.equals(each))
			
		{
			
			driver.switchTo().window(each);

			driver.switchTo().window(parentwindowid);
			
		}
	}
}
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://frontdesk.corp.ojas-it.com/");
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Emp@Ojas-it.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Ojas@1525");
		driver.findElement(By.xpath("//button[@name='btn_login']")).click();
		
		
		
		
		
		
		driver.findElement(By.xpath("//*[@id=\"dropdown\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"dropdown-lvl3\"]/div/ul/li[1]/a")).click();
		
		List<WebElement> ele  = driver.findElements(By.xpath("//a[@aria-controls='myCandidates']"));
		System.out.println(ele.size());
		for(int i=1; i<=ele.size(); i++) {
		
				if(i== 5) {
					System.out.println("Hiii");
					switchtomainwindow();
				}
				
				else {
					driver.findElement(By.xpath("(//a[@aria-controls='myCandidates'])["+i+"]")).click();
					Thread.sleep(3000);
				}
				
				
		}		
	}
}
