package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/*
This problem was asked by Stripe.
Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
You can modify the input array in-place.
 */

public class Missing_Int {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int Numbers[] = null;

		System.out.println("Enter size of Array");
		int size = in.nextInt();

		System.out.print("Enter Array: ");
		Numbers = new int[size];
		for(int i = 0;i<size;i++) {
			Numbers[i] = in.nextInt();
		}
		System.out.println(Miss_Int3(Numbers));
		in.close();
	}

	//O(nlogn)
	public static int Miss_Int1(int arr[]) {
		MergeSort o = new MergeSort();
		o.sort(arr,0,arr.length-1);
		int low = arr[0], index = 0;
		HashSet <Integer> s_Int = new HashSet<Integer>();
		for(int i = 0; i < arr.length;i++) {
			s_Int.add(arr[i]);
			if(arr[i]>0 && low > arr[i]) {
				low = arr[i];
				index = i;
			}
		}
		System.out.printf("low: %d Index: %d set: %s\n",low, index, s_Int);
		for(int i = 1; i < arr.length-index;i++) {
			if(!s_Int.contains(i+low)) {
				return i+low;
			}
		}

		if(low != 1) 
			return 1;

		return arr[arr.length-1]+1;
	}

	//O(n) but !O(1) extra space
	public static int Miss_Int2(int arr[]) {
		HashSet<Integer> s = new HashSet<Integer>();
		for(int i = 0; i < arr.length;i++)
			s.add(arr[i]);
		int j = 1;
		while(true) {
			if(!s.contains(j)) return j;
			j++;
		}
	}

	private static int segregate(int arr[]) {
		int j = 0, i;
		for(i = 0; i < arr.length;i++) {
			if(arr[i]<=0) {
				int temp;
				temp= arr[i];
				arr[i]= arr[j];
				arr[j] = temp;
				j++;
			}
		}
		return j;
	}

	private static int Find_Missing(int[] arr) {
		int i;

		for(i=0;i<arr.length;i++)
			if(Math.abs(arr[i])-1< arr.length && arr[Math.abs(arr[i])-1]>0) 
				arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];

		for(i = 0; i < arr.length;i++) 
			if(arr[i] > 0)
				return i +1;

		return arr.length+1;
	}

	public static int Miss_Int3(int arr[]) {
		int shift = segregate(arr);
		MergeSort.printArray(arr);
		int arr2[] = new int[arr.length-shift];
		int j=0;
		for(int i = shift;i<arr.length;i++) {
			arr2[j]=arr[i];
			j++;
		}
		MergeSort.printArray(arr2);
		return Find_Missing(arr2);
	}


}
