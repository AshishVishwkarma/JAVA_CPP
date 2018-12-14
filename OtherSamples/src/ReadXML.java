import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;


public class ReadXML implements IReadXML {
	protected Document iDoc;
	
	public void openFile(String fileName) throws IOException{
		try{
			File inputFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			iDoc = dBuilder.parse(inputFile);
		}
		catch(SAXException saxEx){System.out.println("SAXException occurred!");}
		catch(ParserConfigurationException configEx){System.out.println("Parser is not properly configured!");}
		catch(IOException ex){throw ex;}
	}
	
	public void closeFile(){iDoc = null;}
	
	
	public String getRootElement(){
		if (iDoc == null) return null; // Should throw an exception
		return iDoc.getDocumentElement().getTagName();
	}
	
	public List getRChildElements(){
		if (iDoc == null) return null; // Should throw an exception
		List list = new Vector(); 
		
		//NodeList nlist = iDoc.getElementsByTagName(iDoc.getDocumentElement().getTagName());
		//for( int i=0; i < nlist.getLength(); i++){
		//	NodeList childNList = nlist.item(i).getChildNodes();
		//	for( int j=0; j< childNList.getLength(); j++){
		//		//System.out.println("Node type: "+childNList.item(j).getNodeType()+", Node name: "+childNList.item(j).getNodeName()+", Node value: "+childNList.item(j).getNodeValue());
		//		switch(childNList.item(j).getNodeType()){
		//			case Node.TEXT_NODE: break;
		//			case Node.ELEMENT_NODE:
		//				list.add(childNList.item(j).getNodeName()); break;
		//			default: break;
		//		}
		//	}
		//}
		
		NodeList nlist = iDoc.getDocumentElement().getChildNodes();
		for( int i=0; i < nlist.getLength(); i++){
			switch(nlist.item(i).getNodeType()){
				case Node.TEXT_NODE: break;
				case Node.ELEMENT_NODE:
					list.add(nlist.item(i).getNodeName()); break;
				default: break;
			}
		}
		return list;
	}
	
	//public Set getChildElements(short index){
	//	if (iDoc == null) return null; // Should throw an exception
	//	Set set = new HashSet();
	//	if( 2*index > iDoc.getDocumentElement().getChildNodes().getLength())
	//		return null; // Should throw an exception (not so many elements!)
	//	Node node = iDoc.getDocumentElement().getChildNodes().item(2*index-1); // there are TEXT_NODE
	//	if( Node.ELEMENT_NODE != node.getNodeType()) return null; // Should throw an exception
	//	NodeList nlist = node.getChildNodes();
	//	for( int i=0; i < nlist.getLength(); i++){
	//		switch(nlist.item(i).getNodeType()){
	//			case Node.TEXT_NODE: break;
	//			case Node.ELEMENT_NODE:
	//				set.add(nlist.item(i).getNodeName()); break;
	//			default: break;
	//		}
	//	}
	//	return set;
	//}
	
	public List getChildElements(short index){
		if (iDoc == null) return null; // Should throw an exception
		List list = new Vector();
		if( 2*index > iDoc.getDocumentElement().getChildNodes().getLength())
			return null; // Should throw an exception (not so many elements!)
		Node node = iDoc.getDocumentElement().getChildNodes().item(2*index-1); // there are TEXT_NODE
		if( Node.ELEMENT_NODE != node.getNodeType()) return null; // Should throw an exception
		NodeList nlist = node.getChildNodes();
		for( int i=0; i < nlist.getLength(); i++){
			switch(nlist.item(i).getNodeType()){
				case Node.TEXT_NODE: break;
				case Node.ELEMENT_NODE:
					list.add(nlist.item(i).getNodeName()); break;
				default: break;
			}
		}
		
		// Remove duplicates without changing order
		//list = new ArrayList(new HashSet(list)); -- Order gets changed.
		// list = new LinkedHashSet(list);
		
		// Remove duplicates without changing order (Java 8)
		list = (List)list.stream().distinct().collect(Collectors.toList());
		return list;
	}
	
	public String getValue(short index, String name){
		if (iDoc == null) return null; // Should throw an exception
		String str;
		if( 2*index > iDoc.getDocumentElement().getChildNodes().getLength())
			return null; // Should throw an exception (not so many elements!)
		Node node = iDoc.getDocumentElement().getChildNodes().item(2*index-1); // there are TEXT_NODE
		if( Node.ELEMENT_NODE != node.getNodeType()) return null; // Should throw an exception
		Element elm = (Element) node;
		
		//if( 1 < elm.getElementsByTagName(name).getLength()) return null; // Should throw an exception
		str = elm.getElementsByTagName(name).item(0).getTextContent();
		return str;
	}
	
	public List getValues(short index, String name){
		if (iDoc == null) return null; // Should throw an exception
		List list = new Vector(); 
		if( 2*index > iDoc.getDocumentElement().getChildNodes().getLength())
			return null; // Should throw an exception (not so many elements!)
		Node node = iDoc.getDocumentElement().getChildNodes().item(2*index-1); // there are TEXT_NODE
		if( Node.ELEMENT_NODE != node.getNodeType()) return null; // Should throw an exception
		Element elm = (Element) node;
		
		//for(int i=0; i<elm.getElementsByTagName(name).getLength(); i++)
		//	System.out.print(elm.getElementsByTagName(name).item(i).getTextContent()+", ");
		//System.out.println("\n");
		
		for(int i=0; i<elm.getElementsByTagName(name).getLength(); i++)
			list.add(elm.getElementsByTagName(name).item(i).getTextContent());
		
		return list;
	}
	
	public List getValues(String path, String delimeter){
		List list = new Vector(); 
		List tags = Tokenizer.listTokenize(path, delimeter);
		
		//if(0 != getRootElement().compareTo((String)tags.get(0))) return null; // Should throw an exception 
		if(0 != getRootElement().compareTo((String)tags.get(0))) return list; // Should throw an exception 
		
		parseNodesByLevel(iDoc.getElementsByTagName((String)tags.get(1)), 2, tags, list);
		
		return list;
	}
	
	private void parseNodesByLevel(final NodeList nodes, final int level, final List tags, List list){
		if (null == nodes){
			return;
		}
		// We did not get null for NodeList. We get empty NodeList, i.e., nodes.getLength() == 0
		
		if(level == tags.size()){
			for(int i=0; i<nodes.getLength(); i++){
				switch(nodes.item(i).getNodeType()){
					case Node.TEXT_NODE: 
						break;
					case Node.ELEMENT_NODE:
						list.add(nodes.item(i).getTextContent()); break;
					default: 
						break;
				}
			}
			return;
		}
		
		for(int i=0; i<nodes.getLength(); i++){
			switch(nodes.item(i).getNodeType()){
				case Node.TEXT_NODE: break;
				case Node.ELEMENT_NODE:
					Element elm = (Element)nodes.item(i);
					NodeList nlist = elm.getElementsByTagName((String)tags.get(level)); 
					parseNodesByLevel(nlist, level+1, tags, list);
				default: break;
			}
		}
	}
	
}