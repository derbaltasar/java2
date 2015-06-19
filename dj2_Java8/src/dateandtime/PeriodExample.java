package dateandtime;

import java.time.LocalDateTime;
import java.time.Period;

public class PeriodExample {
	public static void main(String[] args) {
		final LocalDateTime startTime = LocalDateTime.of(2014,11,5,19,30);
		System.out.println(startTime);//2014-11-05T19:30
		System.out.println(startTime.getMonth()); //NOVEMBER
		
		final Period twoMonths = Period.ofMonths(2);
		System.out.println(startTime.plus(twoMonths));//2015-01-05T19:30
		
	}
}
