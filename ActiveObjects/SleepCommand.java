public class SleepCommand implements ICommand{
	public SleepCommand(double delayTime, AcitveObjectEngine e, ICommand w){
		itsDelayTime = delayTime;
		itsEngine = e;
		itsWakeupCommand = w;
	}
	
	public void execute(){
		double currentTime = System.currentTimeMillis();
		if(!start){
			start = true;
			startTime = currentTime;
			itsEngine.addCommand(this);
		}
		else if(currentTime - startTime < itsDelayTime){
			itsEngine.addCommand(this);
		}
		else{
			itsEngine.addCommand(itsWakeupCommand);
		}
	}
	
	private double itsDelayTime = 0;
	private double startTime = 0;
	private AcitveObjectEngine itsEngine = null;
	private ICommand itsWakeupCommand = null;
	private boolean start = false;
}



