package listenerCoverfox;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(coverfoxListener.Listener.class)
public class NewTest2 {
	
		 @Test
		 public void e() 
		 {
		 Reporter.log("Hi a is running", true);
		 }
		 
		 @Test
		 public void g() 
		 {
		 Assert.fail();
		 Reporter.log("Hi b is running", true);
		 }
		 
		 @Test(dependsOnMethods = {"f"})
		 public void h() 
		 {
		 Reporter.log("Hi c is running", true);
		 }
		 
		 @Test
		 public void f() 
		 {
		 Reporter.log("Hi d is running", true);
		 }
}
