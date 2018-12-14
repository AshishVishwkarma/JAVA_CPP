
class Employee
{
	private int _id;
	private	String _name;
	private	int _age;
	private	double _salary;
		
	public String getName(){return _name;}
	public int getAge(){return _age;}
	public double getSalary(){return _salary;}
	public int getId(){return _id;}
	
	public void print(){System.out.println("id = "+_id+", name = "+_name+", age = "+_age+", salary = "+_salary);}
	
	// Error handling ?
	public void changeName(String name){_name = name;} // deep copy| shallow copy ?
	public void changeAge(int age){_age = age;}
	public void changeSalary(double salary){_salary = salary;}
	
	//public Employee(int id, String name, int age, double salary):_id(id), _name(name), _age(age), _salary(salary){}
	public Employee(int id, String name, int age, double salary)
	{
		_id = id;
		_name = name;
		_age = age; 
		_salary = salary;
	}
}

