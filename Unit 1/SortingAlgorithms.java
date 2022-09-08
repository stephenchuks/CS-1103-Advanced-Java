import java.util.Arrays;

/** A program to compare the efficiency of two sorting algorithms asymptotically
 * For this program, we will be testing between the inbuilt Array.sort and our 
 * user defined Selection sort algorithms.  We will be populating the two arrays 
 * with the same random numbers and  printing out the time taken to sort
 * each of the arrays using different array sizes from large array sizes to very large 
 * array and very very large array sizes - these sizes can be any arbitrary figures
 * for testing purposes only.   Testing the efficiency with array of size 1000, the array
 * sort method took 2 mili-seconds while the selection sort took 4 milisenconds. Testing 
 * with array size 10000, the Arrays.sort() took 5 miliseconds while the selection sort 
 * took 72 miliseconds. On array size of 100000, the arrays.sort() took 64 miliseconds while
 * the selection sort took 5257 to complete.
 * 
 * @author Chuks Stephen
 *
 */

public class SortingAlgorithms {
// Compute benchmarks of two different sorting techniques
 
	int maxArraySize=100000; // Array Size
	int[] forSelectionSort = new int[maxArraySize]; // First Array
	int[] forArraySort = new int[maxArraySize]; // Second Array

 
public SortingAlgorithms(){
 
	for (int i = 0; i < forSelectionSort.length; i++) {
		forSelectionSort[i]=(int)(Integer.MAX_VALUE * Math.random());
		forArraySort[i]=forSelectionSort[i];
	}
 
	long startTimeArr1 = System.currentTimeMillis(); 
	selectionSort(forSelectionSort); 
	long runTimeArr1 = System.currentTimeMillis() - startTimeArr1; 

	long startTimeArr2 = System.currentTimeMillis();
	Arrays.sort(forArraySort); 
	long runTimeArr2 = System.currentTimeMillis() - startTimeArr2; 
 
	System.out.println("Time taken for the selection sort in mili-seconds):"+runTimeArr1); 
	System.out.println("Time taken for the Arrays.sort in mili-seconds:"+runTimeArr2); 
	}

/*
 * @selectionSort - the definition of the method to test for the selection sort algorithm
 * @param A - the value of 
 */
 
static void selectionSort(int[] A) {
	for (int min_index = A.length-1; min_index > 0; min_index--) {
		int max_index = 0; 
		for (int j = 1; j <= min_index; j++) {
			if (A[j] > A[max_index]) {
				max_index = j;
			}
		}
		int temp = A[max_index]; // Swap largest item with A[lastPlace].
		A[max_index] = A[min_index];
		A[min_index] = temp;
	}
}

 
}
