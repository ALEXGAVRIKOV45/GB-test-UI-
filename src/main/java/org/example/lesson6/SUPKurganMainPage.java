package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SUPKurganMainPage extends BaseView {

	@FindBy(xpath = "//a[.='Контакты']")
	public WebElement Contactlink;

	public SUPKurganContactPage ClickContactlink() {
		Contactlink.click();
		return new SUPKurganContactPage(driver);
	}

	public SUPKurganMainPage(WebDriver driver) {
		super(driver);
	}
}
