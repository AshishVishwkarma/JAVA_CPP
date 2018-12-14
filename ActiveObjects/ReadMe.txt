set path=%path%;C:\Program Files\Java\jdk1.8.0_101\bin
cd C:\Ashish\java_project\ActiveObjects
javac ICommand.java AcitveObjectEngine.java SleepCommand.java TestEngine.java -d Class
java -cp Class TestEngine

