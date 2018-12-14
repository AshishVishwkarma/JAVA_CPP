public class TestEngine{
	public class TestCommand implements ICommand{
		TestCommand(double delay, char code){
			itsDelay = delay;
			itsCode = code;
		}
		
		public void execute(){
			System.out.print(itsCode);
			if(!stop)
				delayAndRepeat();
		}
		
		private void delayAndRepeat(){
			e.addCommand(new SleepCommand(itsDelay, e, this));
		}
		
		private double itsDelay = 0;
		private char itsCode = '0';
	}
	
	private static AcitveObjectEngine e = new AcitveObjectEngine();
	private static boolean stop = false;
	
	public static void main(String args[]){
		TestEngine obj = new TestEngine();
		
		e.addCommand(obj.new TestCommand(100, '1'));
		e.addCommand(obj.new TestCommand(300, '3'));
		e.addCommand(obj.new TestCommand(500, '5'));
		e.addCommand(obj.new TestCommand(700, '7'));
		
		ICommand stopCommand = new ICommand(){
			public void execute(){stop = true;}
		};
		
		e.addCommand(new SleepCommand(2000, e, stopCommand));
		e.run();
	}
}