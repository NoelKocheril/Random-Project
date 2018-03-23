package practice;

import java.util.Arrays;
import java.util.Scanner;

/*
An array is bitonic if it is comprises of an increasing sequence of integers followed immediately by a decreasing sequence of integers.
Given such a array, you need to find a element X in it and print its index.
In case, X does not exist in the array print "OOPS! NOT FOUND" without quotes.
Note: It is guaranteed that array consist of distinct elements. And array indexing is from 0.

Input:
First line will consist  a number T, the number of test cases.
Each test case will then consist of two numbers N and X. N being the array size and X being the element to be searched for.
Next line will consist of N space separated integers.


Output:
Print the required answer on separate lines. 
 */

public class Find_Number {

	public static void main (String[] args) {
	    int T, N, X;
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		for(int i = 0; i < T; i++){
		    N = in.nextInt();
		    X = in.nextInt();
//		    System.out.printf("T: %d, N: %d, X: %d\n", T, N, X);
		    int[] A = new int[N]; 
		    for(int j = 0; j < N; j++) A[j] = in.nextInt();
//		    System.out.println(Arrays.toString(A));
		    for(int j = 0; j < N; j++) {
		    	if(X == A[j]) {
		    		System.out.println(j);
		    		break;
		    	} 
		    	else if (j == N-1) System.out.println("OOPS! NOT FOUND");
		    }
		}
	}
}
