package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TagsPage extends AdminSidebar {
	
	@FindBy(id = "page-header-desc-tag-new_tag")
    protected WebElement addTag;
	
	@FindBy(className = "alert-success")
	protected WebElement tagMessage;

	public TagsPage(WebDriver driver) {
		super(driver);
	}
	
	public AddTagPage addTag() {
		addTag.click();
		return new AddTagPage(driver);
	}
	
	public String getSuccessMessage() {
		return tagMessage.getText();
	}

}
