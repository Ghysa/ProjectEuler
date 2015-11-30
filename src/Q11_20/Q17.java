package Q11_20;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
	public static int numberLetterCount() {
		int result = 0;
		List<String> numberList = new ArrayList<>();
		
		// 1-20
		numberList.add("one");
		numberList.add("two");
		numberList.add("three");
		numberList.add("four");
		numberList.add("five");
		numberList.add("six");
		numberList.add("seven");
		numberList.add("eight");
		numberList.add("nine");
		numberList.add("ten");
		numberList.add("eleven");
		numberList.add("twelve");
		numberList.add("thirteen");
		numberList.add("fourteen");
		numberList.add("fifteen");
		numberList.add("sixteen");
		numberList.add("seventeen");
		numberList.add("eighteen");
		numberList.add("nineteen");
		
		// 20-29
		for (int i = 0; i < 10; i++) {
			numberList.add("twenty"+numberList.get(i));
		}
		
		// 30-39
		for (int i = 0; i < 10; i++) {
			numberList.add("thirty"+numberList.get(i));
		}
		
		// 40-49
		for (int i = 0; i < 10; i++) {
			numberList.add("forty"+numberList.get(i));
		}
		
		// 50-59
		for (int i = 0; i < 10; i++) {
			numberList.add("fifty"+numberList.get(i));
		}
		// 60-69
		for (int i = 0; i < 10; i++) {
			numberList.add("sixty"+numberList.get(i));
		}
		// 70-79
		for (int i = 0; i < 10; i++) {
			numberList.add("seventy"+numberList.get(i));
		}
		// 80-89
		for (int i = 0; i < 10; i++) {
			numberList.add("eighty"+numberList.get(i));
		}
		// 90-99
		for (int i = 0; i < 10; i++) {
			numberList.add("ninety"+numberList.get(i));
		}
		
		// count lengths
		for (int i = 0; i < 99; i++) {
			result += numberList.get(i).length();
		}
		
		return result;
	}
}
