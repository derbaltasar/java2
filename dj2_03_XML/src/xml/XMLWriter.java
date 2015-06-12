

package xml;

import java.awt.event.ItemEvent;
import java.io.FileWriter;


import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * 
 * Java 2
 * @author M. Schirmer (Dozent)
 * dj2_03_XML: XMLWriter.java
 * 12.06.2015
 */

public class XMLWriter {

	public static void writeXML(String path) {
		Element abteilungElement = new Element("Abteilung");
		Document doc = new Document();
		doc.setRootElement(abteilungElement);
		Element itElement = new Element("IT");
		
		itElement.setAttribute(new Attribute("id", "1"));
		
		itElement.addContent(new Element("firstname").setText("Max"));
		itElement.addContent(new Element("lastname").setText("Meier"));
		
		//<![CDATA[  für Text mit Sonderzeichen
		itElement.addContent("<![CDATA[ if (a < b && a < 0) ....]]>");
		doc.getRootElement().addContent(itElement);//abteilungElement.addContent(itElement)
		
		XMLOutputter xmlOutput = new XMLOutputter();
		 
		// display nice nice
		xmlOutput.setFormat(Format.getPrettyFormat());
		try {
			xmlOutput.output(doc, new FileWriter(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
 
		System.out.println("File Saved!");
		
	}
		

	public static void main(String[] args) {
		// readXML("menu.xml");
		writeXML("abteilung.xml");
	}

}
