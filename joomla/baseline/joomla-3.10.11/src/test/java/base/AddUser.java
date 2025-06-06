package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.ManageUsersPage;

public class AddUser extends BaseTest {
	
	@Test
	public void addUser() {
		String name ="Test User";
		String username = "tuser01";
		String password = "e2eW3Bt3s71nGB3nchM4rK";
		String email = "testmail@example.com";
		
		ManageUsersPage users = loginAsAdmin()
			.siteAdmin()
			.setUsername(adminUser)
			.setPassword(adminPsw)
			.login()
			.users()
			.addUser()
			.setName(name)
			.setLoginName(username)
			.setPassword(password)
			.confirmPassword(password)
			.setEmail(email)
			.saveAndClose();
		
		assertEquals(name, users.getSecondUserRealName());
		assertEquals(username, users.getSecondUserName());
		assertEquals(email, users.getSecondUserEmail());
		users.logout();
	}
	
}
