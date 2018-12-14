	set path=%path%;C:\Program Files\Java\jdk1.8.0_101\bin

JUNIT:
	C:\Ashish\Source_Code\PHX_LOCAL_REPO\junit\junit\4.12\junit-4.12.jar

	set JUNIT_HOME=C:\Ashish\Source_Code\PHX_LOCAL_REPO\junit\junit\4.12
	set HAMREST_HOME=C:\Ashish\Source_Code\PHX_LOCAL_REPO\org\hamcrest\hamcrest-core\1.3.RC2
	
	cd C:\Ashish\java_project
	javac -cp C:\Ashish\java_project\Class;%JUNIT_HOME%\junit-4.12.jar TestTokenizer.java TestRunner.java -d Class
	java -cp C:\Ashish\java_project\Class;%JUNIT_HOME%\junit-4.12.jar;%HAMREST_HOME%\hamcrest-core-1.3.RC2.jar TestRunner
	
	cd C:\Ashish\java_project\Samples\src
	javac -cp %JUNIT_HOME%\junit-4.12.jar TestRunner.java -d ..\Class
	javac -cp ..\Class;%JUNIT_HOME%\junit-4.12.jar TestTokenizer.java -d ..\Class
	java -cp ..\Class;%JUNIT_HOME%\junit-4.12.jar;%HAMREST_HOME%\hamcrest-core-1.3.RC2.jar TestRunner TestTokenizer
	
	cd C:\Ashish\java_project\Samples\src
	javac -cp ..\Class PropertiesTest.java -d ..\Class
	java -cp ..\Class PropertiesTest
	java -cp ..\class -Dmy.properties.test="This is for test only!" PropertiesRead
	

cd C:\Program Files\Java\jdk1.8.0_101\bin

set path=%path%;C:\Program Files\Java\jdk1.8.0_101\bin
cd C:\Ashish\java_project\Samples\src
javac Tokenizer.java -d ..\Class
java -cp ..\Class Tokenizer

 
IN-INIIBT812 

-------------------------------------------------------------------------------
System properties:
	The value of system properties can be overwritten! [System.setProperties()]
	The setProperties method changes the set of system properties for the current running application. These changes are not persistent. That is, changing the system properties within an application will not affect future invocations of the Java interpreter for this or any other application. The runtime system re-initializes the system properties each time its starts up. If changes to system properties are to be persistent, then the application must write the values to some file before exiting and read them in again upon startup.
	The getProperties method determines the current system properties. First, if there is a security manager, its checkPropertiesAccess method is called with no arguments. This may result in a security exception. If there is no current set of system properties, a set of system properties is first created and initialized. 
	[from stackoverflow]:
	In java to pass the values between some classes we can use System.setProperty.
	NOTE:
	Wherever you store state via System properties, third-party libraries will be able to read it using reflection if they want. If you don't trust third-party libraries, don't use them. The problem is a design problem. Global variables are almost never a good idea, and passing values between classes using system properties is not good design.
	Occasionally it is necessary to modify system properties programmatically. However, you can end up with fragile applications by doing this. The system properties are typically used to configure JVM services during the initialization. If the order of class initialization changes for some reason, you could find that your application code is now setting the properties too late. If possible, it is better to set the properties via -D command line parameters.
	
	NOTE: you can change System properties using the -D option of the java command too.
-----------------------------------------------------------------------------------
InputSource in;
//Check if file exists.
if (new File(filename).exists()) {
	in = new InputSource(new FileInputStream(filename));
} else {
	in = new InputSource(this.getClass().getClassLoader().getResourceAsStream(filename));
}
	