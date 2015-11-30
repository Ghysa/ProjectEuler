package Q21_30;

public class Q26 {
	public static int reciprocalCycles(int maxDivisor) {
		int sequenceLength = 0;
		int result = 0;
		 
		for (int i = 1000; i > 1; i--) {
		    if (sequenceLength >= i) {
		        break;
		    }
		 
		    int[] foundRemainders = new int[i];
		    int value = 1;
		    int position = 0;
		 
		    while (foundRemainders[value] == 0 && value != 0) {
		        foundRemainders[value] = position;
		        value *= 10;
		        value %= i;
		        position++;
		    }
		 
		    if (position - foundRemainders[value] > sequenceLength) {
		        sequenceLength = position - foundRemainders[value];
		        result = position;
		    }
		}
		
		return result;
	}
}
