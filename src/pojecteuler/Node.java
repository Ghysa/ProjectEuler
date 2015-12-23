package pojecteuler;

public class Node implements Comparable<Node> {
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
		int totCost = this.cost;
		while (tempNode != null) {
			totCost += tempNode.getCost();
			tempNode = tempNode.getPrevNode();
		}
		return totCost;
	}
	
	public int compareTo(Node node) {
		int nodeTotalCost = node.getTotalCost();
		if (this.totalCost > nodeTotalCost) {
			return 1;
		} else if (this.totalCost < nodeTotalCost) {
			return -1;
		} else {
			return 0;
		}
	}
	
	public boolean equals(Node node) {
		if (this.cost == node.getCost()) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "x: " + this.xPos + " | y: " + this.yPos + " | cost: " + this.cost + " | totalCost: " + this.totalCost;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
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
