import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class PracticaXML {

	
	public static void main(String[] args) {
		
		String path="C:/Users/pc/Downloads/employee.xml";
		
		File xmlFile = new File(path);
	    DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder;
	    
		try {
			
			builder=factory.newDocumentBuilder();
			Document doc=builder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			
			//update attribute value
            updateAttributeValue(doc);
             
            //update Element value
            updateElementValue(doc);
             
            //delete element
            deleteElement(doc);
             
            //add new element
            addElement(doc);
			
            doc.normalize();
            
            TransformerFactory tfactory=TransformerFactory.newInstance();
            Transformer trans=tfactory.newTransformer();
            DOMSource source=new DOMSource(doc);
            
            StreamResult r=new StreamResult(new File("C:/Users/pc/Downloads/employee.xml"));
            trans.setOutputProperty(OutputKeys.INDENT,"yes");
            trans.transform(source,r);
            System.out.println("XML file updated successfully");
            
            
		} catch (Exception e) {
			
		} 
		
		
	
	}

	private static void addElement(Document doc) {
		NodeList list=doc.getElementsByTagName("Employee");
		Element el;
		
		for (int i = 0; i <list.getLength(); i++) {
		
			el=(Element)list.item(i);
			Element element=doc.createElement("salary");
			element.appendChild(doc.createTextNode("2000"));
			el.appendChild(element);
			
			
		}

		
	}

	private static void deleteElement(Document doc) {
		NodeList list=doc.getElementsByTagName("Employee");
		Element element;
		
		for (int i = 0; i < list.getLength(); i++) {
			
			element=(Element) list.item(i);
			Node node=element.getElementsByTagName("gender").item(0);
			element.removeChild(node);
												
		}
		
		
	}

	private static void updateElementValue(Document doc) {
		NodeList list=doc.getElementsByTagName("Employee");
		Element el;
		
		for (int i = 0; i <list.getLength(); i++) {
			el=(Element) list.item(i);
			Node node=el.getElementsByTagName("name").item(0).getFirstChild();
			node.setNodeValue(node.getNodeValue().toUpperCase());
			
			
			
		}
		
	}

	private static void updateAttributeValue(Document doc) {
		
		NodeList lstNode=doc.getElementsByTagName("Employee");
		Element el;
		
		for (int i = 0; i < lstNode.getLength(); i++) {
						el=(Element)lstNode.item(i);
						String gender=el.getElementsByTagName("gender").item(0).getFirstChild().getNodeValue();
						
						if(gender.equalsIgnoreCase("male")){
							
							el.setAttribute("id","M"+el.getAttribute("id"));
						}else{
							
							el.setAttribute("id", "F"+el.getAttribute("id"));
						}
		}
		
	}
	
}
