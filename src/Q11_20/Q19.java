package Q11_20;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class Q19 {
	public static int countingSundays(int startYear, int endYear) {
		int result = 0;
		
		LocalDate start = LocalDate.of(startYear, Month.JANUARY, 1);
		while (start.getDayOfWeek() != DayOfWeek.SUNDAY)
			start = start.plusDays(1);
		LocalDate end = LocalDate.of(endYear, Month.DECEMBER, 31);
		
		while(start.isBefore(end)) {
			start = start.plusWeeks(1);
			if (start.getDayOfMonth() == 1) {
				result++;
				System.out.println(result);
			}
		}
		
		return result;
	}
}
