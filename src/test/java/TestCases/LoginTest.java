package TestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Pages.LoginPage;

public class LoginTest extends BaseClass{

	@Test
	public void test1() throws InterruptedException {
		
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("abc@xyz.com","Abc@1234");
		
		WebElement error = driver.findElement(By.id("msg_box"));
		
		String ActError = error.getText();
		String ExpError = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(ActError, ExpError);
		
	}
	
	@Test
	public void test2() throws InterruptedException {
		
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("pqr@xyz.com","Abc@1234");
		
	}

	@Test
	public void test4() throws FilloException, InterruptedException {
		
		Recordset recordset = connection.executeQuery("select * from Sheet1 where TestName='test4'");
		recordset.next();
			
		String UserName = recordset.getField("UserName");
		String Password = recordset.getField("Password");
		
		LoginPage login = new LoginPage(driver);
		login.LoginFunction(UserName, Password);

		
	}


	
	

}
