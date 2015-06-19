package dateandtime;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;


/**
 * Zeitpunkt in Nanosekunden im Bezug zu Referenzzeit:1.1.1970 00:00:00
 * 
 * @author micha
 *
 */
public class InstantExample {
	
	public static void main(String[] args) {
		Instant abfahrtsZeit = Instant.now();
		Instant ankunftsZeit = abfahrtsZeit.plus(5,ChronoUnit.HOURS);
		Instant verspaetung = ankunftsZeit.plus(Duration.ofMinutes(7));
 		System.out.println("Abfahrt: "+abfahrtsZeit);
		System.out.println("Ankunft: "+ankunftsZeit);
		
		System.out.println("Ankunft+Verspätung: "+verspaetung);
	}

}
