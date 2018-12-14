import java.util.LinkedList;
import java.util.Iterator;

public class AcitveObjectEngine{
	public void addCommand(ICommand c){
		itsList.add(c);
	}
	
	public void run(){
		while(!itsList.isEmpty()){
			ICommand c = (ICommand)itsList.getFirst();
			itsList.removeFirst();
			c.execute();
			}
	}
	
	private LinkedList itsList = new LinkedList();
}