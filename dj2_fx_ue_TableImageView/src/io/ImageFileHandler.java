package io;

import java.io.File;
import java.io.FilenameFilter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Picture;

public class ImageFileHandler {
	public ObservableList<Picture> createPictureList(String path){
		ObservableList<Picture> oList = FXCollections.observableArrayList();
		File file = new File(path);
		File[] files =file.listFiles(new ImageFilter());
		
		for (File f : files) {
			//------------- long zu LocalDate (unsere Picture-Klasse besitzt diesen Datentyp)
			long modLong = f.lastModified();
			Date date = new Date(modLong);// long -> Date
			Instant instant = date.toInstant();
			LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
			//------------------------------------------------------------------------
			oList.add(new Picture(f.getName(), f.getAbsolutePath(), localDate));
		}
		return oList;
	}
	
	
	// -------- Filter
	static class ImageFilter implements FilenameFilter{
		@Override
		public boolean accept(File dir, String name) {
			name = name.toLowerCase();
			return 	name.endsWith(".gif") ||
					name.endsWith(".bmp") || 
					name.endsWith(".jpg") || 
					name.endsWith(".png") || 
					name.endsWith(".jpeg") ;
		}
		
	}
	
	
	public static void main(String[] args) {
		
		ImageFileHandler ih = new ImageFileHandler();
		System.out.println(ih.createPictureList("C:/Users/Public/Pictures/Sample Pictures"));
		
	}

}
