import java.util.List;
import java.util.Vector;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;
import org.xml.sax.InputSource;

import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeIterator;

import org.apache.xpath.XPathAPI;
import java.io.File;


//public class XpathXML extends ReadXML implements IReadXML {
public class XpathXML extends ReadXML{
	//private Document iDoc; this will hide the iDoc from ReadXML.
	
	@Override
	public void openFile(String fileName) throws IOException{
		try{
			InputSource inputSource;
			if(new File(fileName).exists())
				inputSource = new InputSource(new FileInputStream(fileName));
			else
				inputSource = new InputSource(this.getClass().getClassLoader().getResourceAsStream(fileName));
				
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			iDoc = dbFactory.newDocumentBuilder().parse(inputSource);
			// NOTE: dbFactory can be used to build DOM document for another XML file.
		}
		catch(SAXException saxEx){System.out.println("SAXException occurred!");}
		catch(ParserConfigurationException configEx){System.out.println("Parser is not properly configured!");}
		catch(IOException ex){throw ex;}
	}
	
	@Override
	public List getValues(String path, String delimeter){
		List list = new Vector(); 
		
		//System.out.println("Replaced path = "+path.replace(delimeter, "/"));
		
		try{
			NodeIterator nodeIter = XPathAPI.selectNodeIterator(iDoc, path.replace(delimeter, "/")); 
			Node node;
			while((node = nodeIter.nextNode()) != null){
				list.add(node.getTextContent());
			}
		}
		catch(TransformerException tex){System.out.println("TransformerException occurred!");}

		return list;
	}
	
	/**
	* Returns the value corresponding to the first node found.
	*/
	@Override
	public String getValue(String path, String delimeter){
		String str = new String();
		
		try{
			Node node = XPathAPI.selectSingleNode(iDoc, path.replace(delimeter, "/"));
			str = node.getTextContent();
		}
		catch(TransformerException tex){System.out.println("TransformerException occurred!");}
		
		return str;
	}
	
	
}