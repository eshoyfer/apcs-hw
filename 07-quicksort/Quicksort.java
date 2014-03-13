public class Quicksort {
		public static int[] qsort(int[] L) {
			Random r = new Random();

			if (L.length <= 1) {
				return L;
			}

			else {
				int pivotIndex = low + r.nextInt(high - low + 1); // Select Pivot 
				ArrayList r1ArrayList = new ArrayList(); // cheesy way 
				for (int i = 0; i < L.length; i++) {
					if (L[i] < L[pivotIndex]) {
						r1ArrayList.add();
					}
				}
				ArrayList r2ArrayList = new ArrayList(); // cheesiness again
				for (int i = 0; i < L.length; i++) {
					if (L[i] > L[pivotIndex]) {
						r2ArrayList.add();
					}
				}
				r1 = r1ArrayList.toArray();
				r2 = r2ArrayList.toArray(); 
				r1 = qsort(r1);
				r2 = qsort(r2);
				int retLength = L.length; // r1.length + r2.length + 1 
				int[] retLength = new int[retLength];

			}
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
		l1 = {1, 5, 6, 1, 2, 10, 1, 2, 3, 1, 4};
		System.out.println(qsort(l1));
	}
}