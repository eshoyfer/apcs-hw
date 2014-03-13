import java.io.*;
import java.util.*;

public class Quickselect {

	public static int quickselect(int[] a, int k, int low, int high) {
		Random r = new Random();
		int pivotIndex = low + r.nextInt(high - low + 1);

		if (low < high) {
			a = pivot(a, low, high, pivotIndex);
			if (k == pivotIndex) {
				return a[pivotIndex];
			} else if (k < pivotIndex) { // left 
				return quickselect(a, k, low, pivotIndex - 1);
			} else { // right
				return quickselect(a, k, pivotIndex + 1, high);
			}
		}

		return a[low];
	}

	public static int[] pivot(int[] a, int low, int high, int pivotIndex) {
		int[] ret = new int[high - low + 1];

		int pivot = a[pivotIndex];
		for (int i = low; i <= high; i++) {
			int j = i - low;
			if (a[i] < pivot) {
				ret[j] = a[i];
			}
		}

		for (int i = low; i <= high; i++) {
			int j = i - low;
			if (a[i] == pivot) {
				ret[j] = a[i];
			}
		}

		for (int i = low; i <= high; i++) {
			int j = i - low;
			if (a[i] > pivot) {
				ret[j] = a[i];
			}
		}

		// copy back

		for (int i = low; i <= high; i++) {
			int j = i - low;
			a[i] = ret[j];
		}

		return a;
	}

	public static void main(String[] args) {
		int[] t1 = {1, 5, 3, 2, 9, 10, 1, 2};
		System.out.println(quickselect(t1, 1, 0, 7));
	}
}