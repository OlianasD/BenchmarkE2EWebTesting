package tests;




import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.LoginPage;
import po.SwimlanesPage;




public class AddEmptySwimlane extends BaseTest {
		  
	@Test()
	public void addNewSwimlane() {
		SwimlanesPage swimlanes = new LoginPage(driver)
				.loginToKanboard("admin", "admin")
				.firstProjectSummary()
				.swimlanes()
				.addSwimlane()
				.save();
		
		assertEquals("The name is required", swimlanes.getErrorMessage());
			  
	}
		  
		  
		  
}