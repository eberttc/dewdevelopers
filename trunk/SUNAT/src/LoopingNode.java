import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class LoopingNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String path="C:/Users/pc/Downloads/employee.xml";
		try {
			
			DocumentBuilderFactory f=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=f.newDocumentBuilder();
			Document doc=builder.parse(path);
			doc.getDocumentElement().normalize();
			
			System.out.println("doc.getNodeName()-->"+doc.getDocumentElement().getNodeName());
			
			if(doc.hasChildNodes()){
				
				NodeList lista=doc.getChildNodes();
				printNote(lista);
				
			}
			
			}catch (Exception e) {
				// TODO: handle exception
			}

	}
	
	 private static void printNote(NodeList lista) {
		 
		 try {
			 
			for (int i = 0; i < lista.getLength(); i++) {
				
				Node TempNode=lista.item(i);
				
				if(TempNode.getNodeType()==Node.ELEMENT_NODE){
					
					System.out.println("\nNodo Name:"+TempNode.getNodeName());
					System.out.println("Nodo Vlues:"+TempNode.getTextContent());
					
					
					if(TempNode.hasAttributes()){
						
						NamedNodeMap map=TempNode.getAttributes();
						
						for (int j = 0; j < map.getLength(); j++) {
							
							Node Anodo=map.item(j);
							
							System.out.println("attr name : " + Anodo.getNodeName());
							System.out.println("attr value : " +Anodo.getNodeValue());
							
						}
					}
					
					if(TempNode.hasChildNodes()){
						printNote(TempNode.getChildNodes());
					}
				}
			
				
			}
		}
		
	 catch (Exception e) {
				// TODO: handle exception
	}
	 }

}

