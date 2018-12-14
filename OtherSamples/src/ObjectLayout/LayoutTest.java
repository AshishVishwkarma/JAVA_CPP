package ObjectLayout;

public class LayoutTest{
	public static void main(String args[]){
		System.out.println(">> LayoutTest.main()");
		test1();
		System.out.println("<< LayoutTest.main()");
	}
	
	public static void test1(){
		System.out.println(">> LayoutTest.test1()");
		Base bref = new Base();
		Derived1 d1ref = new Derived1();
		System.out.println("Size of Base obj = "+bref.size());
		System.out.println("Size of Derived1 obj = "+d1ref.size());
		System.out.println("<< LayoutTest.test1()");
	}
}