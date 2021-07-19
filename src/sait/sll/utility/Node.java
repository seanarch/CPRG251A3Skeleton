package sait.sll.utility;

public class Node {
	private Object element;
	private Node successor;
	
	public Node(Object element, Node successor) {
		super();
		this.element = element;
		this.successor = successor;
	}

	public Node(Object element) {
		super();
		this.element = element;
		this.successor = null;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public Node getNext() {
		return successor;
	}

	public void setNext(Node successor) {
		this.successor = successor;
	}
	
}
