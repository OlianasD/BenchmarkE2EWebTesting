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
import po.BaseNavBar;
import po.EditProfilePage;

public class BaseTest {

	protected static final String adminUser = "administrator";
	protected static final String adminPsw = "e2eW3Bt3s71nGB3nchM4rK";
	protected static final String app_url = "http://192.168.1.141:8080";
	protected WebDriver driver;


	@Before
	public void setUp() {
		setupNativeBrowser();
		driver.manage().window().maximize();
		driver.get("http://localhost:3000/");
	}

	public void setupNativeBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen", "--headless=new", "--disable-gpu", "--screen-info={1920x1080}");
		options.setBrowserVersion("127");
		driver = new ChromeDriver(options);
	}

	public void setupRemoteWebdriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox", "--headless=new", "--disable-gpu", "--screen-info={1920x1080}");
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected EditProfilePage loginAsAdmin() {
		return new BaseNavBar(driver)
			.authorLogin()
			.setUsername(adminUser)
			.setPassword(adminPsw)
			.login();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}