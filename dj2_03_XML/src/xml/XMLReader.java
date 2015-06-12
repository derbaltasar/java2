package xml;

import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XMLReader {

	public static void readXML(String filename){
		try {
			// Erzeugt Dokumentenbaum mit build
			SAXBuilder builder = new SAXBuilder(); 
			Document doc = builder.build(filename);// XML laden
			
			Element menubarElement = doc.getRootElement();// <menubar>
			
			List<Element> menuElemente = menubarElement.getChildren();
			
			for (Element menuElement : menuElemente) {
				String attributname= menuElement.getAttributeValue("name");
				System.out.println(attributname);
				List<Element> menuItems = menuElement.getChildren();
				for (Element menuItem : menuItems) {
					String itemText = menuItem.getTextTrim();
					System.out.println("\t"+itemText);
				}
				
				
			}
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		readXML("menu.xml");
	}

}
