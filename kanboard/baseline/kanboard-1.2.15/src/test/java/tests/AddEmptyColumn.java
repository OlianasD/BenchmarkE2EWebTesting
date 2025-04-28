package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.ColumnsPage;
import po.LoginPage;

public class AddEmptyColumn extends BaseTest {
	
	@Test()
	public void addEmptyColumn() {
		ColumnsPage columns = new LoginPage(driver)
				.loginToKanboard("admin", "admin")
				.firstProjectSummary()
				.columns()
				.addColumn()
				.save();
		
		assertEquals("The title is required", columns.getErrorMessage());
			  
	}
}
