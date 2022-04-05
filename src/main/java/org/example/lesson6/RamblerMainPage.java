package org.example.lesson6;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;


public class RamblerMainPage extends BaseView {

	@FindBy(xpath = "//a[@href='https://finance.rambler.ru/currencies/USD/?utm_source=head&utm_campaign=self_promo&utm_medium=header&utm_content=finance_media']")
	public WebElement USDlink;

	public RamblerUSDPage clickUSDlink() {
		USDlink.click();
		List<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		return new RamblerUSDPage(driver);
	}

	public RamblerMainPage(WebDriver driver) {
		super(driver);
	}

}
