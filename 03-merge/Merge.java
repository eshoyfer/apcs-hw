import java.util.*;

public class Merge {
	// Given two sorted arrays a and b, merge them into one sorted array.

	public static int[] merge(int[] a, int[] b) {
		int newSize = a.length + b.length;
		int[] result = new int[newSize];

		int positionA = 0; 
		int positionB = 0;
		int positionResult = 0;  

		int thisA = 0;
		int thisB = 0;

		while (((positionA < a.length) || (positionB < b.length)) && (positionResult < newSize)) {

			if (positionA < a.length) {
				thisA = a[positionA];
			}
			if (positionB < b.length) {
				thisB = b[positionB];
			}

			if (positionA == a.length) {
				result[positionResult] = thisB;
				positionB++;
				positionResult++;
			}

			else if (positionB == b.length) {
				result[positionResult] = thisA;
				positionA++;
				positionResult++;
			}

			else if (thisA < thisB) {
				result[positionResult] = thisA;
				positionA++;
				positionResult++;
				System.out.println(thisA);


			}

			else if (thisB <= thisA) {
				result[positionResult] = thisB;
				positionB++;
				positionResult++;
				System.out.println(thisB);

			}

		}
		return result;
	}

	public static int[] msort(int[] L) {

	if (L.length <= 1) {
		// Base case 

		return L;

	} else {
		// Splitting process 

		int aLength = (L.length / 2);
		int bLength = L.length - aLength;
		int[] a = new int[aLength];
		int[] b = new int[bLength];

		for(int i = 0; i < L.length; i++) {
			if (i < aLength) {
					
				a[i] = L[i];

			} else {

				b[i - aLength] = L[i];
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

		int[] a1 = {3, 4, 5};
		int[] b1 = {1, 2, 7};
		int[] a2 = {1, 5};
		int[] b2 ={2, 4, 6};
		int[] a3 = {1, 5, 9};
		int[] b3 = {2, 7};

		System.out.println("Test 1: Equal sizes."); 
		System.out.println(Arrays.toString(merge(a1, b1)));

		System.out.println("Test 2: A length < B length.");
		System.out.println(Arrays.toString(merge(a2, b2)));

		System.out.println("Test 3: A length > B length.");
		System.out.println(Arrays.toString(merge(a3, b3)));		

		Random r = new Random();

		System.out.println("Mergesort Test 1"); 

		int[] d = {1, 2, 7, 1, 3, 2, 5, 9, 1, 2};
		System.out.println(Arrays.toString(msort(d)));

		int[] test2 = new int[100];
		for (int i = 0; i < test2.length; i++) {
			test2[i] = r.nextInt();
		}

		System.out.println("Mergesort Test 2");
		System.out.println("Sorting: " + Arrays.toString(test2));
		System.out.println(Arrays.toString(msort(test2)));
	}
}