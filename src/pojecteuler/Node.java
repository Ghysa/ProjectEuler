package pojecteuler;

public class Node {
	private int cost;
	private int totalCost;
	private int xPos;
	private int yPos;
	private Node prevNode;
	
	public Node(int cost, int xPos, int yPos, Node prevNode) {
		this.cost = cost;
		this.xPos = xPos;
		this.yPos = yPos;
		this.prevNode = prevNode;
		this.totalCost = calculateTotalCost();
	}
	
	private int calculateTotalCost() {
		Node tempNode = this.prevNode;
		int totCost = 0;
		while (tempNode != null) {
			totCost += tempNode.getCost();
			tempNode = tempNode.getPrevNode();
		}
		return totCost;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public Node getPrevNode() {
		return prevNode;
	}

	public void setPrevNode(Node prevNode) {
		this.prevNode = prevNode;
	}
}
