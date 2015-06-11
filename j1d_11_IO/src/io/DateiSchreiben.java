package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

public class DateiSchreiben {
	
	public static void dateiSchreiben(String path){
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
			bw.write("erste Zeile");
			bw.newLine();
			bw.write("zweite Zeile");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * bekommt Dateipfad und Liste mit Wörtern und schreibt diese 
	 * zeilenweise in eine Datei
	 */
	public static void dateiSchreiben(String path, List<String> list){
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
			for (String line : list) {
				bw.write(line);
				bw.newLine();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		dateiSchreiben("test2.txt");
		List<String> li = Arrays.asList("Max","Otto","Ina","Karl");
		dateiSchreiben("test3.txt",li);
		
		
	}

}
