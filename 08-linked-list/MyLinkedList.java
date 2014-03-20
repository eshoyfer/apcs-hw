public class MyLinkedList {

	// Reminders:
	// Null is at the tail
	// New items are added at the head (the head is the newest item)

	private Node head;
	private int length;

	public MyLinkedList() {
		head = null;
		length = 0;
	}

	public void add(String d) {
		// from class 
		Node tmp = new Node(d);
		tmp.setNext(head); // you must do this first
		head=tmp; // you must do this second
		length++;
	}
	
	public String toString() {
		String ret = "";
		Node tmp = head; // First one
		ret += tmp.getData();
		tmp = tmp.getNext();
		while (tmp != null) {
			String thisData = tmp.getData();
			ret += ", " + thisData;
			tmp = tmp.getNext(); // Move along

		}
		return ret;
	}

	public void add(int i, String s) {
		// 0-based indexing
		// new element takes the new position by displacing item in that position forward 1 
		if (i < 0 || i > length) { // i can be equal to length if it's the last one
			throw new ArrayIndexOutOfBoundsException(i); // It's not an array but most appropriate exception 
		}
		Node toAdd = new Node(s);

		Node tmp = head; // Start at 0 
		for(int j = 0; j < i - 1; j++) { // Move to item of position i-1
			tmp = tmp.getNext();
		}
		// Tmp is now the item before the desired position
		toAdd.setNext(tmp.getNext());
		tmp.setNext(toAdd);
		length++;

	}

	public String get(int i) {
		// 0-based indexing
		if (i < 0 || i >= length) {
			throw new ArrayIndexOutOfBoundsException(i);
		}
		Node tmp = head;
		for(int j = 0; j < i; j++) { // move forward i times
			tmp = tmp.getNext();
		}    
		return tmp.getData();
	}

	public String set(int i, String s) {
		if (i < 0 || i >= length) {
			throw new ArrayIndexOutOfBoundsException(i);
		}

		Node toAdd = new Node(s);

		Node tmp = head; // Start at 0

		for(int j = 0; j < i - 1; j++) {
			tmp = tmp.getNext(); // Move to item of position i - 1
		}

		Node old = tmp.getNext();
		toAdd.setNext(tmp.getNext().getNext());
		tmp.setNext(toAdd); // The original item is taken out of the picture entirely

		return old.getData(); // Return the old value. 
	}

	public String remove(int i) {
		Node tmp = head; // Start at 0

		for(int j = 0; j < i - 1; j++) {
			tmp = tmp.getNext(); // Move to item to position i - 1
		}
		Node removed = tmp.getNext();
		tmp.setNext(tmp.getNext().getNext()); // Skip over the removed item
		length--; 
		return removed.getData(); // Return the data of what we removed 
	}

	public int find(String s) {
		Node tmp = head; // Start at 0
		int i = 0; 
		while (tmp != null) {
			if (tmp.getData().equals(s)) {
				return i; 
			}
			tmp = tmp.getNext();
			i++;
		}
		throw new ArrayIndexOutOfBoundsException(i);
	}

	public int length() {
		return length; 
	}
  


}