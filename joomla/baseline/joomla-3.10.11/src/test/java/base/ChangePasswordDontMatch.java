package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.EditProfilePage;

public class ChangePasswordDontMatch extends BaseTest {
	
	@Test
	public void changePasswordDontMatch() {
		String username = "tuser01";
		String password = "e2eW3Bt3s71nGB3nchM4rK_1";
		
		EditProfilePage profile = new BaseNavBar(driver)
				.authorLogin()
				.setUsername(username)
				.setPassword(password)
				.login()
				.setPassword("asdasdasd22")
				.confirmPassword("zxczxczxc23")
				.submit();
		
		assertEquals("The passwords you entered do not match. Please enter your desired password in the password field and confirm your entry by entering it in the confirm password field.", profile.getAlertMessage());	
	}
}