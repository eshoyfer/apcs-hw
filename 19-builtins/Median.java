import java.util.*;

public class Median {
	private PriorityQueue<Integer> left; // Lower values 
	private PriorityQueue<Integer> right;  // Higher values

	public Median() {
		left = new PriorityQueue<Integer>();
		right = new PriorityQueue<Integer>(11, Collections.reverseOrder());
	}

	public void add(int x) {
		if (left.size() > right.size()) {
			right.add(new Integer(x));
		} else {
			left.add(new Integer(x));
		}
	}

	public double findMedian() {
		if (left.size() > right.size()) {
			return left.peak(); // Odd
		} else if (left.size() < right.size()) {
			return right.peak(); // Odd
		} else {
			return (left.peak() + right.peak()) / 2.0; // Even; Arithmetic mean
		}
	} 

	public double removeMedian() {
		if (left.size() > right.size()) {
			return left.poll();
		} else if (left.size() < right.size()) {
			return right.poll();
		} else if ((left.poll() == null) && (right.poll() == null)) { // Fully empty
			throw NullPointerException();
		} else {
			return (left.poll() + right.poll()) / 2; // Arithmetic mean
		}
	}
}