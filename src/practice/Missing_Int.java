package practice;

import java.util.ArrayList;
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


	}

}
