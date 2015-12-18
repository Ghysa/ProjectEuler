package Q51_60;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Q54 {
	public static int pokerHands() {
		int result = 0;
		
		// Read words from file
		List<String> lines = new ArrayList<>();
		try {
			for (String line : Files.readAllLines(Paths.get("res/p054_poker.txt"))) {
				lines.add(line);		    
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		
		for (String line : lines) {
			int count = 0;
			List<Card> player1cards = new ArrayList<>();
			List<Card> player2cards = new ArrayList<>();
			for (String card : line.split(" ")) {
				if (count < 5) {
					player1cards.add(new Card(card));
				} else {
					player2cards.add(new Card(card));
				}
				count++;
			}
			Hand player1 = new Hand(player1cards);
			Hand player2 = new Hand(player2cards);
			int comp = player1.compareTo(player2);
			if (comp > 0) {
				result++;
			}
		}
		return result;
	}
}
