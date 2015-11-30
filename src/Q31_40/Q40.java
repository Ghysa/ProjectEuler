package Q31_40;

public class Q40 {
	public static int champernownesConstant() {
		int result = 0;
		StringBuilder champ = new StringBuilder("");
		
		for (int i = 1; i < 185999; i++) {
			champ.append(i);
		}
		System.out.println(champ.length());
		char[] ca = champ.toString().toCharArray();
		
		System.out.println(ca[100]);
		
		result = Character.getNumericValue(ca[10-1]) * Character.getNumericValue(ca[100-1]) * Character.getNumericValue(ca[1000-1]) * Character.getNumericValue(ca[10000-1]) * Character.getNumericValue(ca[100000-1]) * Character.getNumericValue(ca[1000000-1]);
		
		return result;
	}
}
