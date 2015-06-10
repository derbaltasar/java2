package application;

import io.ImageFileHandler;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import model.Picture;

public class ImageViewController implements Initializable {
	
	
	
	@FXML
	private Slider sliderSize;
	
	@FXML
	private Slider sliderOpacity;

	@FXML
	private ImageView mainImageView;

	@FXML
	private TableView<Picture> imageTableView;
	
	
	@FXML
	
	private ScrollPane imageScroll;

	// Event Listener on MenuItem.onAction
	private ImageFileHandler ifh = new ImageFileHandler();

	private ObservableList<Picture> oList = FXCollections.observableArrayList();

	@FXML
	public void open(ActionEvent event) {
		System.out.println("open..");

		DirectoryChooser dc = new DirectoryChooser();
		dc.setTitle("Open Image Folder");
		dc.setInitialDirectory(new File(
				"C:/Users/Public/Pictures/Sample Pictures"));
		File file = dc.showDialog(null);// TODO Benhandeln
		String path = file.getAbsolutePath();
		System.out.println(path);
		oList = ifh.createPictureList(path); // ObservableList füllen

		imageTableView.setItems(oList);
		
		

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		imageTableView.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> {
					String path = newValue.getPath();
					System.out.println("select path" + path);
					mainImageView.setImage(new Image("file:///" + path));
				}

				);
		
		
		//------------------Slider
//		
//		sliderSize.valueProperty().addListener( new ChangeListener<Number>() {
//
//			@Override
//			public void changed(ObservableValue<? extends Number> observable,
//					Number oldValue, Number newValue) {
//				System.out.println(newValue);
//				mainImageView.setScaleX(newValue.doubleValue());
//				mainImageView.setScaleY(newValue.doubleValue());
//			}
//		});
//		
	
		mainImageView.scaleXProperty().bind(sliderSize.valueProperty());
		mainImageView.scaleYProperty().bind(sliderSize.valueProperty());
		mainImageView.opacityProperty().bind(sliderOpacity.valueProperty());
		
		//mainImageView.fitWidthProperty().bind(sliderSize.valueProperty());
		
		
		mainImageView.fitHeightProperty().bind(imageScroll.heightProperty());
		mainImageView.fitWidthProperty().bind(imageScroll.widthProperty());
	}
}
