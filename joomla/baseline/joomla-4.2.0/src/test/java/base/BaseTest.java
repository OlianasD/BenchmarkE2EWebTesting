package base;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import po.BaseNavBar;
import po.ProfilePageInfo;

public class BaseTest {
	
	protected static final String rootPassword = "dodicicaratteri";
	public static WebDriver driver;
	
	@Before
	public void goToHome() {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-gpu", "--window-size=1920x1080");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:3000/");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	protected ProfilePageInfo loginAsAdmin() {
		return new BaseNavBar(driver)
			.authorLogin()
			.setUsername("administrator")
			.setPassword(rootPassword)
			.login();
	}
}
