import java.util.Timer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.lang.*;
import java.util.Scanner;

public class SortingStuff {
	
	public static void main(String[] args) {
		
		/////////////////////PART A///////////////////////////
		int a=0;
		
		
	while(a<2) {	
		Random r1 = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n");
		int input = sc.nextInt();
		
		
		int []array = generateArray(input);
		long timerCounter = System.nanoTime();
		int j = 0;
		while(j<500) {
			int index= r1.nextInt(array.length) +(0);
			int key = array[index];
			
			boolean hello =binarySearch(array, key, 0, array.length-1);
			j++;
		}
		long timerCounterEnd = (System.nanoTime() - timerCounter)/500;
		
		
		long timerCounter2 = System.nanoTime();
		int k=0;
		while (k<500) {
			int index= r1.nextInt(array.length) +(0);
			int key = array[index];
			boolean hello2 = linearSearchAlgo(array, key);
			k++;
		}
		
		long timerCounter2End = (System.nanoTime() - timerCounter2)/500;
		System.out.println("The average case scenario time for running BSA multiple times with " + input  + " is " + timerCounterEnd);
		System.out.println("The average case scenario time for running LSA multiple times with " + input + " is " + timerCounter2End);
		
//		double timeToExecuteOneStep = ((int)timerCounter2End / 1000000000.0)/(Math.log(input)/Math.log(2));
//		System.out.println("Time to execute one step is: " + timeToExecuteOneStep);
		
		
		
		
		
		
		
		////////////////////////////////////////PART B///////////////////////////////////////////////
	
		int brandNewKey = 5000;
		long timerCounterBrand = System.nanoTime();
		int m = 0;
		while(m<1) {

			boolean hello =binarySearch(array, brandNewKey, 0, array.length-1);
			m++;
		}

		long timerCounterBrandEnd = (System.nanoTime() - timerCounterBrand);
		
		
		long timerCounter2Brand = System.nanoTime();
		int n=0;
		while (n<1) {
			boolean hello2 = linearSearchAlgo(array, brandNewKey);
			n++;
		}
		
		long timerCounter2BrandEnd = (System.nanoTime() - timerCounter2Brand);
		System.out.println();
		
		System.out.println("The worst case scenario time for running BSA multiple times with " + input + " is " +  timerCounterBrandEnd);
		System.out.println("The worst case scenario time for running LSA multiple times with " + input + " is " + timerCounter2BrandEnd);
		
		
		double singleTime = singleTimeCalculator(timerCounterBrandEnd, timerCounter2BrandEnd, input);
		//System.out.println(singleTime + " Single time is");
		if(a==1) {
			double finalSingleTime=(singleTime *0.000000001);	
			
			calculateTheoreticalWorstTime(finalSingleTime, input);
			System.out.println("The single time to running one line of code is " + singleTime);
		}
		
		
		
		a++;
		
	}
	
		
		
	
	}
	
	public static void calculateTheoreticalWorstTime(double finalSingleTime, int input) {
		
		double theoreticalBinaryWorst = ((double)finalSingleTime) * (long)(Math.log(input)/Math.log(2));
		double theoreticalLinearWorst =   ((double)finalSingleTime) * (long)(input);
		System.out.println("Theoretical worst case scenario for BSA is: " + (int)(theoreticalBinaryWorst * 1000000000));
		System.out.println("Theoretical worst case scenario for LSA is: " + (int)(theoreticalLinearWorst * 1000000000));
		
		
	}
	
	
	public static boolean binarySearch(int [] array, int key, int begin, int end ) {
		int midpoint = (end + begin)/2 ;
		
		//base case checks if the leftover array's size is one
		if(end<begin) {
			return false;
		}
		if(key == array[midpoint]) {
			return true;
		}
		else if(key < array[midpoint]) {
			return binarySearch(array, key, 0, midpoint-1);
		}
		else {
			return binarySearch(array, key, midpoint+1, end);
		} 
	}
	
	
	public static boolean linearSearchAlgo(int [] arr, int key) {
		for (int i =0; i<arr.length; i++) {
			if (arr[i]==key) {
				return true;
			}
		}
		return false;
	}
	
	//find the single running time of one instruction in code
	public static double singleTimeCalculator(long binarySearchSingle, long linearSearchSingle, int input) {
		long firstSingle = (binarySearchSingle) /  (long)( Math.log(input)/(Math.log(2)));
		long secondSingle = (linearSearchSingle) / (long)input;
		return ((double)(firstSingle + secondSingle)/(double)2);
	}

	
	public static int[] generateArray(int input){
		ArrayList<Integer> daArrayList = new ArrayList<Integer>();
		int[]array = new int[input];
		for (int i=0; i<input; i++) {
			int somethingElse = (int) Math.floor(Math.random()*2000)-1000;
			daArrayList.add(somethingElse);
		}
		 
		
		for (int i=0; i<input;i++) {
			array[i] = daArrayList.get(i);
		}
		return array;
	}

}


