package Q21_30;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q22 {
	public static long namesScores() {
		long result = 0;
		
		List<String> names = new ArrayList<>();
		try {
			for (String line : Files.readAllLines(Paths.get("res/p022_names.txt"))) {
				for (String part : line.split(",")) {
					String name = part.replace("\"", "");
					names.add(name);
			    }			    
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		
		
		Collections.sort(names, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            return s1.compareToIgnoreCase(s2);
	        }
	    });
		
		for (String name : names) {
			int sum = 0;
			int index = names.indexOf(name) + 1;
			int compensation = 64;
			char[] ch  = name.toCharArray();
		    for(char c : ch) {
		        int temp = (int)c;
		        sum += temp-compensation;
		    }
		    result += sum * index;
		}
		
		return result;
	}
}
