package myobserver;

import java.awt.Point;
import java.util.Observable;

public class Data extends MyObservable {

	int counter = 0; // Daten

	public void count() {

		while (true) {
			counter++;  // Daten ändern

			try {
				Thread.sleep(1000); // pausieren

				System.out.println("Datenbasis: " + counter);

				setChanged();// Daten haben sich geändert
				//notifyObservers(); // zum Observer senden
				System.out.println(isChanged());
				notifyObservers(new Point(23,45));  // mit Datenobject
				System.out.println(isChanged());
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
	}

}
