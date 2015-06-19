package functional.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
class User{
	private String name;
	private int alter;
	
	public User(String name, int alter) {
		super();
		this.name = name;
		this.alter = alter;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAlter() {
		return alter;
	}
	public void setAlter(int alter) {
		this.alter = alter;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", alter=" + alter + "]";
	}
	
	
}
/*
 * Streams:folgen von Verarbeitungsschritten auf Daten
 * 
 * Filter: Filterung gewünschter Elemente aus einer Menge von Elementen.
 *  Die Element-Typen bleiben dieselben, aber die Menge der Elemente wird 
 *  reduziert. Beispiel: Stream.filter( Predicate ).
 * Map: Transformation der Elemente. Dabei ändert sich die Menge der Elemente 
 * nicht, aber oft ändert sich der Element-Typ. Beispielsweise können Berechnungen, 
 * Extraktionen oder Umwandlungen durchgeführt werden. Beispiel: Stream.map( Function ).
 */
public class StreamExample {
	public static void main(String[] args) {
		String[] strNames = {"Max","Anton","Ilse","Maria","Ina","Maria"};
		final List<String> names= Arrays.asList(strNames);
		
		//-------------- Arrays und listen nach Streams konvertieren
		Stream<String> streamFromArray = Arrays.stream(strNames);
		Stream<String> streamFromList = names.stream();
		
		//---------------- destingt------------------
		Stream<String> stream = streamFromList.distinct();//keine mehrfach-Einträge
		//Stream to List wandeln
		System.out.println(stream.collect(Collectors.toList()));
		
		//------------------filter ---------------------------
		
		List<User> users = Arrays.asList(new User("Max",12),new User("Inge", 23), new User("Anton",34),new User("Ulli",17));
		//-----------------Stream erzeugen . filter (PRADICATE) . FROM STREAM TO LSIT
		List<User> oldUsers  = users.stream() // Liste zu Stream
				.filter(u->u.getAlter()>18)
				.collect(Collectors.toList()); // wieder zurück zur liste
		System.out.println(oldUsers);
		
		//------------------map----------------------------------
		List<String> usernames = users.stream() // List to Stream
				.filter(u->u.getAlter()< 18)	// Stream<User>
				.map(u -> u.getName())  // ab hier Stream(Liste) mit Strings 
				.collect(Collectors.toList());
		
		System.out.println(usernames);
		
		//-------------------map------------------------------------
		Stream.of("a1", "a2", "a3") //Stream aus Array
	    .map(s -> s.substring(1)) //a weg
	    .mapToInt(Integer::parseInt)// nach Integer
	    .max() //max
	    .ifPresent(System.out::println);  // 3
		
		//------------------range------------------------------
		
		IntStream.range(2, 6).forEach(System.out::println);
				
		
		//----------------reduce---------------------------------
		List<User> users2 = Arrays.asList(new User("Max",12),new User("Inge", 23), new User("Anton",34),new User("Ulli",17),new User("Ulli",11));

		User reduceUser = users2.stream()
				.reduce((u1,u2)-> u1.getAlter()<u2.getAlter()? u1:u2) // alle Elemente des Streams vergleichen
				.get();// User zurückgeben
		
		System.out.println(reduceUser);
		
		
	}
}
