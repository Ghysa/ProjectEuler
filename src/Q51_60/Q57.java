package Q51_60;

public class Q57 {
	public static int squareRootConvergents(int maxExpansions) {
		int result = 0;
		
		for (int i = 0; i < maxExpansions; i++) {
			double expansion = 1 + 1/2.5;
			if(expansion==1)
				return 0;
		}
		
		return result;
	}
}
