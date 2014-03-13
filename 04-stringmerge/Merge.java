import java.util.*;

public class Merge {
	// Code now works; it was correct before, but I made a hilariously bad mistake (and spent way too long finding it)
	// The mistake was simply this: in my main method, I printed the original array instead of the sorted one. *facepalm*
	// I was wondering why none of my changes did anything...
	
	// Given two sorted arrays a and b, merge them into one sorted array.

	public static ArrayList<String> merge(ArrayList<String> a, ArrayList<String> b) {
		int newSize = a.size() + b.size();
		ArrayList<String> result = new ArrayList<String>();

		int positionA = 0; 
		int positionB = 0;
		int positionResult = 0;  

		String thisA = "";
		String thisB = "";

		for (int i = 0; i < newSize; i++) {
			result.add("");
		}

		while (((positionA < a.size()) || (positionB < b.size())) && (positionResult < newSize)) {

			if (positionA < a.size()) {
				thisA = a.get(positionA);
			}
			if (positionB < b.size()) {
				thisB = b.get(positionB);
			}

			if (positionA == a.size()) {
				result.set(positionResult, thisB);
				positionB++;
				positionResult++;
			}

			else if (positionB == b.size()) {
				result.set(positionResult, thisA);
				positionA++;
				positionResult++;
			}

			else if (thisA.compareTo(thisB) <= 0) {
				result.set(positionResult, thisA);
				positionA++;
				positionResult++;
				System.out.println(thisA);


			}

			else if (thisA.compareTo(thisB) > 0) {
				result.set(positionResult, thisB);
				positionB++;
				positionResult++;
				System.out.println(thisB);

			}

		}
		return result;
	}

	public static ArrayList<String> msort(ArrayList<String> L) {

	if (L.size() <= 1) {
		// Base case 

		return L;

	} else {
		// Splitting process 

		int aLength = (L.size() / 2);
		int bLength = L.size() - aLength;
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<String> b = new ArrayList<String>();

		for (int i = 0; i < aLength; i++) {
			a.add("");
		}

		for (int i = 0; i < bLength; i++) {
			b.add("");
		}

		for(int i = 0; i < L.size(); i++) {
			if (i < aLength) {
					
				a.set(i, L.get(i)); //a[i] = L[i];

			} else {

				b.set((i - aLength), L.get(i)); // b[i - aLength] = L[i];
			}
		}

		// Recursion 

		a = msort(a);
		b = msort(b);
			
		L = merge(a, b);

		return L;

		} 
	}

	
	public static void main(String[] args) {

		ArrayList<String> t1 = new ArrayList<String>(); 
		t1.add("z");
		t1.add("e");
		t1.add("a");
		t1.add("b");
		t1.add("a");
		t1.add("f");

		ArrayList<String> a1 = msort(t1);
		String array = "{";
		for (int i = 0; i < 6; i++) {
			array = array + a1.get(i) + ", "; 
		}
		array += "}";
		System.out.println(array);
	}
}