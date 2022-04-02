package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class SetupDriverExamples {
	public static void main(String[] args) throws InterruptedException
	{

		WebDriverManager.chromedriver().setup();

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		chromeOptions.addArguments("--start-maximized");
		//chromeOptions.addArguments("--headless");



		WebDriver driver = new ChromeDriver(chromeOptions);

	//	((JavascriptExecutor)driver).executeScript("window.open");

		driver.get("http://rambler.ru");

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://www.google.com");

		List<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));

			Thread.sleep(5000);

		driver.close();
		Thread.sleep(5000);
		driver.quit();

	}
}
