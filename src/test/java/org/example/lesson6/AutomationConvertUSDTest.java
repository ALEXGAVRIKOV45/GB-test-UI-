package org.example.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AutomationConvertUSDTest {
	WebDriver driver;
	WebDriverWait webDriverWait;
	Actions actions;
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
	void ConverUSDTest() throws InterruptedException {
		driver.get(RAMBLER_BASE_URL);

		new RamblerMainPage(driver).clickUSDlink()
				.Convert("150");
	}

	@Test
	void SentEmailTest() throws InterruptedException {
		driver.get(SUP_KURGAN_BASE_URL);

		new SUPKurganMainPage(driver).ClickContactlink()
				.SendTestText("TestName", "test@testdomain.ru",  "Я вам пишу! Чего же боле ? Что я могу еще сказать? ...");
	}



	@AfterEach
	void tearDown() {
		driver.quit();
	}
}

