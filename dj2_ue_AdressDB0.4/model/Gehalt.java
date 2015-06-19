package de.cimdata.dbtable.model;

import java.math.BigDecimal;

public class Gehalt {
	private String name;
	private BigDecimal netto;
	public Gehalt(String name, BigDecimal netto) {
		super();
		this.name = name;
		this.netto = netto;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getNetto() {
		return netto;
	}
	public void setNetto(BigDecimal netto) {
		this.netto = netto;
	}
	@Override
	public String toString() {
		return "Gehalt [name=" + name + ", netto=" + netto + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((netto == null) ? 0 : netto.hashCode());
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
		Gehalt other = (Gehalt) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (netto == null) {
			if (other.netto != null)
				return false;
		} else if (!netto.equals(other.netto))
			return false;
		return true;
	}
	
	
	
	

}
