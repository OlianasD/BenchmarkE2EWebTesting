package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TrackUserReportPage extends ClarolinePage{
	private WebDriver driver;
	@FindBy(id="cidReq")
	private WebElement chooseCourse;
	@FindBy(xpath=".//*[@id='leftContent']/div[4]/div[1]/table/tbody/tr[1]/td[1]/a")
	private WebElement exeName;
	@FindBy(xpath=".//*[@id='leftContent']/div[4]/div[1]/table/tbody/tr[1]/td[3]")
	private WebElement exeResult;

	public TrackUserReportPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public TrackUserReportPage selectCourseStatistics(String course) throws InterruptedException{
		new Select(chooseCourse).selectByVisibleText(course);
		return new TrackUserReportPage(driver);
	}
	
	public String getExeName(){
		return exeName.getText();
	}
	
	public String getExeResult(){
		return exeResult.getText();
	}
	
}
