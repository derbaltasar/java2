package application;
	
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			TilePane root = new TilePane();
			Scene scene = new Scene(root,500,400);
			Label l1 = new Label();
			Label l2 = new Label();
			Label l3 = new Label();
			ProgressIndicator pi = new ProgressIndicator();
			Button b1 =   new Button("Start");
			b1.setOnAction( event ->{
				System.out.println(event);
				Task<String> task = getTask();
				Thread t1 = new Thread(task);
				t1.start();
				
				
				///   <--------
				l1.textProperty().bind(task.messageProperty());//updateMessage
				l2.textProperty().bind(task.valueProperty());//updateValue
				l3.textProperty().bind(task.progressProperty().asString());// updateProgress
				
				l2.setMinWidth(100);
				pi.progressProperty().bind(task.progressProperty());
			});
			
			root.getChildren().addAll(b1,pi,l1,l3,l2);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private Task<String> getTask(){
		Task<String> task = new Task<String>() {
			
			@Override
			protected String call() throws Exception {
				updateMessage("Task start....");
				final int MAX = 10000000; // Abbruchbedingung
				long result = 0;
				for (int i = 0; i < MAX; i++) {
					if(isCancelled()){  //stop task.cancelled()
						break;
					}
					result+=i; // irgend etwas rechnen
					updateValue(result+"");// Zwischenergebnis
					updateProgress(i, MAX);
				}
				
				return "Result: "+result;// Ergbnis liefern
			}
		};
		
		return task;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
