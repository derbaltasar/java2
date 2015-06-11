package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FileTest {
	
	
	
	public static void main(String[] args) {
		
		
		File f  = new File("C:/test");
		
		System.out.println(f.getAbsolutePath());
		
		String[] pfadNamen = f.list();
		
		System.out.println(Arrays.toString(pfadNamen));
		
		File[] pfadFiles = f.listFiles();
		System.out.println(Arrays.toString(pfadFiles));
		
		File[] pfadFilterFiles = f.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				name = name.toLowerCase();
				return 	name.endsWith(".gif") ||
						name.endsWith(".bmp") || 
						name.endsWith(".jpg") || 
						name.endsWith(".png") || 
						name.endsWith(".jpeg") ;
			}
		});
		
		System.out.println(Arrays.toString(pfadFilterFiles));
		
		// Java 8
	
		
		File[] pfadFilterFiles2 = f.listFiles((dir, name) -> {
			return 	name.endsWith(".gif") ||
					name.endsWith(".bmp") || 
					name.endsWith(".jpg") || 
					name.endsWith(".png") || 
					name.endsWith(".jpeg") ;
			
		});
			
		
		
		
		
	}

}
