package myobserver;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

public class Beobachter implements MyObserver{

	@Override
	public void update(MyObservable o, Object obj) {
		Data d =(Data)o;
		
		System.out.println("Beobachter: "+d.counter);
		
		
		Point p = (Point) obj;  // Datenobjekt
		System.out.println(p);
		
	}

}
