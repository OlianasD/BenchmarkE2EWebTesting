package base;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Installer {
	
	protected WebDriver driver;
	protected final static String app_url = "http://192.168.1.141:8080";

	@Test
	public void install() throws InterruptedException {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox", "--headless=new", "--disable-gpu", "--screen-info={1920x1080}", "--lang=en");
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.get(app_url);
		Thread.sleep(5000);
		driver.findElement(By.id("jform_language_chzn")).click();
		driver.findElement(By.xpath("//*[@id=\"jform_language_chzn\"]/div/div/input")).sendKeys("English (United States)");
		driver.findElement(By.xpath("//*[@id=\"jform_language_chzn\"]/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.id("jform_site_name")).sendKeys("TestRigor joomla test");
		driver.findElement(By.id("jform_admin_email")).sendKeys("olianas@fake.com");
		driver.findElement(By.id("jform_admin_user")).sendKeys("administrator");
		driver.findElement(By.id("jform_admin_password")).sendKeys("e2eW3Bt3s71nGB3nchM4rK");
		driver.findElement(By.id("jform_admin_password2")).sendKeys("e2eW3Bt3s71nGB3nchM4rK");
		driver.findElement(By.xpath("//*[@id=\"container-installation\"]/div/div/a")).click();
		driver.findElement(By.id("jform_db_host")).clear();
		driver.findElement(By.id("jform_db_host")).sendKeys("joomladb");
		driver.findElement(By.id("jform_db_user")).sendKeys("root");
		driver.findElement(By.id("jform_db_pass")).sendKeys("example");
		driver.findElement(By.id("jform_db_name")).sendKeys("joomla310");
		driver.findElement(By.xpath("//*[@id=\"adminForm\"]/div[1]/div/a[2]")).click();
		driver.findElement(By.id("jform_sample_file1")).click();
		driver.findElement(By.xpath("//*[@id=\"adminForm\"]/div[1]/div/a[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"adminForm\"]/div[4]/div/input")).click();

		System.out.println("Setup complete. Remember to close the popup and hide the received messages.");
		driver.quit();
	}

}
