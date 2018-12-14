	set path=%path%;C:\Program Files\Java\jdk1.8.0_101\bin

JUNIT:
	C:\Ashish\Source_Code\PHX_LOCAL_REPO\junit\junit\4.12\junit-4.12.jar

	set JUNIT_HOME=C:\Ashish\Source_Code\PHX_LOCAL_REPO\junit\junit\4.12
	set HAMREST_HOME=C:\Ashish\Source_Code\PHX_LOCAL_REPO\org\hamcrest\hamcrest-core\1.3.RC2
	
	cd C:\Ashish\java_project\BuilderPattern
	javac -cp Class;%JUNIT_HOME%\junit-4.12.jar NutritionFacts.java TestBuilderPattern.java TestRunner.java -d Class
	java -cp Class;%JUNIT_HOME%\junit-4.12.jar;%HAMREST_HOME%\hamcrest-core-1.3.RC2.jar TestRunner TestBuilderPattern
	
	cd C:\Ashish\java_project\BuilderPattern
	javac -cp Class;%JUNIT_HOME%\junit-4.12.jar Pizza.java NyPizza.java TestNyPizza.java TestRunner.java -d Class
	java -cp Class;%JUNIT_HOME%\junit-4.12.jar;%HAMREST_HOME%\hamcrest-core-1.3.RC2.jar TestRunner TestNyPizza
	
	cd C:\Ashish\java_project\BuilderPattern
	javac -cp Class;%JUNIT_HOME%\junit-4.12.jar PizzaTwo.java NyPizzaTwo.java TestNyPizzaTwo.java TestRunner.java -d Class
	java -cp Class;%JUNIT_HOME%\junit-4.12.jar;%HAMREST_HOME%\hamcrest-core-1.3.RC2.jar TestRunner TestNyPizzaTwo