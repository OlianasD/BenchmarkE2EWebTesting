package po;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CalendarAgendaPage extends ClarolinePage{
	private WebDriver driver;
	@FindBy(linkText="Add an event")
	private WebElement add;
	@FindBy(id="title")
	private WebElement title;
	@FindBy(id="fday")
	private WebElement day;
	@FindBy(id="fmonth")
	private WebElement month;
	@FindBy(id="fyear")
	private WebElement year;
	@FindBy(id="location")
	private WebElement location;
	@FindBy(name="submitEvent")
	private WebElement confirm;
	@FindBy(linkText="Clear up event list")
	private WebElement removeEventLink;
	@FindBy(linkText="My desktop")
	private WebElement desktopLink;
	
	public CalendarAgendaPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public CalendarAgendaPage addEvent(String tit, String dd, String mm, String yy, String loc) throws InterruptedException{
		add.click();
		title.sendKeys(tit);
		new Select(day).selectByVisibleText(dd);
		new Select(month).selectByVisibleText(mm);
		new Select(year).selectByVisibleText(yy);
		location.sendKeys(loc);
		confirm.click();
		return new CalendarAgendaPage(driver);
	}
	
	public CalendarAgendaPage removeEvent() throws InterruptedException{
		removeEventLink.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return new CalendarAgendaPage(driver);
	}
	
}
