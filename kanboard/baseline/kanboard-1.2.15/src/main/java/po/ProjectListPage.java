package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectListPage extends TopNavBar {

	public ProjectListPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean containsProject(String proj) {
		return driver.findElement(By.tagName("body")).getText().contains(proj);
	}
}