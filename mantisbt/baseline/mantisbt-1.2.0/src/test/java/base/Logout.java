package base;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import po.BaseNavBar;
import po.LoginPage;

public class Logout extends BaseTest {
	
	@Test
	public void logout() {
		new BaseNavBar(driver).logout();
		LoginPage login = new LoginPage(driver);
		assertTrue(login.isLoginBtnDisplayed());
	}
}
