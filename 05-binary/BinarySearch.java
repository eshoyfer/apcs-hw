public class BinarySearch {

	public static int rbsearchInitializer(int n, int[] L) {
		// The solution is done with tail call recursion, and requires inclusive min/max index as a parameter
		// This initializes the tail call recursive function 

		int max = L.length - 1; 

		return rbsearch(n, L, 0, max);

	}

	public static int rbsearch(int n, int[] L, int min, int max) {

		// Min, max are inclusive.

		// Base cases

		if (max < min) {
			return -1;
		}

		else if (max == min) {
			if (L[max] == n) {
				return max;
			} else {
				return -1; 
			}
		}

		else 
		{
			int midIndex = (min + max) / 2; // average of the indices
			int midItem = L[midIndex]; 

			if (midItem == n) {
				return midIndex;
			} 

			else if (midItem < n) {
				// We need to check the upper half. 
				return rbsearch(n, L, midIndex + 1, max - 1);
			}

			else if (midItem > n) {
				// We need to check the lower half. 
				return rbsearch(n, L, min, midIndex - 1); 
			}

		}
		return -1; 
	}

	public static int ibsearch(int n, int[] L) {
		// Pretty similar to the recursive solution.
		// Instead of passing the min and max via tail call recursion, 
		// we just store them as variables on the greatest scope of the function.

		int min = 0; 
		int max = L.length - 1; 

		while (max >= min) {
			int midIndex = max + min / 2; 
			int midItem = L[midIndex];

			if (midItem == n) { // The "found!" case. This accounts for the (min == max) case too. 
				return midIndex;
			}

			else if (midItem < n) {
				// We need to check the upper half.
				// Perform the next iteration with modified bounds. 

				min = midIndex + 1; 
				// max same
			}

			else { // midItem > n 
				// We need to check the lower half. 
				// Perform the next iteration with modified bounds. 

				max = midIndex - 1; 
				// min same
			}

		}
		return -1; // If the boundries have completely narrowed, the search failed. Return -1. 
	}

	public static void main(String[] args) {
		BinarySearch b = new BinarySearch();
		int[] testArray = {1, 1, 3, 4, 5, 7, 8, 10, 12, 15};

		System.out.println(b.rbsearchInitializer(5, testArray) + "");
		System.out.println(b.ibsearch(5, testArray) + "");
	}

}