import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Set;
import java.util.List;


public class TestReadXML{
	
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
	
	
	@Test
	public void testOne(){
		System.out.println(">> testOne");
		IReadXML obj = new ReadXML();
		try{
			obj.openFile("C:\\Ashish\\java_project\\Samples\\sample_files\\Test.xml");
		}
		catch(Exception ex){System.out.println("Exception occurred!"); System.out.println(ex);}

		System.out.println("Root element: \n"+obj.getRootElement());
		
		System.out.println("<< testOne");
	}
	
	@Test
	public void testTwo(){
		System.out.println(">> testTwo");
		IReadXML obj = new ReadXML();
		try{
			obj.openFile("C:\\Ashish\\java_project\\Samples\\sample_files\\Test.xml");
		}
		catch(Exception ex){System.out.println("Exception occurred!"); System.out.println(ex);}

		List list = obj.getRChildElements();
		printList(list);
		
		System.out.println("<< testTwo");
	}
	
	@Test
	public void testThree(){
		System.out.println(">> testThree");
		IReadXML obj = new ReadXML();
		try{
			obj.openFile("C:\\Ashish\\java_project\\Samples\\sample_files\\Test.xml");
		}
		catch(Exception ex){System.out.println("Exception occurred!"); System.out.println(ex);}

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
		IReadXML obj = new ReadXML();
		try{
			obj.openFile("C:\\Ashish\\java_project\\Samples\\sample_files\\Test.xml");
		}
		catch(Exception ex){System.out.println("Exception occurred!"); System.out.println(ex);}

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
		IReadXML obj = new ReadXML();
		try{
			obj.openFile("C:\\Ashish\\java_project\\Samples\\sample_files\\Test.xml");
		}
		catch(Exception ex){System.out.println("Exception occurred!"); System.out.println(ex);}

		assertEquals("Jane Doe", obj.getValue((short)2, "name"));
		assertEquals(31, Integer.parseInt(obj.getValue((short)2, "age")));
		assertEquals("F", obj.getValue((short)2, "sex"));
		assertEquals("Accounts", obj.getValue((short)2, "department"));
		
		System.out.println("<< testFive");
	}
	
	@Test
	public void testSix(){
		System.out.println(">> testSix");
		IReadXML obj = new ReadXML();
		try{
			obj.openFile("C:\\Ashish\\java_project\\Samples\\sample_files\\Test.xml");
		}
		catch(Exception ex){System.out.println("Exception occurred!"); System.out.println(ex);}

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
		IReadXML obj = new ReadXML();
		try{
			obj.openFile("C:\\Ashish\\java_project\\Samples\\sample_files\\Test.xml");
		}
		catch(Exception ex){System.out.println("Exception occurred!"); System.out.println(ex);}
		
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
}