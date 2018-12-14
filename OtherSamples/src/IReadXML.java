import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;
import java.io.IOException;

// Two classes are created: IReadXML.class and IReadXML$DefReadXML.class

// Interface for reading XML
public interface IReadXML{
	// NOTE: pubic modifier is optional in the methods' signature.
	// All method declarations in an interface, including default methods, are implicitly public. 
	
	public void openFile(String file_name) throws IOException;
	public void closeFile();
	/**
	* Returns name of the document element (or root).
	*/
	public String getRootElement();
	
	/**
	* Returns name of the child elements of document element (or root).
	*/
	public List getRChildElements();
	
	public List getChildElements(short index);
	//public Set getChildElements(short index);
		
	/**
	* Returns single value for a tag (ignores duplicate tag (name) under an element (index))
	*/
	public String getValue(short index, String name);
	
	public List getValues(short index, String name);
	
	public List getValues(String path, String delimeter);
	
	default String getValue(String path, String delimeter){
		String str = new String(); return str; // should throw exception indicating that this method is not supported by the implementation class.
	}
	
	
	public class DefReadXML implements IReadXML {
		//private Document idoc;
		
		public void openFile(String file_name) throws IOException{}
		public void closeFile(){}
		public String getRootElement(){String str = new String("A"); return str;}
		public List getRChildElements(){List list = new Vector(); return list;}
		public List getChildElements(short index){List list = new Vector(); return list;}
		//public Set getChildElements(short index){Set set = new HashSet(); return set;}
		public String getValue(short index, String name){String str = new String("A"); return str;}
		public List getValues(short index, String name){List list = new Vector(); return list;}
		public List getValues(String path, String delimeter){List list = new Vector(); return list;}
	}
	
}