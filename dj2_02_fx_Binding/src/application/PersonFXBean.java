package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



public class PersonFXBean {
	private StringProperty vorname = new  SimpleStringProperty();
	private StringProperty nachname = new  SimpleStringProperty();
	private IntegerProperty alter = new SimpleIntegerProperty();
	private DoubleProperty gewicht = new SimpleDoubleProperty();
	
	public PersonFXBean(String vorname, String nachname) {
		this.vorname.set(vorname);
		this.nachname.set(nachname);
	}
	
	public String getVorname(){
		return vorname.get();
	}
	
	public void setVorname(String vorname){
		this.vorname.set(vorname);
	}
	
	public StringProperty vornameProperty(){
		return vorname;
	}

	public final StringProperty nachnameProperty() {
		return this.nachname;
	}

	public final java.lang.String getNachname() {
		return this.nachnameProperty().get();
	}

	public final void setNachname(final java.lang.String nachname) {
	
		
		this.nachnameProperty().set(nachname);
	}

	public final IntegerProperty alterProperty() {
		return this.alter;
	}

	public final int getAlter() {
		return this.alterProperty().get();
	}

	public final void setAlter(final int alter) {
		this.alterProperty().set(alter);
	}

	public final DoubleProperty gewichtProperty() {
		return this.gewicht;
	}

	public final double getGewicht() {
		return this.gewichtProperty().get();
	}

	public final void setGewicht(final double gewicht) {
		this.gewichtProperty().set(gewicht);
	}

}
