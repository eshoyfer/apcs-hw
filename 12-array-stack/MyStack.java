public class MyStack {
	private String[] l; // The backend array 
	private int top; /* Index of the highest item in the stack; if this is 0,				   * then the stack is empty */
	private int capacity;

	public MyStack(){
		l = new String[10]; 
		top = 0; // indicates empty array; popping gives null
		capacity = 10; 
	}

	private void increaseCapacity() {
		// Increases capacity by 10. 

		capacity = capacity + 10; 
		String[] newArray = new String[capacity];

		for (int i = 0; i < l.length; i++) {
			newArray[i] = l[i];  
		}

		l = newArray; 
	}

	public void push(String s){
		try {
			l[top + 1] = s; 
		} catch (ArrayIndexOutOfBoundsException e) {
			increaseCapacity(); 
			l[top + 1] = s; 
		}
		top = top + 1;
	}

	public String pop() {
		String popped = l[top];
		l[top] = null;
		top = top - 1;
		if (top < 0) { // Handle the "popping an empty stack" case 
			top = 0;
		} 
		return popped;
	}

	public String peek() {
		String peeked = l[top];
		return peeked; 
	}

	public int size() {
		return top; 
	}

	public boolean isEmpty() {
		return (top != 0); 
	}
	public String toString() {
		String result = new String("{"); 
		for (int i = 1; i <= top; i++) {
			result += l[i];
			if (i != top) {
				result += ", ";
			}
		}
		result += "}";
		return result;
	}

}