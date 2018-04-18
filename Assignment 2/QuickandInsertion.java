import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QuickandInsertion {

	
	public static void main(String []args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter n");
		int n = scan.nextInt();
		
		int []array3 = generateRandomNumbers(n);
		int []array4 = generateRandomNumbers(n);
		
		

		
		quicksort2(array3,0,array3.length-1);
		System.out.println("Quicksort");
		for(int k=0;k<array3.length;k++) {
			System.out.println(array3[k]);
		}
//		
		System.out.println("");
		insertionSort(array4, 0, array4.length-1);
		
//		for(int k=0;k<array4.length;k++) {
//			System.out.println(array4[k]);
//		}
		
		
	
		averageQuickSortRun(10000);
		averageInsertionSortRun(10000);
		singleTimeCalculations(10000);
		
		
		
		
	}
	
	//This method computes the single time to run one line of code
	public static void singleTimeCalculations(int input) {
		long startingTime = System.nanoTime();
		int m=0;
		while(m<1) {
			int [] test = generateRandomNumbers(10000);
			quicksort2(test, 0, test.length-1);
			m++;
		}
		long endingTime = System.nanoTime()-startingTime;
		
		
		long startingTime2 = System.nanoTime();
		int l=0;
		while(l<1) {
			int [] test = generateRandomNumbers(10000);
			insertionSort(test, 0, test.length-1);
			l++;
		}
		long endingTime2 = System.nanoTime()-startingTime2;
		
		long singleQuick = (long) ((endingTime) /  ((input)*(long)Math.log(input)/(Math.log(2))));
		long singleInsertion = (endingTime2) / (input*input);
		
		long singleTime = 1000000000 / (singleInsertion);
		System.out.println("Instructions per second : " + singleTime);
	}
	
	
	
	//Computes the average running time of quicksort 
	public static void averageQuickSortRun(int input) {
		long startingTime = System.nanoTime();
		int m=0;
		while(m<100) {
			int [] test = generateRandomNumbers(input);
			quicksort2(test, 0, test.length-1);
			m++;
		}
		long endingTime = System.nanoTime();
		
		long averageQuickSortRun = (endingTime - startingTime)/100;
		System.out.println("Running time average for quick sort is " + averageQuickSortRun + " for 100 repetitions");
	
		
		
	}
	
	//Computes the average running time of insertion sort
	public static void averageInsertionSortRun(int input) {
		int m=0;
		long startingTime = System.nanoTime();
		while(m<100) {
			int [] test = generateRandomNumbers(input);
			insertionSort(test,0,test.length-1);
			m++;
		}
		long endingTime = System.nanoTime();
		
		long averageInsertionSortRun = (endingTime - startingTime)/100;
		System.out.println("Running time average for insertion sort is " + averageInsertionSortRun + " for 100 repetitions");
	
		
	}
	
	
	//This method generates random numbers between -7000 and 7000 and places each number in the array
	public static int [] generateRandomNumbers(int input) {
		int [] daArray = new int[input];
		for (int i =0; i<daArray.length; i++) {
			daArray[i] = (int) Math.floor(Math.random()*14000)-7000;
		}
		return daArray;
		
	}
	
	//Insertion sort
	public static void insertionSort(int []array,int daBeginning, int daEnding) {
		int i=daBeginning+1;
		
		while(i<daEnding+1) {
			int keyTemp = array[i];
			int k = i;
			while(k > 0 && array[k-1] > keyTemp) {
				array[k] = array[k-1];
				k=k-1;
			}
			array[k] = keyTemp;
			i++;
		}

	}
	

	public static void quicksort(int []array,int startingPoint, int endingPoint) {
		
		if(Math.max(startingPoint,endingPoint) == endingPoint) {
			int	pace = partition(array, startingPoint, endingPoint);
			quicksort(array,startingPoint, pace-1);
			quicksort(array,pace+1, endingPoint);
		}
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

	
	
	//This method finds the pivot using the rule of median of three by deciding which element is the middle element
	public static void findMedian(int[]array, int startingPoint, int endingPoint) {		
		int maximum = Math.max(array[startingPoint], Math.max(array[((endingPoint+startingPoint)/2)],array[endingPoint]));
        
		int minimum = Math.min(array[startingPoint], Math.min(array[((endingPoint+startingPoint)/2)],array[endingPoint]));

		//checks if the beginning element is equivalent to the middle element,because we might have to switch positions
		if(array[startingPoint] == array[((endingPoint+startingPoint)/2)]) {
				int temp = array[startingPoint];
				array[startingPoint] = array[endingPoint];
				array[endingPoint] = temp;
		}
		
		else {
			
			//if the first element is not the maximum element or the min, then it is the pivot
			if(array[startingPoint] != maximum && array[startingPoint] != minimum ) {
				int aux = array[startingPoint];
				array[startingPoint] = minimum;
				array[((endingPoint+startingPoint)/2)] = maximum;
				array[endingPoint] = aux;
			}
			
			//if the second element is not the maximum element or the min, then it is the pivot
			else {
				
				if(array[((endingPoint+startingPoint)/2)] != maximum && array[((endingPoint+startingPoint)/2)] != minimum ) {
					int aux2 = array[((endingPoint+startingPoint)/2)];
					array[startingPoint] = minimum;
					array[((endingPoint+startingPoint)/2)] = maximum;
					array[endingPoint] = aux2;
				}
				//if the third element is not the maximum element or the minimum, then it is the pivot
				else {
					if(array[endingPoint] != maximum && array[endingPoint] != minimum) {
						int aux3 = array[endingPoint];
						array[startingPoint] = minimum;
						array[((endingPoint+startingPoint)/2)] = maximum;
						array[endingPoint] = aux3;
					}	
				
				}
			}
		}
		
		
	}
	
	public static void partitionWeird(int []array, int startingPoint, int endingPoint) {
		ArrayList<Integer> lessThanPivot = new ArrayList<Integer>();
		ArrayList<Integer> greaterThanPivot = new ArrayList<Integer>();
		int pivot = array[endingPoint];
		
		for(int i = startingPoint; i<endingPoint;i++) {
			if(array[startingPoint] <pivot) {
				lessThanPivot.add(array[startingPoint]);
			}
			else {
				greaterThanPivot.add(array[startingPoint]);
			}
		}
		//placing the elements less than the pivot at the first half
		int tracker = startingPoint;
		for(int j=0; j < lessThanPivot.size();j++) {
			array[tracker] = lessThanPivot.get(j);
		}
		//moving the pivot to the middle of the array
		array[tracker++] = array[endingPoint];
		int pivotIndex = tracker;
		
		for(int k=0; k<greaterThanPivot.size();k++) {
			array[tracker] = greaterThanPivot.get(k);
		}
		
	}
	
	
	//This algorithm partitions a subarray accordingly to the rules of the median of three
	public static int partitionMedianOfThrees(int []array, int startingPoint, int endingPoint) {
		int pivot = array[endingPoint];
		
		int i=startingPoint;
		int j =endingPoint-1;
		
		while(i!=j) {
			//move i to the right, and stop if array[i] is greater than the pivot
			while(array[i] < pivot) {
				i++;
			}
			
			//move j to the left, and stop if array[i] is less than the pivot
			while(array[j]>pivot) {
				j--;
			}
			//if i is greater than j, then exit loop
			if(i>j) {
				break;
			}
			//otherwise swap elements of array[i] and array[j]
			else {
				int auxiliary = array[i];
				array[i]= array[j];
				array[j] = auxiliary;
			}
			
		}
		
		//finally swap the pivot with array[i]
		int temp = array[i];
		array[i] = array[endingPoint];
		array[endingPoint] = temp;
		
		//returns the index of the pivot
		return i;
		}
		
		//This method utilizes the quicksort algorithm with the median of three partitioning application
		public static void quicksort2(int []array, int begin, int end) {
			//base case
			if((begin-end)+1 <=3) {
				insertionSort(array,begin,end);

			}
			//if the difference between the starting point and ending point is 5 or more proceed...
			else {
				findMedian(array, begin, end);
				int middle = partitionMedianOfThrees(array,begin,end);
				quicksort2(array,begin, middle-1);
				quicksort2(array,middle+1, end);
			}
		}
	}
	
	
	
	


