public class BST {

	public class Node {
	    private int data;
	    private Node left, right;

	    public Node(int d) {
	    	data = d; 
	    	left = null;
	    	right = null;
	    }

	    public void setLeft(Node l) {
	    	left = l;
	    }

	    public Node getLeft() {
	    	return left;
	    }

	    public void setRight(Node r) {
	    	right = r;
	    }

	    public Node getRight() {
	    	return right; 
	    }

	    public void setData(int d) {
	    	data = d;
	    }

	    public int getData() {
	    	return data;
	    }

	}
    
    private Node root;

    public BST() {
        root = null;
    }

	public void insert (int d) {
		if (root == null) {
			// Empty tree
			root = new Node(d); 
			return;
		}

		Node curr = root; 
		Node prev = null; // Trailing / Piggybacking pointer 

		while (curr != null) {
			if (d <= curr.getData()) {
				// Left-side (lower) case 
				// Arbitrarily putting equal values on left
				prev = curr; 
				curr = curr.getLeft();
			} else {
				// Right-side (upper) case
				prev = curr; 
				curr = curr.getRight();
			}

			if (d <= prev.getData()) {
				// Putting equal values on left is consistent with the above search
				prev.setLeft(new Node(d));
			} else {
				prev.setRight(new Node(d));
			}
		}
	}

    public Node search (int x) {
    	// Regular search
		Node tmp = root;
		while (tmp != null && tmp.getData() != x) {
			if (x < tmp.getData()) {
			tmp = tmp.getLeft();
			} else {
				tmp = tmp.getRight();
			}
		}
		return tmp;
	}

	public Node search2(int x) {
		// Overloaded recursive search 
		// Initalizes with root

		return search2(root, x);
	}

	public Node search2 (Node c, int x) {
		// Recursive search
		// Initialize with root
		// Returns null on failure

		// Base case 1: Search failed
		if (c == null) {
			return null; 
		}

		// Base case 2: Search successful
		else if (c.getData() == x) {
			return c; 
		} 

		// Recursive Reductions: 

		// Left-side case (includes equal case)
		else if (x <= c.getData()) {
			return search2(c.getLeft(), x);
		}

		// Right-side case
		else {
			return search2(c.getRight(), x);
		}

	}
}