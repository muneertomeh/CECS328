import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Heapsort {
	
	public static void main(String []args) {
		int []a = generateArray(10);
		for(int j =0; j<a.length;j++) {
			System.out.println(a[j]);
		}
		System.out.println();
		heapsort(a);
		for(int j =0; j<a.length;j++) {
			System.out.println(a[j]);
		}
		averageHeapsort(10);
		averageSelectionSort(100);
		averageQuicksort(100);
		
	}
	
	//Heapsort Algorithm
	public static void heapsort(int []a) {
		buildMaxHeap(a);
		
		//keeps track of how many nodes are left in heap
		int lastIndex = a.length-1;
		int size = a.length;
		int [] newArray = new int[a.length];

		//this algorithm removes the current root, which is then placed in a new array,
		//after that, we max heapify the heap post removal of root
		while(lastIndex !=0) {
			//swap the root and last element of the heap
			int auxiliary = a[0];
			a[0] = a[lastIndex];
			a[lastIndex] = auxiliary;
			//add the removed root to the end of the new array
			newArray[lastIndex] = a[lastIndex];
			lastIndex--;
			size--;
			maxHeapify(a,0, size);
		}
		
	}
	
	//This method builds a max heap from an array of random integers
	public static void buildMaxHeap(int []a) {
		for(int i = (a.length)/2;i>-1;i--) {
			maxHeapify(a,i, a.length);
		}
	}
	
	
	public static void maxHeapify(int []a, int index, int sizeOfArray) {
		int leftIndex = (index*2)+1;
		int rightIndex = (index*2)+2;
		int maxIndex = index;
		//first check if child of a[index] exists, if true then,
		//determine if the left child of a[index] is greater or than its parent, if yes left child index becomes max index
		if(sizeOfArray-1>= leftIndex ) {
			if(a[leftIndex]> a[maxIndex]) {
				maxIndex=leftIndex;
			}
		}
		//check if right child of a[index] exists, if true then,
		//determine if the right child of a[index] is greater than its parent, if yes right child index becomes max index
		if(sizeOfArray-1>= rightIndex) {
			if(a[rightIndex]>a[maxIndex]) {
				maxIndex=rightIndex;
			}
		}
		//if the max index has been altered through any changes, swap a[index] and a[maxIndex] (one of a[index]'s children)
		//and recursively call maxHeapify once again...
		if(maxIndex!=index) {
			int temp = a[maxIndex];
			a[maxIndex] = a[index];
			a[index] = temp;
			maxHeapify(a,maxIndex,sizeOfArray);
		}
	}
	
	//Calcualtes the average running time of heapsort with a selected amount of repetitions
	public static void averageHeapsort(int maxRepetitions) {
		int n=0;
		long startTime = System.nanoTime();
		while(n<maxRepetitions) {
			int []a = generateArray(10000);
			heapsort(a);
			n++;
		}
		long endTime = System.nanoTime();
		long heapsortAverage = endTime-startTime;
		System.out.println("Average running time of heapsort for " + maxRepetitions + " repetitions is " + heapsortAverage);
	}
	
	
	//This method generates an array filled with random numbers
	public static int[] generateArray(int input){
		ArrayList<Integer> daArrayList = new ArrayList<Integer>();
		int[]array = new int[input];
		for (int i=0; i<input; i++) {
			int somethingElse = (int) Math.floor(Math.random()*200)-100;
			daArrayList.add(somethingElse);
		}
		 
		
		for (int i=0; i<input;i++) {
			array[i] = daArrayList.get(i);
		}
		return array;
	}
	
	//Selection sort algorithm
	public static void selectionSort(int []array) {
		for(int i=0;i<array.length;i++) {
			int minimum = i;
			for(int j=i+1;j<array.length;j++) {
				if(array[minimum]>array[j]) {
					minimum = j;
				}
			}
			int temp = array[minimum];
			array[minimum] = array[i];
			array[i] = temp;
		}
	}
	
	
	//Calcualtes the average running time of heapsort with a selected amount of repetitions
	public static void averageSelectionSort(int maxRepetitions) {
		int n=0;
		long startTime = System.nanoTime();
		while(n<maxRepetitions) {
			int []a = generateArray(100);
			selectionSort(a);
			n++;
		}
		long endTime = System.nanoTime();
		long selectionSortAverage = endTime-startTime;
		System.out.println("Average running time of selection sort for " + maxRepetitions + " repetitions is " + selectionSortAverage);
	}
	
	//Quicksort algorithm
	public static void quicksort(int []array,int startingPoint, int endingPoint) {
		if(Math.max(startingPoint,endingPoint) == endingPoint) {
			int	pace = partition(array, startingPoint, endingPoint);
			quicksort(array,startingPoint, pace-1);
			quicksort(array,pace+1, endingPoint);
		}
	}
	
	public static void averageQuicksort(int maxRepetitions) {
		int n=0;
		long startTime = System.nanoTime();
		while(n<maxRepetitions) {
			int []a = generateArray(100);
			quicksort(a,0, a.length-1);
			n++;
		}
		long endTime = System.nanoTime();
		long quickSortAverage = endTime-startTime;
		System.out.println("Average running time of quick sort for " + maxRepetitions + " repetitions is " + quickSortAverage);
	}
	
	
	//This method partitions the array
	public static int partition(int []array, int startingPoint, int endingPoint) {
		int i=startingPoint-1;
		int pivot = array[endingPoint];
		for (int j = startingPoint; j<endingPoint;j++) {
			if(pivot > array[j]) {
				i++;
				int auxiliary = array[j];
				array[j] = array[i];
				array[i] = auxiliary;
			}
		}
		//finally swap the pivot with array[i+1]
		int temp = array[i+1];
		array[i+1] = array[endingPoint];
		array[endingPoint] = temp;

		return i+1;
	}
	
	
}
