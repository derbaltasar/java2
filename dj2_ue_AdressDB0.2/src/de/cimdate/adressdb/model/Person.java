package de.cimdate.adressdb.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
	
	private IntegerProperty id = new SimpleIntegerProperty();
	private StringProperty vorname = new SimpleStringProperty();
	private StringProperty nachname = new SimpleStringProperty();
	private StringProperty plz = new SimpleStringProperty();
	private StringProperty ort = new SimpleStringProperty();
	private StringProperty strasse = new SimpleStringProperty();
	private StringProperty telefon = new SimpleStringProperty();
	private StringProperty mobil = new SimpleStringProperty();
	private StringProperty email = new SimpleStringProperty();
	
	
	
	public Person(String vorname, String nachname,
			String plz, String ort, String strasse,
			String telefon, String mobil, String email) {

		this.vorname.set(vorname);
		this.nachname.set(nachname);
		this.plz.set(plz);
		this.ort.set(ort);
		this.strasse.set(strasse);
		this.telefon.set(telefon);
		this.mobil.set(mobil);
		this.email.set(email);
	
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", vorname=" + vorname + ", nachname="
				+ nachname + ", plz=" + plz + ", ort=" + ort + ", strasse="
				+ strasse + ", telefon=" + telefon + ", mobil=" + mobil
				+ ", email=" + email + "]";
	}
	public final IntegerProperty idProperty() {
		return this.id;
	}
	public final int getId() {
		return this.idProperty().get();
	}
	public final void setId(final int id) {
		this.idProperty().set(id);
	}
	public final StringProperty vornameProperty() {
		return this.vorname;
	}
	public final java.lang.String getVorname() {
		return this.vornameProperty().get();
	}
	public final void setVorname(final java.lang.String vorname) {
		this.vornameProperty().set(vorname);
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
	public final StringProperty plzProperty() {
		return this.plz;
	}
	public final java.lang.String getPlz() {
		return this.plzProperty().get();
	}
	public final void setPlz(final java.lang.String plz) {
		this.plzProperty().set(plz);
	}
	public final StringProperty ortProperty() {
		return this.ort;
	}
	public final java.lang.String getOrt() {
		return this.ortProperty().get();
	}
	public final void setOrt(final java.lang.String ort) {
		this.ortProperty().set(ort);
	}
	public final StringProperty strasseProperty() {
		return this.strasse;
	}
	public final java.lang.String getStrasse() {
		return this.strasseProperty().get();
	}
	public final void setStrasse(final java.lang.String strasse) {
		this.strasseProperty().set(strasse);
	}
	public final StringProperty telefonProperty() {
		return this.telefon;
	}
	public final java.lang.String getTelefon() {
		return this.telefonProperty().get();
	}
	public final void setTelefon(final java.lang.String telefon) {
		this.telefonProperty().set(telefon);
	}
	public final StringProperty mobilProperty() {
		return this.mobil;
	}
	public final java.lang.String getMobil() {
		return this.mobilProperty().get();
	}
	public final void setMobil(final java.lang.String mobil) {
		this.mobilProperty().set(mobil);
	}
	public final StringProperty emailProperty() {
		return this.email;
	}
	public final java.lang.String getEmail() {
		return this.emailProperty().get();
	}
	public final void setEmail(final java.lang.String email) {
		this.emailProperty().set(email);
	}
	

}
