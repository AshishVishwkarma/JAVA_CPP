class AnonymousClass{
	// Imagine one would write something like:
	public void inSomeFunction(DataStore store)
	{
		String myName = "bob";
		
		// myName = "Ross"; //  error: local variables referenced from an inner class must be final or effectively final
							//  private String person = myName;

		Visitor myVisitor = new Visitor(){
			@Override
			public void visit(Data data) 
			{
				System.out.println( person + " is visiting " + data);
			}
			private String person = myName;
		};
		store.visitData(myVisitor);
	}
	
	public static void main(String args[])
	{
		System.out.println(">> AnonymousClass.main()");
		DataStore ds = new DataStore();
		AnonymousClass ac = new AnonymousClass();
		ac.inSomeFunction(ds);
		System.out.println("<< AnonymousClass.main()");
	}
}