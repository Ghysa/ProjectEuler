package Q51_60;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import pojecteuler.HelperFunctions;

public class Q59 {
	public static int XORDecryption() {
		int result = 0;
		List<Character> characters = new ArrayList<>();
		
		try {
			for (String line : Files.readAllLines(Paths.get("res/p059_cipher.txt"))) {
			    for (String part : line.split(",")) {
			    	if (HelperFunctions.isNumeric(part)) {
				        char c = (char) Integer.parseInt(part);
				        characters.add(c);
			    	}
			    }
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		
		// found by inspecting the code.txt file (see function below to create file)
		String pw = "god";
		
		for (int i = 0; i < characters.size(); i++) {
			char c = characters.get(i);
			char n;
			if(i % 3 == 0) {
				n = (char) (c ^ pw.charAt(0));
			} else if (i % 3 == 1) {
				n = (char) (c ^ pw.charAt(1));
			} else {
				n = (char) (c ^ pw.charAt(2));
			}
			result += n;
			
			System.out.print(""+n);
		}
		
		System.out.println();
		
		return result;
	}
	
	public static void writeCodesToFile(List<Character> characters) {
		char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		
		try {
			PrintWriter writer = new PrintWriter("code.txt", "UTF-8");
			for (char c1 : alphabet) {
				for (char c2 : alphabet) {
					for (char c3 : alphabet) {
						for (int i = 0; i < characters.size()/3; i++) {
							char d1 = characters.get(i*3);
							char d2 = characters.get(i*3 + 1);
							char d3 = characters.get(i*3 + 2);
							
							char n1 = (char) (d1 ^ c1);
							char n2 = (char) (d2 ^ c2);
							char n3 = (char) (d3 ^ c3);
							
							writer.print(""+n1+n2+n3);
						}
						writer.println(" ---|--- pw = " + c1+c2+c3);
					}
				}
			}
			writer.close();
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
