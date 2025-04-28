package base;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.ManageFieldGroupsPage;

public class AddFieldGroup extends BaseTest {
	
	@Test
	public void addFieldGroup() {
		String group = "Test Group 000";
		ManageFieldGroupsPage groups = loginAsAdmin()
			.siteAdmin()
			.setUsername(adminUser)
			.setPassword(adminPsw)
			.login()
			.articles()
			.fieldGroups()
			.createGroup()
			.setTitle(group)
			.saveAndClose();
		
		assertTrue(groups.isGroupPresent(group));
		groups.logout();
	}
	
}
