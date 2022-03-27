package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EmailSendTest {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		chromeOptions.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.get("http://sup-kurgan.ru");
		driver.findElement(By.xpath("//a[.='Контакты']")).click();
		driver.findElement(By.xpath("//input[@name=\"wb_input_0\" and @type = \"text\"]")).sendKeys("Test Name");
		driver.findElement(By.xpath("//input[@name=\"wb_input_1\" and @type = \"text\"]")).sendKeys("Test@test_domen.ru");
		driver.findElement(By.xpath("//textarea[@name=\"wb_input_2\"]")).sendKeys("Я вам пишу! Чего же боле ? Что я могу еще сказать? ...");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		Thread.sleep(5000);
		driver.quit();


	}
}
