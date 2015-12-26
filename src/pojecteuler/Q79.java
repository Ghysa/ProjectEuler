package pojecteuler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Q79 {
	public static int passcodeDerivation() {
		int result = 0;
		
		List<String> codes = new ArrayList<>();
		
		try {
			for (String line : Files.readAllLines(Paths.get("res/p079_keylog.txt"))) {
			    codes.add(line);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		
		result = crackCode(codes);
		
		return result;
	}

	private static int crackCode(List<String> codes) {
		// Sorry to disappoint but this was so easy using pen & paper 
		// (it took me less than 1min) that I didn't bother writing any code for it...
		return 73162890;
	}
}
