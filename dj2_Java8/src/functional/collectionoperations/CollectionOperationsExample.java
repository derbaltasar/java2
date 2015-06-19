package functional.collectionoperations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class CollectionOperationsExample {
	
	public static String test(){
		return "";
	}
	
	public static void main(String[] args) {
		
		
		List<String> names= new ArrayList<String>(){
			{
				add("Max");
				add("Anton");
				add(null);  //1.""
				add("\nIlse");//2. \n weg
				add("");//3. "" weg
			}
		};
		

		//null-Werte mappen
		UnaryOperator<String> nullToEmty = str -> str==null?"":str;// lamda
		
		
		
		
		names.replaceAll(nullToEmty); //null Werte löschen
		names.replaceAll(String::trim);//leer-und Stuerzeichen 
		names.removeIf(String::isEmpty);
		System.out.println(names);

	}
}
