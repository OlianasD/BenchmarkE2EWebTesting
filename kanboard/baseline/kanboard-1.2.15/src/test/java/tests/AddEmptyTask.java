package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.LoginPage;
import po.ProjectManagementPage;




public class AddEmptyTask extends BaseTest {

		  
	@Test()
	public void addEmptyTask() {
		ProjectManagementPage project = new LoginPage(driver)
				.loginToKanboard("admin", "admin")
				.goToFirstProject()
				.newTask()
				.setNewTaskName("")
				.saveNewTask();
		assertEquals("The title is required", project.getErrorMessage());
		  
	}
		  

		  
		  
}