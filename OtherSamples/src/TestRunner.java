import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
//import java.lang.reflect.*;

public class TestRunner {
	public static void main(String[] args) {
		//Result result = JUnitCore.runClasses(TestTokenizer.class);
		System.out.println("JUNIT test class: "+args[0]); // First argument passed to the application
		try{
		  Result result = JUnitCore.runClasses(Class.forName(args[0]));
			
		  for (Failure failure : result.getFailures()) {
			 System.out.println(failure.toString());
		  }
			
		  //System.out.println("JUNIT test class result: "+result.wasSuccessful());
		  System.out.println(result.wasSuccessful()?"All tests are passed.":"JUnit test class failed!");
		}catch(ClassNotFoundException e){
			System.out.println(e.toString());
		}
	}
}  