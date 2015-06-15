package de.cimdata.dbtable.db;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * soll den Umgang mit Properties erleichtern : DBProp.get(...)
 * Java 2(cimdata)
 * @author Dozent Michael Schirmer
 * micha.schirmer@gmail.com
 * Project: d_j2_04_Datenbank 
 * db.DBProp.java
 */
public final class DBProp {
	
	public final static String PROPERTY_PATH = "de/cimdata/dbtable/properties/db.properties";
	
	private static Properties props;
	
	private DBProp(){}
		
	static{//statischer Konstruktor (wird beim Laden der Klasse aufegrufen)
		props = new Properties();
		
		
		try {
			props.load(new BufferedInputStream  ( DBProp.class.getResourceAsStream(PROPERTY_PATH))   );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String get(String key){
		return props.getProperty(key);
	}

}
