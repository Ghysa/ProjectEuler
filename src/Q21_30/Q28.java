package Q21_30;

public class Q28 {
	public static int numberSpiralDiagonals(int dim) {
		int result = 0;
		int[][] matrix = new int[dim][dim];
		
		int number = 1;
		int i = (dim/2);
		int j = (dim/2);;
		Move move = Move.RIGHT;
		int moveAmount = 0;
		matrix[i][j] = number;
		number++;
		
		while (number <= dim*dim) {
			switch (move) {
				case RIGHT: {
					if (moveAmount < dim-1) {
						moveAmount++;
					}
					for (int n = 0; n < moveAmount; n++) {
						i++;
						matrix[i][j] = number;
						number++;
					}
					move = Move.DOWN;
					break;
				}
				case DOWN: {
					for (int n = 0; n < moveAmount; n++) {
						j++;
						matrix[i][j] = number;
						number++;
					}
					move = Move.LEFT;
					break;				
				}
				case LEFT: {
					moveAmount++;
					for (int n = 0; n < moveAmount; n++) {
						i--;
						matrix[i][j] = number;
						number++;
					}
					move = Move.UP;
					break;	
				}
				case UP: {
					for (int n = 0; n < moveAmount; n++) {
						j--;
						matrix[i][j] = number;
						number++;
					}
					move = Move.RIGHT;
					break;
				}
			}
		}
		
		for (int x = 0; x < dim; x++) {
			for (int y = 0; y < dim; y++) {
				if(x == y)
					result += matrix[x][y];
				else if ((x+y) == dim-1)
					result += matrix[x][y];
			}
		}
		
		return result;
	}
	
	public enum Move {
		RIGHT,
		DOWN,
		LEFT,
		UP
	}
}
