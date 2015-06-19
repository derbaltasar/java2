package de.cimdata.adressdb.ui;

public class ComboBoxData {
	
	private String label;
	private String value;
	
	
	public ComboBoxData(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return label;
	}

	
}
