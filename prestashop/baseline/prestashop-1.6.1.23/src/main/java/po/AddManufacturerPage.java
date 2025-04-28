package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddManufacturerPage {
	WebDriver driver;

	@FindBy(id = "page-header-desc-address-new_manufacturer")
	WebElement addManufacturer;
	@FindBy(id = "name")
	WebElement name;
	@FindBy(id = "manufacturer_form_submit_btn")
	WebElement submitManufacturer;
	@FindBy(xpath = "//*[@id=\"content\"]/div[4]/div")
	WebElement alertMessage;

	public AddManufacturerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickAddManufacturer() {
		addManufacturer.click();
	}

	public ManufacturerPage addManufacturer(String nameStr) {
		name.clear();
		name.sendKeys(nameStr);
		submitManufacturer.click();
		return new ManufacturerPage(driver);
	}

	public AddManufacturerPage addEmptyManufacturer() {
		submitManufacturer.click();
		return new AddManufacturerPage(driver);
	}

	public String getAlertMessage() {
		return alertMessage.getText();
	}
}
