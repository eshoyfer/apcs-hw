import java.util.*;

public class Merge {

	// Given two sorted arrays a and b, merge them into one sorted array.

	public static ArrayList<Comparable> merge(ArrayList<Comparable> a, ArrayList<Comparable> b) {
		int newSize = a.size() + b.size();
		ArrayList<Comparable> result = new ArrayList<Comparable>();

		int positionA = 0; 
		int positionB = 0;
		int positionResult = 0;  

		Comparable<Object> thisA = a.get(0); // Initialized with values that are known to be comparable.
		Comparable<Object> thisB = b.get(0);

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

	public static ArrayList<Comparable> msort(ArrayList<Comparable> L) {

	if (L.size() <= 1) {
		// Base case 

		return L;

	} else {
		// Splitting process 

		int aLength = (L.size() / 2);
		int bLength = L.size() - aLength;
		ArrayList<Comparable> a = new ArrayList<Comparable>();
		ArrayList<Comparable> b = new ArrayList<Comparable>();

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

		ArrayList<Comparable> t1 = new ArrayList<Comparable>(); 
		t1.add("z");
		t1.add("e");
		t1.add("a");
		t1.add("b");
		t1.add("a");
		t1.add("f");

		ArrayList<Comparable> a1 = msort(t1);
		String array = "{";
		for (int i = 0; i < 6; i++) {
			array = array + a1.get(i) + ", "; 
		}
		array += "}";
		System.out.println(array);

		ArrayList<Comparable> t2 = new ArrayList<Comparable>(); 
		t2.add(new Integer(1));
		t2.add(new Integer(5));
		t2.add(new Integer(2));
		t2.add(new Integer(10));
		t2.add(new Integer(8));
		t2.add(new Integer(4));

		ArrayList<Comparable> a2 = msort(t2);
		array = "{";
		for (int i = 0; i < 6; i++) {
			array = array + a2.get(i) + ", "; 
		}
		array += "}";
		System.out.println(array);

		ArrayList<Comparable> t3 = new ArrayList<Comparable>(); 
		t3.add(new Person(50, "adam"));
		t3.add(new Person(51, "eve"));
		t3.add(new Person(55, "boss"));
		t3.add(new Person(40, "dog"));
		t3.add(new Person(30, "anthony fantano"));
		t3.add(new Person(71, "ryan dombal"));

		ArrayList<Comparable> a3 = msort(t3);
		array = "{";
		for (int i = 0; i < 6; i++) {
			array = array + a3.get(i) + ", "; 
		}
		array += "}";
		System.out.println(array);
	}
}