package org.example.lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SUPKurganContactPage extends BaseView {

	@FindBy(xpath = "//input[@name=\"wb_input_0\" and @type = \"text\"]")
	private WebElement NameInput;

	@FindBy(xpath = "//input[@name=\"wb_input_1\" and @type = \"text\"]")
	private WebElement EmailInput;

	@FindBy(xpath = "//textarea[@name=\"wb_input_2\"]")
	private WebElement TextInput;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement SendButton;

	@FindBy(xpath = "//div[@class=\"alert alert-wb-form alert-success\"]")
	private WebElement SendMail_OK;

	public void SendTestText(String Name, String Email, String SendText) throws InterruptedException {
		NameInput.sendKeys(Name);
		EmailInput.sendKeys(Email);
		TextInput.sendKeys(SendText);
		SendButton.click();

		Assertions.assertEquals(SendMail_OK.isDisplayed(), true);
	}

	public SUPKurganContactPage(WebDriver driver) {
		super(driver);
	}
}
