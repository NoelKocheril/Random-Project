package practice;

import java.util.concurrent.ThreadLocalRandom;

public class MergeSort {
	/**
	 * Merge Left and Right of an Array
	 * @param arr Array to Merge
	 * @param l Left Index
	 * @param m Middle Index
	 * @param r Right Index
	 */
	public void merge(int arr[], int l, int m, int r) {
		int i,j,k;
		
		//Get Size of Left and Right Array
		int n1 = m-l+1;
		int n2 = r-m;
		
		
		//Make Left and Right Size Array
		int L[] = new int [n1];
		int R[] = new int [n2];
		
		//Initialize Left and Right Array with Values from arr
		for(i = 0; i<n1; ++i) 
			L[i] = arr[l+i];
		for(i = 0; i<n2; ++i) 
			R[i] = arr[m+i+1];
		
		//Merge Arrays
		i=0;j=0;k=l;
		while(i < n1 && j < n2) {
			if(L[i] <=  R[j]){
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		//Add Remaining in L1
		while(i < n1) {
			arr[k] = L[i];
			i++;k++;
		}
		while(j < n2) {
			arr[k] = R[j];
			j++;k++;
		}
	}
	
	/**
	 * Sort an Array
	 * @param arr Array to Sort
	 * @param l Left Index
	 * @param r Right Index
	 */
	public void sort(int arr[], int l, int r) {
		if(l < r) {
			int m = (l+r)/2;
			sort(arr, l, m);
			sort(arr, m+1, r);
			
			merge(arr, l, m, r);
		}
	}
	
	/**
	 * A utility function to print array of size n
	 * @param arr Array to Print
	 */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    public static void main(String args[])
    {
        MergeSort ob = new MergeSort();

        int arr[] = {12, 11, 13, 5, 6, 7};
        int arr1[] = new int[100];
 
        for(int i = 0; i < arr1.length-1;i++)
        	arr1[i] = ThreadLocalRandom.current().nextInt(10000);
        
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        System.out.println("Given Array");
        printArray(arr);
 
        ob.sort(arr, 0, arr.length-1);
 
        System.out.println("\nSorted array");
        printArray(arr);
        
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        
        System.out.println("Given Array");
        printArray(arr1);
 
        ob.sort(arr1, 0, arr1.length-1);
 
        System.out.println("\nSorted array");
        printArray(arr1);
    }
}
