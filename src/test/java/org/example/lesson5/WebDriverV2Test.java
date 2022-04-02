package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WebDriverV2Test {
	WebDriver driver;
	WebDriverWait webDriverWait;
	private final static String RAMBLER_BASE_URL = "http://rambler.ru";
	private final static String SUP_KURGAN_BASE_URL = "http://sup-kurgan.ru";

	@BeforeAll
	static void registerDriver() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	void SetupDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
		webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	@Test
	void ConvertUSDTest() throws InterruptedException {
		driver.get(RAMBLER_BASE_URL);
		driver.findElement(By.xpath("//a[@href='https://finance.rambler.ru/currencies/USD/?utm_source=head&utm_campaign=self_promo&utm_medium=header&utm_content=finance_media']")).click();
		List<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.xpath("//label[@for='bank_forex']")).click();
		driver.findElement(By.xpath("//label[@for='period_quarter']")).click();
		driver.findElement(By.xpath("//input[@class=\"finance-input converter__input\"]")).sendKeys("150");
		driver.findElement(By.xpath("//span[@class=\"rui-Button-content\"]")).click();

		Assertions.assertEquals(driver.findElement(By.xpath("//h2[@class=\"finance__header\"]")).getText(), "150 долларов США в рублях");
	}

	@Test
	void EmailSendTest() throws InterruptedException {
		driver.get(SUP_KURGAN_BASE_URL);
		driver.findElement(By.xpath("//a[.='Контакты']")).click();
		driver.findElement(By.xpath("//input[@name=\"wb_input_0\" and @type = \"text\"]")).sendKeys("Test Name");
		driver.findElement(By.xpath("//input[@name=\"wb_input_1\" and @type = \"text\"]")).sendKeys("Test@test_domen.ru");
		driver.findElement(By.xpath("//textarea[@name=\"wb_input_2\"]")).sendKeys("Я вам пишу! Чего же боле ? Что я могу еще сказать? ...");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		Assertions.assertEquals(driver.findElement(By.xpath("//div[@class=\"alert alert-wb-form alert-success\"]")).isDisplayed(), true);
	}

	@AfterEach
	void tearDown() {
		driver.quit();
	}
}
