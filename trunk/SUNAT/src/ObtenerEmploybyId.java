import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ObtenerEmploybyId {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DocumentBuilderFactory f=DocumentBuilderFactory.newInstance();
		String path="C:/Users/pc/Downloads/employee.xml";
		try {
			
			DocumentBuilder b=f.newDocumentBuilder();
			Document doc=b.parse(new File(path));
			
			doc.getDocumentElement().normalize();
			
			NodeList listado=doc.getElementsByTagName("Employee");
			Element el = null;
			for (int i = 0; i < listado.getLength(); i++) {
				
				Node nNone=listado.item(i);
				
				if(nNone.getNodeType()==Node.ELEMENT_NODE){
					Element e=(Element)nNone;
					
					if(e.getAttribute("id").equals("M1")){
						el=e;
						break;
					}
				}
			}
			
			
		
			System.out.println("id : " + el.getAttribute("id"));
			System.out.println("id : " + el.getElementsByTagName("name").item(0).getTextContent());			
			System.out.println("id : " + el.getElementsByTagName("age").item(0).getTextContent());
			System.out.println("id : " + el.getElementsByTagName("role").item(0).getTextContent());
			System.out.println("id : " + el.getElementsByTagName("salary").item(0).getTextContent());
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

