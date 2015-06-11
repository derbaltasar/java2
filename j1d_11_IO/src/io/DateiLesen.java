package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DateiLesen {

	
	
	
	
	
	public static void fileReaderRead(String path) {
		// BufferedReader ist optional
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = "";
			while ((line = br.readLine()) != null) {// readLine-> eine Zeile
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("Exception...");
			e.printStackTrace();
		}
	}

	// /-----------besser--------------------
	public static void scannerRead(String path) {
		try (Scanner sc = new Scanner(new File(path))) {
			while (sc.hasNext()) {
				System.out.println(sc.nextLine());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		fileReaderRead("test1.txt");
		
		ArrayList<Integer> li = new ArrayList<>();
		
		for (Iterator iterator = li.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			
		}
		

	}

}
