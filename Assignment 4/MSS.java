import java.util.ArrayList;

public class MSS {
	public static void main(String []args) {
		
		int []a = generateArray(8);
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		basicMSS(a);
	
		int result = divideConquerMSS(a,0,a.length-1);
		
		System.out.println("The maximum subsequence sum using O(n log n) implementation is " + result );
		

	}
	
	//This method computes the maximum subsequence sum of an array at O(n) time
	public static void basicMSS(int []daArray) {
		int auxiliary = daArray[0];
		int MSS = daArray[0];
		if(auxiliary<0) {
			auxiliary=0;
			MSS=0;
		}
		for(int i=1;i<daArray.length;i++) {
			auxiliary += daArray[i];
			//if the auxiliary value is below 0, make the axuiliary value equivalent to 0
			if(auxiliary<0){
				auxiliary=0;
			}
			//determine whether the auxiliary value is greater than the concurrent MSS,
			//if yes, then make the axuiliary value the new concurrent MSS
			if(auxiliary>MSS) {
				MSS = auxiliary;
			}

		}
		System.out.println("The maximum subsequence sum using O(n) implementation is " + MSS);
		
	}
	
	
	
	public static int divideConquerMSS(int []array, int begin, int end) {
		//base case
		if(end-begin ==0) {
			return array[begin];
		}
		
		int middle = (end+begin)/2;

		
		int leftSubArray = divideConquerMSS(array,begin, middle);
		int rightSubArray = divideConquerMSS(array,middle+1, end);
		int crossingSum = crossingSumCalculations(array,begin, middle,end);
		return(Math.max(leftSubArray, Math.max(rightSubArray, crossingSum)));
	}
	
	public static int crossingSumCalculations(int []arr, int starting, int midpoint, int end) {
		
		//Calculate left crossing sum
		int leftSum = 0;
		int sum = 0;
		for(int i=midpoint; i>starting-1; i--) {
			sum += arr[i];
			if(sum>leftSum) {
				leftSum = sum;
			}
		}
		//Calculate right crossing sum
		int rightSum = 0;
		sum = 0;
		for(int j=midpoint+1; j<end+1;j++) {
			sum += arr[j];
			if(sum>rightSum) {
				rightSum = sum;
			}
		}
		
		//add the left and right crossing sums together
		int runningSum = leftSum + rightSum;
		return runningSum;
		
	}
	
	
	
	//This method generates an array of random numbers from -100 to 200
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
}
