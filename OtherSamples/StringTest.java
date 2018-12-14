
class StringTest
{
	public static void main(String[] args)
	{
		System.out.println(">> StringTest");
		String str1;
		// Compilation error: variable str1 might not have been initialized
		//System.out.println("Printing string obj without initialization : " + str1);
		str1 = "Ashsish";
		System.out.println("Printing string obj after initialization : " + str1);
		str1 = "ASHISH";
		System.out.println("Printing string obj after assignment to new value : " + str1);
		string_modification(str1);
		System.out.println("Printing string obj after passing to string_modification() : " + str1);
		System.out.println("<< StringTest");
	}
	
	private static void string_modification(String str)
	{
		str = "CHANGED STRING";
		System.out.println("Inside string_modification: str = " + str);
	}
}