package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumStart {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");

		WebDriverManager.chromedriver().setup();


		Thread.sleep(5000);
		driver.quit();


	}


}
