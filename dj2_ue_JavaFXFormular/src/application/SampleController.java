package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class SampleController {
	@FXML
	private TextField vornameField;
	@FXML
	private TextField nachnameField;
	@FXML
	private TextArea mitteilungField;
	@FXML
	private DatePicker datumField;
	@FXML
	private ImageView imageView;
	
	@FXML
	private Label label;

	// Event Listener on MenuItem.onAction
	@FXML
	public void closeAction(ActionEvent event) {
		System.exit(0);
	}
	// Event Listener on MenuItem.onAction
	@FXML
	public void openAction(ActionEvent event) {
		FileChooser fc = new FileChooser();
		File file = fc.showOpenDialog(null);
		String path = file.getAbsolutePath();
		System.out.println(path);
	}
	// Event Listener on Button.onAction
	@FXML
	public void send(ActionEvent event) {
		System.out.printf("%s %s", vornameField.getText(),nachnameField.getText());
		label.setText(vornameField.getText()+" "+nachnameField.getText()+" "+datumField.getValue());
		
	
		
		
	}
}
