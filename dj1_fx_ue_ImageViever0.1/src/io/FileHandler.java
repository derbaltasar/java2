package io;

import java.io.File;
import java.io.FilenameFilter;

public class FileHandler {
	/**
	 * 
	 * @param path zum Verzeichnis
	 * @return File-Array mit Bild-Pfaden
	 */
	public static File[] getImageFiles(String pathName){
		File dir = new File(pathName); 
		File[] files = dir.listFiles(new ImageFilter() );
		
		return files;
	}
	
	
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

}
