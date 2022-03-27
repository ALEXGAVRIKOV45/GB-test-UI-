package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class ConvertUSDTest {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		chromeOptions.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.get("http://rambler.ru");
		driver.findElement(By.xpath("//a[@href='https://finance.rambler.ru/currencies/USD/?utm_source=head&utm_campaign=self_promo&utm_medium=header&utm_content=finance_media']")).click();
		List<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));


		driver.findElement(By.xpath("//label[@for='bank_forex']")).click();
		driver.findElement(By.xpath("//label[@for='period_quarter']")).click();
		driver.findElement(By.xpath("//input[@class=\"finance-input converter__input\"]")).sendKeys("150");
		driver.findElement(By.xpath("//span[@class=\"rui-Button-content\"]")).click();

		Thread.sleep(5000);
		driver.quit();


	}


}
