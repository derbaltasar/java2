package observer;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

public class Beobachter implements Observer{

	@Override
	public void update(Observable o, Object obj) {
		Data d =(Data)o;
		
		System.out.println("Beobachter: "+d.counter);
		
		
		Point p = (Point) obj;  // Datenobjekt
		System.out.println(p);
		
	}

}
