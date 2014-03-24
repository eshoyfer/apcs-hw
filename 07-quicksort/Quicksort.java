import java.io.*;
import java.util.*;

public class Quicksort {
		public static int[] qsort(int[] L) {
			Random r = new Random();

			if (L.length <= 1) {
				return L;
			}

			else {
				int pivotIndex = r.nextInt(L.length); // Select Pivot 
				ArrayList<Integer> cheesyArrayList = new ArrayList<Integer>(); // cheesy way 
				for (int i = 0; i < L.length; i++) {
					if (L[i] < L[pivotIndex]) {
						cheesyArrayList.add(L[i]);
					}
				}

				int lowNumsCount = cheesyArrayList.size();

				cheesyArrayList.add(L[pivotIndex]);

				for (int i = 0; i < L.length; i++) {
					if (L[i] > L[pivotIndex]) {
						cheesyArrayList.add(L[i]);
					}
				}

				int highNumsCount = cheesyArrayList.size() - lowNumsCount - 1;
				Integer[] partitionedList = cheesyArrayList.toArray(new Integer[]{});

				int[] lowNums = new int[lowNumsCount];
				for (int i = 0; i < lowNumsCount; i++) {
					lowNums[i] = partitionedList[i];
				}
				int[] highNums = new int[highNumsCount];
				for (int i = lowNumsCount + 1; i < partitionedList.length; i++) {
					highNums[i - (lowNumsCount + 1)] = partitionedList[i];
				}

				lowNums = qsort(lowNums);
				highNums = qsort(highNums);

				ArrayList<Integer> finalArrayList = new ArrayList<Integer>(); 
				for (int i = 0; i < lowNums.length; i++) {
					finalArrayList.add(lowNums[i]);
				}	

				finalArrayList.add(L[pivotIndex]);
	
				for (int i = 0; i < highNums.length; i++) {
					finalArrayList.add(highNums[i]);
				}
				Integer[] finalArray = finalArrayList.toArray(new Integer[]{});

				int[] trueFinalArray = new int[finalArray.length]; 
				for (int i = 0; i < finalArray.length; i++) {
					// Convert Integer objects to ints for array 
					int value = finalArray[i].intValue();
					trueFinalArray[i] = value; 

				}

				return trueFinalArray;


			}
		}	
		public static int pivot(int[] a, int low, int high, int pivotIndex) {
			// Modified Pivot for HW 7B
			int pivotValue = a[pivotIndex];
			a[pivotIndex] = a[pivotIndex] + a[high];
			a[high] = a[pivotIndex] - a[high];
			a[pivotIndex] = a[pivotIndex] - a[high]; // Swap 
			int startingIndex = low; 
			for (int j = low; j < high; j++) {
				if (a[j] <= pivotValue) {
					a[j] = a[j] + a[startingIndex];
					a[startingIndex] = a[j] - a[startingIndex];
					a[j] = a[j] - a[startingIndex]; // Swap 
					startingIndex++;					
				}
			}
			a[high] = a[high] + a[startingIndex];
			a[startingIndex] = a[high] - a[startingIndex];
			a[high] = a[high] - a[startingIndex]; // Swap
			return startingIndex; // gives you pivot final position
		}

	public static void main(String[] args) {
		int[] l1 = {1, 5, 6, 1, 2, 10, 1, 2, 3, 1, 4};
		int[] a1 = qsort(l1);

		for(int i = 0; i < a1.length; i++) {
			System.out.println(a1[i]);
		}
	}
}