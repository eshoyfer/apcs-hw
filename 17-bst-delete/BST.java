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

	public void delete(int x) {
		// Throws NullPointerException when applied to:
		// 1. Empty tree
		// 2. Tree that does not contain the item whose deletion was requested

		Node curr = root; 
		Node prev = null; // Trailing / Piggybacking pointer 

		// Finding the node; essentially a search (like the non-recursive search function)
		while (curr != null && curr.getData() != x) {
			// Left-side case (including equals)
			if (x <= curr.getData()) {
				prev = curr;
				curr = curr.getLeft();
			} else {
			// Right-side case 
				prev = curr;
				curr = curr.getRight();
			}
		}

		// Existing search function was not used because access was needed to trailing pointer

		// At this point, curr is either null or represents the located node that will be deleted
		// Regardless, curr will be treated as an object and will throw a NullPointerException in the former case

		// Actual deletion

		// Zero, one child cases 
		if ((curr.getLeft() == null) || (curr.getRight() == null)) {
			Node child;

			if (curr.getLeft() != null) {
				child = curr.getLeft();
			} else {
				child = curr.getRight();
			}
			// Null case (zero child) case automatically handled

			if (prev.getLeft().equals(curr)) {
				// Curr was originally on the left of Prev
				// Prev's left child must be replaced 
				prev.setLeft(child);

			} else if (prev.getLeft().equals(curr)) {
				// Corresponding case for Curr being originally on the right of Prev
				// Prev's right child must be replaced
				prev.setRight(child);
			}
		}

		// Two child case
		if ((curr.getLeft() != null) && (curr.getRight() != null)) {

			Node largestLeftChild = curr.getLeft();

			while (largestLeftChild.getRight() != null) {
				largestLeftChild = largestLeftChild.getRight();
			}

			Node storeLargestLeftChild = new Node(largestLeftChild.getData()); // Preserve the data to prepare to replace delete-node 
			delete(largestLeftChild.getData()); // Delete the original copy of the replacement; base case will be zero/one child case 
			// If the original copy of the replacement itself has two children, numerous recursive calls will be made until a base case is found
			curr.setData(storeLargestLeftChild.getData()); // Replace the delete-node 
		}
	}
}