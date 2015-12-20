package pojecteuler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Q99 {
	public static int largestExponential() {
		Double comp = 0.0;
		List<Double> numbers = new ArrayList<>();
		try {
			for (String line : Files.readAllLines(Paths.get("res/p099_base_exp.txt"))) {
				String[] pair = line.split(",");
				double base = Double.parseDouble(pair[0]);
				double exp = Double.parseDouble(pair[1]);
				double pow = exp * Math.log(base);
				numbers.add(pow);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		
		for (Double d : numbers) {
			if (d.compareTo(comp) > 0) {
				comp = d;
			}
		}
		
		return numbers.indexOf(comp);
	}
}
