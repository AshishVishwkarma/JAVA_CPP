public class TestOne{
	abstract class AbsClass{
		public abstract void print();
	}
	
	class ConClass extends AbsClass{
		@Override public void print(){System.out.println("ConClass.print()");}
	}
	
	//class ConClassTwo extends AbsClass{
	//	@Override public String print(){System.out.println("ConClassTwo.print()"); return "ConClassTwo";}
	//	// error: TestOne.ConClassTwo is not abstract and does not override abstract method print() in TestOne.AbsClass
	//	// return type String is not compatible with void
	//}
	
	
	
	public static void main(String args[]){
		TestOne obj = new TestOne();
		
		TestOne.ConClass conObj = obj.new ConClass();
		conObj.print(); // ConClass.print()
		
		TestOne.AbsClass absObj = obj.new ConClass();
		absObj.print(); // ConClass.print()
		
	}

}