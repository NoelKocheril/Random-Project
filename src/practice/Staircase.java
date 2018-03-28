package practice;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * There is a staircase with N steps, and you can climb 1 or 2 steps at a time. 
 * Given N, write a function that returns the number of unique ways you can 
 * climb the staircase. The Order of the Steps matter.
 * 
 * For example, if N is 4, then there are 5 unique ways:
 *  - 1, 1, 1, 1
 *  - 2, 1, 1
 *  - 1, 2, 1
 *  - 1, 1, 2
 *  - 2, 2
 *  
 *  What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number 
 *  from a set of positive integers X?
 *  
 *  For Example, if X = {1, 3, 5},
 *  you could climb 1, 3, or 5 steps at a time,
 *  
 *  Generalize your function to take in X.
 */



public class Staircase {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//Get Set
		System.out.println("Format for Set: N N N N N N... where N can be any Positive Integer (Space Seperated)");
		System.out.print("Enter Set of positive integers to increment by: ");
		String[] in_Set = in.nextLine().split(" ");
		
		//Make Set
		Set<Integer> steps = new HashSet<Integer>();
		for(String e:in_Set) {
			steps.add(Math.abs(Integer.parseInt(e)));
		}
		System.out.println(steps);
		
		//Get Step you want to Reach
		System.out.print("Enter Step you Wish to Reach: ");
		int _final = in.nextInt();
		
		//Print out using only 1 or 2 steps
		System.out.printf("Number of Ways to get to Step %d using only 1 or 2 steps is: %d\n", _final, genPathCount1(_final));
		System.out.printf("Number of Ways to get to Step %d using the Set %s steps is: %d\n",_final, steps, genPathCount2(steps, _final));
			
		in.close();
	}

	public static int genPathCount1(int Step){
		int[] cache = new int[Step+1];
		cache[0] = 1;
		cache[1] = 1;
		cache[2] = 2;
		for(int i = 3; i < Step+1; i++) {
			cache[i] += cache[i-1] + cache[i-2];
		}
		return cache[Step];
	}
	
	public static int genPathCount2(Set<Integer> X, int Step) {
//		System.out.println(X);
		int[] cache = new int[Step+1];
		cache[0] = 1;
		for (int i = 1; i < Step+1; i++) {
			for(int x : X) {
				if (i-x >= 0) cache[i] += cache[i-x];
			}
		}
//		for(int e : cache) System.out.printf("%d\n", e);
		return cache[Step];
	}
}
