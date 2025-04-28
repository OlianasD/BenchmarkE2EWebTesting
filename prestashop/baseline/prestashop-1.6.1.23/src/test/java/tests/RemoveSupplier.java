package tests;

import static org.junit.Assert.assertTrue;


import org.junit.Test;

import po.PrestaLogin;
import po.SupplierPage;

public class RemoveSupplier extends BaseTest {

	@Test
	public void test_remove_supplier(){
		SupplierPage suppliers = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToSuppliers()
				.removeSupplier();
		
		assertTrue(suppliers
				.getSuccesssMessage()
				.contains("Successful deletion")); 
	}
}