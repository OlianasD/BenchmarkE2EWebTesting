package base;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;
import po.BaseNavBar;
import po.LoginPage;


public class BadLogin extends BaseTest {
	
	@Test
	public void badLogin() {
		new BaseNavBar(driver).logout();
		LoginPage login = new LoginPage(driver).setUsername("wrong").setPassword("wrong");
		login.login();
		assertTrue(login.isLoginFailed());
	}
}
