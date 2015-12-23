package pojecteuler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.PriorityQueue;

public class Q82 {
	public static int pathSumThreeWay() {
		int result = 999999999;
		int size = 80; //given
		int[][] matrix = new int[size][size];
		
		try {
			int i = 0;
			for (String line : Files.readAllLines(Paths.get("res/p081_matrix.txt"))) {
				int j = 0;
			    for (String part : line.split(",")) {
			    	if (HelperFunctions.isNumeric(part)) {
				        matrix[i][j] = Integer.valueOf(part);
			    	}
			    	j++;
			    }
			    i++;
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		
		// Since you can start at any location on the left and end at any location on the right,
		// we need to calculate the minimum path sum of each possible combination.
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int tempResult = AStar(matrix, i, j, size);
				if (tempResult < result) {
					result = tempResult;
				}
			}
			System.out.println(i);
		}
		
		return result;
	}
	
	/**
	 * Special A* algorithm since you can't go left altough it doesn't have any influence on the result.
	 * It is a bit faster than the standard one though (yes you guessed it correctly, ~25% faster).
	 * See HelperFunctions for the standard one.
	 * 
	 * @author Sam Ghysels
	 */
	private static int AStar(int[][] cost, int startY, int endY, int size) {
		
		int[][] map = new int[size][size]; 	//possible values:     -1: not yet visited
											//                     -2: on the closed list
        									//                     >0: on the open list, value is the cost of that node.
		
		// Initialize empty (unvisited) map
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				map[y][x] = -1;
			}
		}
		
		int x = 0;
		int y = startY;
		
		// Create starting Node
		Node currentNode = new Node(cost[y][x], x, y, null);
		
		// Add it to a priority queue
		// We will use two priority queue's for reasons explained below.
		int qi = 0;
		PriorityQueue<Node> queue[] = new PriorityQueue[2];
		queue[0] = new PriorityQueue<>();
		queue[1] = new PriorityQueue<>();
		queue[qi].add(currentNode);
		
		// Set cost at starting point
		map[y][x] = currentNode.getCost();
		
		// Keep going until queue is empty (= no solution found)
		while(!queue[qi].isEmpty()) {
			
			// Get lowest cost Node and remove it from the queue
			currentNode = queue[qi].remove();
			x = currentNode.getxPos();
			y = currentNode.getyPos();
			
			// if destination is reached return total cost
			if (y == endY && x == size-1) {
				return currentNode.getTotalCost();
			}
			
			// Check all possible directions.
			// Here: Up, Down & Right (Left is for question 82)
			for (Direction dir : Direction.values()) {
				
				// get new coordinates based on the direction
				int xdx = 0, ydy = 0;
				switch (dir) {
					case RIGHT: 
						xdx = x + 1;
						ydy = y;
						break;
					case DOWN: 
						xdx = x;
						ydy = y + 1;
						break;
					case UP: 
						xdx = x;
						ydy = y - 1;
						break;
				}
				
				// check if we are still within the bounds of the matrix
				if (xdx < 0 || xdx >= size || ydy < 0 || ydy >= size) {
					continue;
				}
				// check if the new location is on the closed list
				if (map[ydy][xdx] == -2) {
					continue;
				}
				// Create new node for this location
				Node newNode = new Node(cost[ydy][xdx], xdx, ydy, currentNode);
				
				// If node is unvisited add it to the map
				if (map[ydy][xdx] == -1) {
					queue[qi].add(newNode);
					map[ydy][xdx] = newNode.getTotalCost();
				// If the total cost of the new node is smaller, replace it
				} else if (newNode.getTotalCost() < map[ydy][xdx]) {
					// Since replacing in a priority queue is impossible... 
					// We will copy all elements from one queue to the other one 
					// without the element that needs to be replaced. (is there really no better way?)
					
					// Copy until we find the element we (don't) need
					while (!queue[qi].peek().equals(newNode)) {
						queue[1-qi].add(queue[qi].remove());
					}
					// Remove element we don't need
					queue[qi].remove();
					// Cope the rest
					while(!queue[qi].isEmpty()) {
						queue[1-qi].add(queue[qi].remove());
					}
					// Add new Node
					queue[1-qi].add(newNode);
					map[ydy][xdx] = newNode.getTotalCost();
					// Switch queue
					qi = 1-qi;
				}
			}
		}
		
		// Failed if we get here since there should always be a solution...
		return -1;
	}
	
	private enum Direction {
		RIGHT,
		DOWN,
		UP
	}
}
