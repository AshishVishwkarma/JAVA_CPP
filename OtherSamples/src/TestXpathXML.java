import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

import java.util.Set;
import java.util.List;

import javax.xml.transform.TransformerException;

public class TestXpathXML{
	
	private IReadXML obj;
	
	private void printSet(Set set){
		//System.out.println("Elements in set:");
		for(Object object : set) {
			System.out.println((String) object);
		}
	}
	
	private void printList(List list){
		//System.out.println("Elements in list:");
		for(Object object : list) {
			System.out.println((String) object);
		}
	}
	
	private void printTabedList(List list){
		//System.out.println("Elements in list:");
		for(Object object : list) {
			System.out.println("\t"+(String) object);
		}
	}
	
	/**
	* Annotating a public void method with @Before causes that method to be run before the Test method. The @Before methods of superclasses will be * run before those of the current class.
	*/
	@Before
	public void setUp(){
		obj = new XpathXML();
		try{
			obj.openFile("C:\\Ashish\\java_project\\Samples\\sample_files\\Test.xml");
		}
		catch(Exception ex){System.out.println("Exception occurred!"); System.out.println(ex);}
	}
	
	/**
	* Annotating a public void method with @After causes that method to be run after the Test method. All @After methods are guaranteed to run even * if a Before or Test method throws an exception. The @After methods declared in superclasses will be run after those of the current class.
	*/
	@After
	public void tearDown(){obj = null;} 
	
	@Test
	public void testOne(){
		System.out.println(">> testOne");

		System.out.println("Root element: \n"+obj.getRootElement());
		
		System.out.println("<< testOne");
	}
	
	
	@Test
	public void testTwo(){
		System.out.println(">> testTwo");
		
		List list = obj.getRChildElements();
		printList(list);
		
		System.out.println("<< testTwo");
	}
	
	
	@Test
	public void testThree(){
		System.out.println(">> testThree");
		
		short max_index = (short) obj.getRChildElements().size();
		for(short index=1; index<=max_index; index++){
			List list = obj.getChildElements(index);
			printList(list);
			//Set set = obj.getChildElements(index);
			//printSet(set);
			System.out.println("\n");
		}
		
		System.out.println("<< testThree");
	}
	
	@Test
	public void testFour(){
		System.out.println(">> testFour");
		
		short max_index = (short) obj.getRChildElements().size();
		for(short index=1; index<=max_index; index++){
			List list = obj.getChildElements(index);
			for(Object str : list){
			//Set set = obj.getChildElements(index);
			//for(Object str : set){
				System.out.println((String)str+" : "+obj.getValue(index, (String)str));
			}
			System.out.println("\n");
		}
		
		System.out.println("<< testFour");
	}
	
	@Test
	public void testFive(){
		System.out.println(">> testFive");
		
		assertEquals("Jane Doe", obj.getValue((short)2, "name"));
		assertEquals(31, Integer.parseInt(obj.getValue((short)2, "age")));
		assertEquals("F", obj.getValue((short)2, "sex"));
		assertEquals("Accounts", obj.getValue((short)2, "department"));
		
		System.out.println("<< testFive");
	}
	
	@Test
	public void testSix(){
		System.out.println(">> testSix");
		
		short max_index = (short) obj.getRChildElements().size();
		for(short index=1; index<=max_index; index++){
			List list = obj.getChildElements(index);
			for(Object str : list){
			//Set set = obj.getChildElements(index);
			//for(Object str : set){
				System.out.print((String)str+" : ");
				printTabedList(obj.getValues(index, (String)str));
			}
			System.out.println("\n");
		}
		
		System.out.println("<< testSix");
	}
	
	@Test
	public void testSeven(){
		System.out.println(">> testSeven");
		
		List list = obj.getValues("employees/employee/name", "/");
		printList(list);
		
		list = obj.getValues("employees/department/headquarter", "/");
		printList(list);
		
		list = obj.getValues("employees/employee/salary", "/");
		assertEquals(0, list.size());
		
		list = obj.getValues("department/employee/salary", "/");
		//assertEquals(null, list);
		assertEquals(0, list.size());
		
		System.out.println("<< testSeven");
	}
	
	@Test
	public void testEight(){
		System.out.println(">> testEight");
		
		System.out.println("Name = "+obj.getValue("employees/employee/name", "/"));
		System.out.println("Age = "+obj.getValue("employees/employee/age", "/"));
		System.out.println("Department = "+obj.getValue("employees/employee/department", "/"));
		
		System.out.println("<< testEight");
	}
	
	@Test
	public void testNine(){
		System.out.println(">> testNine");
		
		System.out.println("Name = "+obj.getValue("employees\\employee\\name", "\\"));
		System.out.println("Age = "+obj.getValue("employees|employee|age", "|"));
		System.out.println("Department = "+obj.getValue("employees,employee,department", ","));
		
		System.out.println("<< testNine");
	}
	
	@Test
	public void testTen(){
		System.out.println(">> testTen");
		
		List list = obj.getValues("employees\\employee\\name", "\\");
		printList(list);
		
		list = obj.getValues("employees|department|headquarter", "|");
		printList(list);
		
		list = obj.getValues("employees,department,address", ",");
		printList(list);
		
		list = obj.getValues("employees/department/address", "/");
		printList(list);
		
		list = obj.getValues("employees,employee,salary", ",");
		assertEquals(0, list.size());
		
		list = obj.getValues("department|employee|salary", "|");
		//assertEquals(null, list);
		assertEquals(0, list.size());
		
		System.out.println("<< testTen");
	}
	
	@Test(expected=TransformerException.class)
	public void testEleven(){
		System.out.println(">> testEleven");
		
		List list = obj.getValues("(employees/employee/name, employees/employee/age)", "/");
		printList(list);
		
		System.out.println("<< testEleven");
	}
}