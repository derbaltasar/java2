package application;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;


/**
 * JavaFX  Bean
 * Java 2
 * @author M. Schirmer (Dozent)
 * dj2_02_Binding: Temperatur.java
 * 10.06.2015
 */
public class Temperatur {
	private FloatProperty gradCelsius = new SimpleFloatProperty();

	public final FloatProperty gradCelsiusProperty() {
		return this.gradCelsius;
	}

	public final float getGradCelsius() {
		return this.gradCelsiusProperty().get();
	}

	public final void setGradCelsius(final float gradCelsius) {
		this.gradCelsiusProperty().set(gradCelsius);
	}
	
	
	

}
