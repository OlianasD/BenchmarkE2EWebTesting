package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteProjectConfirmPage extends BaseNavBar {
	
	@FindBy(xpath = "/html/body/div[2]/form/input[4]")
	protected WebElement deleteConfirmBtn;
	
	public DeleteProjectConfirmPage(WebDriver driver) {
		super(driver);
	}
	
	public ManageProjectPage confirmDelete() {
		deleteConfirmBtn.click();
		return new ManageProjectPage(driver);
	}

}
