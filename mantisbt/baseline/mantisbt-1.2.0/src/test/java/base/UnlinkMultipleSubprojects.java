package base;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.Test;
import po.BaseNavBar;
import po.EditProjectPage;


public class UnlinkMultipleSubprojects extends BaseTest {
	
	@Test
	public void unlinkMultipleSubprojects() {
		String projectName = "Project001";
		EditProjectPage project = new BaseNavBar(driver)
			.manage()
			.manageProjects()
			.goToProject(projectName)
			.unlinkSubproject();
		
		assertFalse(project.isSubprojectPresent("testSubProject1"));
		
		project = project.unlinkSubproject();
		assertFalse(project.isSubprojectPresent("testSubProject2"));
	}
}
