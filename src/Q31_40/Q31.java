package Q31_40;

public class Q31 {
	enum Coins {
		ONE(1),
		TWO(2),
		FIVE(5),
		TEN(10),
		TWENTY(20),
		FIFTY(50),
		HUNDERD(100),
		TWOHUNDERD(200);
		
		Coins(int pennies) { // constructor
			this.pennies = pennies;
		}
		
		private int pennies; // an instance variable
		
		public int getPennies() {
			return this.pennies;
		}
	}
	
	public static int coinSums() {
		int target  = 200;
		int ways = 0;
		 
		for (int a = target; a >= 0; a -= 200) {
		    for (int b = a; b >= 0; b -= 100) {
		        for (int c = b; c >= 0; c -= 50) {
		            for (int d = c; d >= 0; d -= 20) {
		                for (int e = d; e >= 0; e -= 10) {
		                    for (int f = e; f >= 0; f -= 5) {
		                        for (int g = f; g >= 0; g -= 2) {
		                            ways++;
		                        }
		                    }
		                }
		            }
		        }
		    }
		}
		
		return ways;
	}
}
