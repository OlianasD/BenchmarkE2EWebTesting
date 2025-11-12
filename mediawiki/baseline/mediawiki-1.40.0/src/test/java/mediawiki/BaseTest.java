package mediawiki;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import po.MainPage;

public class BaseTest {
	
	public static WebDriver driver;
	public static final String app_url = "http://192.168.1.141:8080";
	
	@Before
	public void setup() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox", "--headless=new", "--disable-gpu", "--screen-info={1920x1080}", "--lang=en");
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(app_url);
	}
	
	protected MainPage loginAsAdmin() {
		return new MainPage(driver)
				.login()
				.setUsername("admin")
				.setPassword("e2eW3Bt3s71nGB3nchM4rK")
				.login();
	}
	
	protected MainPage loginAsUser() {
		return new MainPage(driver)
				.login()
				.setUsername("User001")
				.setPassword("e2eW3Bt3s71nGB3nchM4rK")
				.login();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
