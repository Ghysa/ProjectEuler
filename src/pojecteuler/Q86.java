package pojecteuler;

public class Q86 {
	public static int cuboidRoute() {
		int result = 0;
		int count = 0;
		int maxM = 2000;
		
		// To avoid doubles (since rotations aren't allowed, limit j <= i and k <= j
		for (int i = 1; i <= maxM; i++) {
			for (int j = 1; j <= i; j++) {
				for (int k = 1; k <= j; k++) {
					if (isShortestPathInteger(i,j,k)) {
						count++;
						if (count > 1000000) {
							return i;
						}
					}
				}
			}
		}
		
		return result;
	}

	public static boolean isShortestPathInteger(int i, int j, int k) {
		double shortestPath = calculateShortestPath(i, j, k);
		// Is our shortest path an integer?
		if (shortestPath == Math.floor(shortestPath)) {
			return true;
		}
		return false;
	}

	public static double calculateShortestPath(int i, int j, int k) {
		// If you fold the cube 'open' and place both points in the same plane,
		// you can see that the shortest path between both points is a simple
		// Pythagorean equation. Like said in the assignment, there's 3 possible
		// ways to place both points in the same plane and we need to find the
		// smallest solution.
		double path1 = Math.sqrt(((i+j)*(i+j))+(k*k));
		double path2 = Math.sqrt(((i+k)*(i+k))+(j*j));
		double path3 = Math.sqrt(((k+j)*(k+j))+(i*i));
		return Math.min(path1, Math.min(path2, path3));
	}
}
