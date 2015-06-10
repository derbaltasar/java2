package application;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable{
	private String vorname;
	private String nachname;
	private LocalDate geburtsdatum;
	
	
	public Person(String vorname, String nachname, LocalDate geburtsdatum) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsdatum = geburtsdatum;
	}
	public Person(String vorname, String nachname) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
	}
	public LocalDate getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(LocalDate geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	@Override
	public String toString() {
		return "Person [vorname=" + vorname + ", nachname=" + nachname
				+ ", geburtsdatum=" + geburtsdatum + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((geburtsdatum == null) ? 0 : geburtsdatum.hashCode());
		result = prime * result
				+ ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (geburtsdatum == null) {
			if (other.geburtsdatum != null)
				return false;
		} else if (!geburtsdatum.equals(other.geburtsdatum))
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}
	
	

	
}
