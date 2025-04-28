package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.EditProfilePage;

public class ChangePassword extends BaseTest {
	
	@Test
	public void changePassword() {
		String username = "tuser01";
		String oldPassword = "e2eW3Bt3s71nGB3nchM4rK";
		String password = "e2eW3Bt3s71nGB3nchM4rK_1";
		
		EditProfilePage profile = new BaseNavBar(driver)
				.authorLogin()
				.setUsername(username)
				.setPassword(oldPassword)
				.login()
				.setPassword(password)
				.confirmPassword(password)
				.submit();
		
		assertEquals("Profile saved.", profile.getAlertMessage());
		profile.standardUserLogOut();
		
	}
	
}
