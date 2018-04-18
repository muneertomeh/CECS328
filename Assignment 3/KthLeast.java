import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class KthLeast {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter n");
		int n = scan.nextInt();
		int array[] = generateArray(n);
		
		System.out.println("Enter k");
		
		int k=scan.nextInt();
		System.out.println("k = " + k);
		
		int a = partition(array,0,array.length-1,k);
		System.out.println();
		
		Arrays.sort(array);
		for(int j=0;j<array.length;j++) {
			System.out.println(array[j]);
		}
		System.out.println();
	
	}
	
	//This method partitions the array
		public static int partition(int []array, int startingPoint, int endingPoint, int k) {
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
			
			int temp = array[i+1];
			array[i+1] = array[endingPoint];
			array[endingPoint] = temp;

			System.out.println("");
			System.out.println("");
			System.out.println("");
			for(int t=startingPoint;t<endingPoint+1;t++) {
				System.out.println(array[t]);
			}
			System.out.println();
			
			int indexOfPivot = i+1;
			
			if((indexOfPivot-startingPoint+1) == k) {
				System.out.println("Hooray, the kth least element has been found, it is " + array[indexOfPivot]);
				return array[indexOfPivot];
			}
			else {
				if(indexOfPivot-startingPoint+1 > k) {
					ArrayList<Integer> alist = new ArrayList<Integer>();
					for(int m=startingPoint; m<indexOfPivot;m++) {
						alist.add(array[m]);
					}
					if(alist.size()==1) {
						System.out.println("Hooray, the kth least element has been found, it is " + alist.get(0));
						return 0;
					}
					else {
						int arr2[] = new int[indexOfPivot-startingPoint];
						for(int n=0; n<arr2.length;n++) {
							arr2[n] = alist.get(n);
						}
						partition(arr2,0,arr2.length-1,k);
					}
						
				}
				else {
					ArrayList<Integer> alist = new ArrayList<Integer>();
					for(int m=(indexOfPivot+1); m<endingPoint+1;m++) {
						alist.add(array[m]);
					}
					int arr2[] = new int[endingPoint-(indexOfPivot)];
					for(int n=0; n<arr2.length;n++) {
						arr2[n] = alist.get(n);
					}
					k = k-(indexOfPivot+1);
					partition(arr2,0,arr2.length-1,k);
				}
			}
			return 0;
		}
		
		//This method generates an array of random numbers
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
