package Q41_50;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Q42 {
	public static int codedTriangleWords() {
		int result = 0;
		
		// Read words from file
		List<String> words = new ArrayList<>();
		try {
			for (String line : Files.readAllLines(Paths.get("res/p042_words.txt"))) {
				for (String part : line.split(",")) {
					String name = part.replace("\"", "");
					words.add(name);
			    }			    
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		
		// Calculate score for each word
		List<Integer> wordScores = new ArrayList<>();		
		for (String word : words) {
			wordScores.add(stringScore(word));
		}
		
		// Generate triangle sequence
		List<Integer> triangles = new ArrayList<>();
		triangles.add(1);
		for (int i = 2; i < 99; i++) {
			triangles.add(triangles.get(triangles.size()-1) + i);
		}
		
		// Check if wordscore is a triangle number
		for (Integer score : wordScores) {
			if (triangles.contains(score))
				result++;
		}
		
		return result;
	}
	
	public static int stringScore(String word) {
		int sum = 0;
		int compensation = 64;
		char[] ch  = word.toCharArray();
	    for(char c : ch) {
	        int temp = (int)c;
	        sum += temp-compensation;
	    }
	    return sum;
	}
}
