package sait.sll.utility;

public class SLL implements LinkedListADT {

	private Node head;
	private Node tail;
	private int size = 0;

	public SLL() {
		head = tail = null;
	}

	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	/**
	 * Clear the list 
	 */
	@Override
	public void clear() {
		tail = head = null;
		size = 0;
	}

	@Override
	public void append(Object data) {
		if (!isEmpty()) {
			tail.setNext(new Node(data));
			tail = tail.getNext();
		} else {
			head = tail = new Node(data);
		}
		size++;
	}

	/**
	 * Add an element to the beginning of the first
	 */
	@Override
	public void prepend(Object data) {
		if (!isEmpty()) {
			Node newNode = new Node(data); // creates a Node which has a data and successor points to null
			newNode.setNext(head); // newNode.next points to the place where header points to
			head = newNode; // moves the pointer of head to the place of newNode
		} else {
			head = tail = new Node(data);
		}
		size++;
	}

	/**
	 * Add a new element at the specified index
	 */
	@Override
	public void insert(Object data, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size + 1) {
			System.out.println(
					"Error. Cannot insert " + data + " at the index of " + index + ". The size of list is " + size());
		} else if (index == 0) {
			prepend(data);
		} else if (index == size + 1) { // In Revel, here is index >= size !?
			append(data);
		} else { // 0 < index < size+1
			Node current = head; // iterator
			Node newNode = new Node(data);
			for (int i = 0; i < index - 1; i++) { // moves to the position (index-1)
				current = current.getNext();
			}
			Node temp = current.getNext(); // stores the position of the (index+1)
			current.setNext(newNode); // the next of current should point to newNode
			newNode.setNext(temp); // the next of the newNode would be pointing to (index+1)
			size++;
		}
	}

	/**
	 * Replace the element at the specified position
	 */

	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		if (index >= 0 && index <= size - 1 && !isEmpty()) {
			Node current = head;
			for (int i = 0; i < index; i++) {
				current = current.getNext(); // moves to the position before index
			}
			current.setElement(data); // moves to the position index and replace data
		}
	}

	/**
	 * Return the number of elements in this list
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Remove the element at the specified position in this list
	 */
	@Override
	public void delete(int index) throws IndexOutOfBoundsException {
		if (index >= 0 && index <= size - 1 && !isEmpty()) {
			if (size == 1) {
				head = tail = null;
			} else {
				Node pre = head;
				for (int i = 0; i < index - 1; i++) { // moves to index-1
					pre = pre.getNext();
				}
				Node current = pre.getNext();
				pre.setNext(current.getNext());
			}
			size--;
		}
	}

	/**
	 * Return the element at the specified index
	 */
	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException {
		if (!isEmpty() && index < size) {
			Node temp = head;
			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}
			return temp.getElement();
		}
		return null;
	}

	/**
	 * Return the index of the first matching element in list. Return -1 if no
	 * match.
	 */
	@Override
	public int indexOf(Object data) {
		if (!isEmpty()) {
			Node temp = head;
			for (int i = 0; i < size; i++) {
				if (temp.getElement() == data) {
					return i;
				}
				temp = temp.getNext();
			}
		}
		return -1;
	}

	/**
	 * Return true if this list contains the element data
	 */
	@Override
	public boolean contains(Object data) {
		if (!isEmpty()) {
			for (Node temp = head; temp != null; temp = temp.getNext()) {
				if (temp.getElement().toString() == data) {
					return true;
				}
			}
		}
		return false;
	}

	public void print() {
		for (Node temp = head; temp != null; temp = temp.getNext()) {
			System.out.println(temp.getElement().toString());
		}
		System.out.println("size: " + size());
	}

}
