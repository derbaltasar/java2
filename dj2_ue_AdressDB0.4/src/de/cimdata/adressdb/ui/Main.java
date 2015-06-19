package de.cimdata.adressdb.ui;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * - Tabs
 * - Daten zeigen (select all)
 * - neuer Datensatz
 * - R�ckmeldung
 * - update
 * - Datensatz l�schen (einen)
 * - Filter/ Suche/ ComboBox
 * neu:
 * - Fehlerbehandlung/ DBConnect->Meldung
 * - Aufr�umen: refactor
 * - clearTextFields-> Neuer Datensatz
 * - mehrere markierte Datens�tze l�schen
 * Java 2
 * @author M. Schirmer (Dozent)
 * dj2_ue_AdressDB0.2: Main.java
 * 17.06.2015
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AdressView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			System.out.println("Loader Error");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
