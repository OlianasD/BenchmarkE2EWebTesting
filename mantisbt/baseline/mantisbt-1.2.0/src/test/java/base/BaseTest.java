package base;

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
import po.LoginPage;

public class BaseTest {
	
	public static WebDriver driver;
	public static final String app_url = "http://192.168.1.141:3000/mantisbt";
	@Before
	public void login() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox", "--headless=new", "--lang=en", "--disable-gpu", "--screen-info={1920x1080}");
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(app_url);
		new LoginPage(driver).setUsername("administrator").setPassword("e2eW3Bt3s71nGB3nchM4rK").login();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
