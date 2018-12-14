import java.util.ArrayList;
import java.util.Iterator;

class UsingCollection
{
	//private static ArrayList<Employee> empList;

	public static void main(String[] args)
	{
		System.out.println(">> UsingCollection");
		ArrayList<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(1, "Ashish", 33, 1000));
		empList.add(new Employee(2, "Aman", 22, 2000));
		empList.add(new Employee(3, "Rakesh", 44, 3000));
		
		Iterator itr = empList.iterator();
		while(itr.hasNext())
		{
			Employee emp = (Employee) itr.next();
			emp.print();
		}
		System.out.println("<< UsingCollection");
	}
}