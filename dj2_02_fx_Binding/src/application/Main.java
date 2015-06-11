package application;
	


import java.text.NumberFormat;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FlowPane root = new FlowPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Temperatur t = new Temperatur();
			
			Button b1 = new Button("+1");
			
			Button b2 = new Button("-1");
			
			ProgressBar pb = new ProgressBar();
			
			ProgressIndicator pi  = new ProgressIndicator();
			
			pb.progressProperty().bind(t.gradCelsiusProperty());
			pi.progressProperty().bind(t.gradCelsiusProperty());
			
			//Listener
			
			b1.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					
					t.setGradCelsius(t.getGradCelsius()+0.1F);
				}
			});
			

			b2.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					
					t.setGradCelsius(t.getGradCelsius()-0.1F);
				}
			});
			
			
			
			
			
			//////////---- oder alternativ Listener
			
			
			t.gradCelsiusProperty().addListener(new ChangeListener<Number>() {

				@Override
				public void changed(
						ObservableValue<? extends Number> observable,
						Number oldValue, Number newValue) {
					
					if(newValue.floatValue()<=1){
						System.out.println(newValue);
					}
					
				}
			});
			
			
			root.getChildren().addAll(b1,b2,pb,pi);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
