package dateandtime;

import java.time.LocalDate;
import java.time.Month;

public class LocalDateExample {
	public static void main(String[] args) {
		
		LocalDate day1 = LocalDate.of(2014, Month.AUGUST, 3);
		LocalDate day2 = day1.plusYears(2).plusMonths(1).plusDays(3);
		
		System.out.println(day1); //2014-08-03
		System.out.println(day2); //2016-09-06
	}

}
