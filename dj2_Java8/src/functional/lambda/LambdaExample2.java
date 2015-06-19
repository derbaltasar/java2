package functional.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Observer;

/*
 * Comperator: für Sortierung von Zeichenketten ohnen Berücksichtigung 
 * von Leerraum
 */
class LengthComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;
		return 0;
	}
}

/**
 * Lambda: ähnl. Methode aber keinen Namen und ohne explizite Angabe eines
 * Rückgabetyps
 * 
 * @author micha
 *
 */
public class LambdaExample2 {

	public static void main(String[] args) {
		String[] words = { "wee", "Ma", "Qooo", "Quark", "342342" };
		// Standard sort
		Arrays.sort(words);
		System.out.println(Arrays.toString(words));
		// sort mit Comperator
		Arrays.sort(words, new LengthComparator());
		System.out.println(Arrays.toString(words));



		// Comperator mit Lambda
		Comparator<String> lengthComp = (s1, s2) -> {
			return Integer.compare(s1.length(), s2.length());
		};
		
		Arrays.sort(words, lengthComp);

		// !!!
		// Ein lambda-Ausdruck kann NUR einem Functional Interface-Object
		// zugewiesen werden(Comperator ist ein solches)->Interfaces mit einer
		// Methodendefinition
	


		// ------------------ Beispiel Thread und
		// Runnable-----------------------------------

		Thread t1 = new Thread(() -> System.out.println("run......"));// Runnable

	}

}
