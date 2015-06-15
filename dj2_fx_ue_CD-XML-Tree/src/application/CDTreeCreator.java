package application;

import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import javafx.scene.control.TreeItem;

public class CDTreeCreator {
	
	
	public static TreeItem<String> createTree(String documentPath) {
		
		TreeItem<String> rootItem = new TreeItem<>("Catalog");
		//------------- zusammenbauen
		
		
		try {
			// Erzeugt Dokumentenbaum mit build
			SAXBuilder builder = new SAXBuilder(); 
			Document doc = builder.build(documentPath);// XML laden
			
			Element catalogElement = doc.getRootElement();// <CATALOG>
			
			List<Element> cdElemente = catalogElement.getChildren();//<CD><CD><CD><CD>
			
			for (Element cdElement : cdElemente) {
			//	System.out.println(cdElement.getChild("TITLE").getText());
				
				TreeItem<String> cdItem = new TreeItem<>(cdElement.getChild("TITLE").getText());
				
				rootItem.getChildren().add(cdItem);//
								
				List<Element> cdDataElemente = cdElement.getChildren();//<TITLE>,<ARTIST>,<COUNTRY>,...
				for (Element cdDataElement : cdDataElemente) {
					//TITLE: Empire...
					String cdDataElementLabel = cdDataElement.getName()+": "+cdDataElement.getTextTrim();
					TreeItem<String> entyItem = new  TreeItem<>(cdDataElementLabel);
					cdItem.getChildren().add(entyItem);
				}
			}

		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
		return rootItem;
	}
	
	public static void main(String[] args) {
		createTree("cd-catalog.xml");
	}

}
