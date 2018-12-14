class TestClass{
	public static void testMethod1(){
		System.out.println("testMethod1");
		AbsBase absObj;
		//absObj = new AbsBase(); //  error: AbsBase is abstract; cannot be instantiated
		absObj = new ConDerived();
		absObj.setData(4);
		System.out.println("Current data value = "+absObj.getData());		
	}
	
	public static void testMethod2(){
		System.out.println("testMethod2");
		AbsBase absObj;
		absObj = new ConDerived();
		absObj.setData(4);	

		AbsBase absObj2 = absObj;
		System.out.println("Current data value = "+absObj2.getData());		
	}
	
	public static void testMethod3(){
		System.out.println("testMethod3");
		AbsBase absObj;
		absObj = new ConDerived();
		absObj.setData(4);	

		AbsBase absObj2;
		absObj2 = absObj;
		System.out.println("Current data value = "+absObj2.getData());		
	}
	
	public static void testMethod4(){
		System.out.println("testMethod4");
		AbsBase absObj;
		absObj = new ConDerived();
		absObj.setData(4);
		
		AbsBase absObj2;
		//absObj2 = new ConDerived(absObj); // error: constructor ConDerived in class ConDerived cannot be applied to given types;
		//System.out.println("Current data value = "+absObj2.getData());
	}
	
	public static void testMethod5(AbsBase absObj){
		System.out.println("testMethod5");
		absObj.setData(5);
		System.out.println("Current data value = "+absObj.getData());
	}
	
	public static void main(String args[]){
		testMethod1();
		testMethod2();
		testMethod3();
		testMethod4();
		testMethod5(new ConDerived());
	}
}