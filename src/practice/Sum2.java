package practice;

import java.util.ArrayList;
import java.util.Scanner;

/*
Given a list of numbers, return whether any two sums to k.
For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
Bonus: Can you do this in one pass?
 */

public class Sum2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//Get List
		System.out.println("Format for List: N N N N N N... where N can be any Integer (Space Seperated)");
		System.out.print("Enter List: ");
		String[] in_Set = in.nextLine().split(" ");
		
		//Make List
		ArrayList<Integer> Numbers = new ArrayList<Integer>();
		for(String e:in_Set) {
			Numbers.add(Integer.parseInt(e));
		}
		System.out.println(Numbers);
		
		//Get Step you want to Reach
		System.out.print("Enter Sum you Wish to Reach: ");
		int sum = in.nextInt();
		long t1, t2;
		boolean out;
		t1 = System.nanoTime();
		out = checkSumSlow(Numbers, sum);
		t2 = System.nanoTime();
		System.out.printf("checkSumSlow with %s \nand Sum: %d completes in %d NanoSeconds\n", Numbers, sum, t2-t1);
		System.out.println(out);
		
		t1 = System.nanoTime();
		out = checkSumFast(Numbers, sum);
		t2 = System.nanoTime();
		System.out.printf("checkSumFast with %s \nand Sum: %d completes in %d NanoSeconds\n", Numbers, sum, t2-t1);
		System.out.println(out);
		in.close();
	}
	
	public static boolean checkSumSlow(ArrayList<Integer> arr, int sum) {
		for (int i = 0; i < arr.size();i++) {
			for (int j = i; j < arr.size();j++) {
				if((arr.get(i)+arr.get(j)) == sum) return true;
			}
		}
		return false;
	}
	
	public static boolean checkSumFast(ArrayList<Integer> arr, int sum) {
		for(int e : arr) {
			if(arr.contains(sum-e)) return true;
		}
		return false;
	}
}
