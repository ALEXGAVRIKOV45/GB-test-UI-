package org.example.lesson6;




import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RamblerUSDPage extends BaseView {

	public RamblerUSDPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//label[@for='bank_forex']")
	private WebElement BankForexbutton;

	@FindBy(xpath = "//label[@for='period_quarter']")
	private WebElement PeriodQuaterbutton;

	@FindBy(xpath = "//input[@class=\"finance-input converter__input\"]")
	private WebElement ConverterInput;

	@FindBy(xpath = "//span[@class=\"rui-Button-content\"]")
	private WebElement Converterbutton;

	@FindBy(xpath = "//h2[@class=\"finance__header\"]")
	private WebElement FinansHeader;

	public void Convert(String ConvertNum) throws InterruptedException {
		BankForexbutton.click();
		PeriodQuaterbutton.click();
		ConverterInput.sendKeys(ConvertNum);
		Converterbutton.click();

		Assertions.assertEquals(FinansHeader.getText(), "150 долларов США в рублях");
	}

}
