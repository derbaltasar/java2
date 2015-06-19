package functional.defaultmethod;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Standardmethoden sort, foreach
 * @author micha
 *
 */
public class DefaultMethodExample {
	
	public void m1(String s){
		System.out.println(s.toUpperCase());
	}
	
	public static void m2(String s){
		System.out.println(s.replace("a", "i"));
	}
	
	
	
	
	public static void main(String[] args) {
		final List<String> names= Arrays.asList("Max","Anton","Maria","Ina");
		names.sort(Collections.reverseOrder());//Standard-Comparator
		names.forEach(new DefaultMethodExample()::m1);//Object-Method
		names.forEach(DefaultMethodExample::m2);//Static-Method
		names.forEach(System.out::println);
		
		// TYP oder REFERENZ::METHODENNAME
		
		
	}

}
