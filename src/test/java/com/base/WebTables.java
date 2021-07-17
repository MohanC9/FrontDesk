package com.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {
	public static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("/html/body/div[2]/div/div/main/article/div/div/table/tbody/tr[78]/td[3]"));
		List<WebElement> count = driver.findElements(By.xpath("/html/body/div[2]/div/div/main/article/div/div/table/tbody/tr"));
		List<WebElement> count1 = driver.findElements(By.xpath("/html/body/div[2]/div/div/main/article/div/div/table/tbody/tr/td"));

		System.out.println(count.size());
		for(int i=1;i<=count.size(); i++) {

			WebElement hi = driver.findElement(By.xpath("/html/body/div[2]/div/div/main/article/div/div/table/tbody/tr["+i+"]"));

			System.out.println(hi.getText());


			for(int j=1; j<=count1.size(); j++) {		

				WebElement hii = driver.findElement(By.tagName("td["+j+"]"));
				System.out.println(hii.getText());

			}






		}	
		//*[@id="countries"]/tbody/tr[78]  
		//*[@id="countries"]/tbody/tr[78]/td[1]


		List<WebElement> hii = driver.findElements(By.partialLinkText("New Delhi"));

	}

}
