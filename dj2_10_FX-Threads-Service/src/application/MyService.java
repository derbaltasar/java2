package application;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class MyService extends Service<String>{

	@Override
	protected Task<String> createTask() {
		Task<String> task = new Task<String>(){

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
	
	
	
	
	
	
}
