package Q31_40;

public class Q36 {
	public static int doubleBasePalindrome(int max) {
		int result = 0;

		for (int i = 0; i < max; i++) {
			if (isPalindromeBase10(i) && isPalindromeBase2(i)) {
				result += i;
				System.out.println(i);
			}				
		}
		
		return result;
	}
	
	public static boolean isPalindromeBase10(int number) {
		String num = Integer.toString(number);
		return isPalindromeString(num);
	}
	
	public static boolean isPalindromeBase2(int number) {
		String num = Integer.toBinaryString(number);
		return isPalindromeString(num);
	}

	public static boolean isPalindromeString(String string) {
		char[] chars = string.toCharArray();
		for (int i = 0; i < chars.length/2; i++) {
			if (chars[i] != chars[chars.length-i-1])
				return false;
		}
		return true;
	}
}
