package model;

import java.time.LocalDate;

public class Picture {

	private String name;
	private String path;
	private LocalDate lastMod;
	@Override
	public String toString() {
		return "Picture [name=" + name + ", path=" + path + ", lastMod="
				+ lastMod + "]";
	}
	public Picture(String name, String path, LocalDate lastMod) {
		super();
		this.name = name;
		this.path = path;
		this.lastMod = lastMod;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public LocalDate getLastMod() {
		return lastMod;
	}
	public void setLastMod(LocalDate lastMod) {
		this.lastMod = lastMod;
	}
	
	
	
}
