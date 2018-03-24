package practice;

/*
This problem was asked by Uber.
Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
Follow-up: what if you can't use division?
 */

public class ProductArr {
	/**
	 * Prints out the Product of all elements excluding current index
	 * @param Numbers Array of Numbers
	 * @param n Size of Numbers
	 */
	void ProductArray(int[] Numbers, int n) {

		int i, temp=1;
		int[] output = new int[n];
		
		output[n-1] = 1;
		
		for(i= 0;i < n;i++) {
			output[i] = temp;
			temp *= Numbers[i];
		}
		temp = 1;
		for(i = n-1; i >= 0;i--) {
			output[i] *= temp;
			temp *= Numbers[i];
		}
		
		for(int e : output) {
			System.out.printf("%d ", e);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ProductArr pa = new ProductArr();
		int arr[] = {2, 3, 5, 6, 2, 5, 6,7, 8, 4, 6};
		int n = arr.length;
		System.out.print("The product array is: ");
		pa.ProductArray(arr, n);
	}
}
