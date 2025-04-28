package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementManagementPage extends AdminSidebar {
	
	@FindBy(className = "alert-success")
	protected WebElement tagMessage;

	public ElementManagementPage(WebDriver driver) {
		super(driver);
	}
	
	public String getSuccesssMessage() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tagMessage.getText();
	}

}
