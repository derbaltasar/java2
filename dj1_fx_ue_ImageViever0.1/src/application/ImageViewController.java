package application;

import io.FileHandler;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.stage.DirectoryChooser;

public class ImageViewController implements Initializable{
	
	
	@FXML
	private TilePane thumbnailPane;
	
	
	@FXML
	private ImageView mainImageView;
	

	// Event Listener on MenuItem.onAction
	@FXML
	public void open(ActionEvent event) {
		DirectoryChooser dc = new DirectoryChooser();
		dc.setTitle("Open Image Folder");
		
		
		File file = dc.showDialog(null);
		File[] imagefiles = FileHandler.getImageFiles(file.getAbsolutePath());
		
		for (File imgFile : imagefiles) {
			ImageView iv = new ImageView(new Image("file:///"+imgFile.getAbsolutePath()));
			
			iv.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					mainImageView.setImage(iv.getImage());
					
				}
			});
			iv.setFitWidth(100);
			iv.setPreserveRatio(true);
			iv.setSmooth(true);
			iv.setCache(true);
			thumbnailPane.getChildren().add(iv);
		}
		
		//thumbnailPane.getCacheHint().add()
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
}
