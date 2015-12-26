package pojecteuler;

public class Q85 {
	public static int countingRectangles(int closestCount) {
		int tempCount = 99999999;
		int result = 0;
		
		// See: http://www.gottfriedville.net/mathprob/comb-subrect.html
		for (int x = 1; x < 2000; x++) {
			for (int y = 1; y < 2000; y++) {
				int count = (x)*(x+1)*(y)*(y+1)/4;
				if (Math.abs(count - closestCount) < tempCount)  {
					tempCount = Math.abs(closestCount - count);
					result = x*y;
				}
			}
		}
		
		return result;
	}

	// Works but slow, better formula is (x)*(x+1)*(n)*(n+1)/4
	public static int calculateRectangles(int sizeX, int sizeY) {
		int count = 0;
		
		for (int x = 1; x <= sizeX; x++) {
			for (int y = 1; y <= sizeY; y++) {
				count += ((sizeY - y + 1)*(sizeX - x + 1));
			}
		}
		
		return count;
	}
}
