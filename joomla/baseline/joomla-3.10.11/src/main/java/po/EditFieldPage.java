package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.JavascriptExecutor;

public class EditFieldPage extends PageObject {
	
	@FindBy(id = "jform_title")
	protected WebElement title;
	
	@FindBy(xpath = "//*[@id=\"toolbar-save\"]/button")
	protected WebElement saveAndCloseBtn;
	
	@FindBy(xpath = "//*[@id=\"system-message-container\"]/div/div")
	protected WebElement emptyTitleAlert;
	
	public EditFieldPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public EditFieldPage setTitle(String ttl) {
		title.sendKeys(ttl);
		return this;
	}
	
	public EditFieldPage selectGroup(String group) {		
		WebElement select = driver.findElement(By.id("jform_group_id"));
		new JavascriptExecutor(driver).setVisible(select);
		new Select(select).selectByVisibleText(group);
		return this;
	}
	
	public ManageFieldsPage saveAndClose() {
		saveAndCloseBtn.click();
		return new ManageFieldsPage(driver);
	}
	
	public EditFieldPage saveError() {
		saveAndCloseBtn.click();
		return new EditFieldPage(driver);
	}
	
	public String getEmptyTitleAlert() {
		return emptyTitleAlert.getText();
	}
}
