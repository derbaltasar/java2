package application;
	
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;


public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			MyService service = new MyService();// das ist unser Thread
			
			TilePane root = new TilePane();
			Scene scene = new Scene(root,500,400);
			Label l1 = new Label();
			Label l2 = new Label();
			Label l3 = new Label();
			ProgressIndicator pi = new ProgressIndicator();
			Button b1 =   new Button("Start");
			Button b2 =   new Button("Restart");
			
				
				///   <--------
			l1.textProperty().bind(service.messageProperty());//updateMessage
			l2.textProperty().bind(service.valueProperty());//updateValue
			l3.textProperty().bind(service.progressProperty().asString());// updateProgress
			pi.progressProperty().bind(service.progressProperty());
			l2.setMinWidth(100);
			
			//-------------------------------------------------------
			b1.setOnAction( event ->{
				service.start();
			});
			
			b2.setOnAction(event ->{
				service.restart();
			});
			
			
			
			//-----------------------------------------------------
			service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
				
				@Override
				public void handle(WorkerStateEvent event) {
					String value= event.getSource().getValue().toString();// return (Ergebnis)
					System.out.println("setOnSucceeded value: "+value);
					
				}
			});
			
			root.getChildren().addAll(b1,b2,pi,l1,l3,l2);
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
