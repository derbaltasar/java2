package dateandtime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Berücksichtigung von Zeitzohne und Sommerzeit
 * @author micha
 *
 */
public class ZoneDateTime {
	
	
	public static void main(String[] args) {
		
		//--------------- Zeit ändern --------------------------------------------------
		//aktuelle Zeit 
		ZonedDateTime now = ZonedDateTime.now();
		
		//Uhrzeit ändern
		ZonedDateTime nowChangeTime = now.withHour(11).withMinute(10);
		
		System.out.println(now);
		System.out.println(nowChangeTime);
		
		//--------------------- Beispiel2: Differenz berechnen ---------------------------
		
		String startTimeStr = "10:10:10";
		String endTimeStr = "11:20:30"; //Differenz: 1 Stunde, 10 Minuten, 20 Sekunden
		
		// in TimeObject wandeln
		LocalTime start = LocalTime.parse(startTimeStr);
		LocalTime end = LocalTime.parse(endTimeStr);
		
		//Differenz
		Duration dur = Duration.between(start, end);
		//in Sekunden
		long durSec = dur.getSeconds();
		
		//umwandeln und Formatieren 
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime lt = LocalTime.ofSecondOfDay(durSec);
		System.out.println(dateFormat.format(lt));//01:10:20
		
	}

}
