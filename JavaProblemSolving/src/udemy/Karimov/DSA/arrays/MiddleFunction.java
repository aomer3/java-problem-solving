package udemy.Karimov.DSA.arrays;

import java.util.Arrays;

/*
 * Write a function called middle that takes an array and returns a new array 
 * that contains all but the first and last elements.
	
	myArray = [1, 2, 3, 4]
	middle(myArray)  # [2,3]. 

 */
public class MiddleFunction {

	public static void main(String[] args) {
		displayMiddleElements();
		
	}
	
	public static void displayMiddleElements() {
		int[] result = {1,2,3,4};
		
		result = getMiddleElements(result);
		
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] getMiddleElements(int[] array) {
		int[] newArray = new int[array.length-2];
		int counter=0;
		
		for(int i=0; i < array.length; i++) {
			if(i != 0 && i != (array.length-1)) {
				newArray[counter] = array[i];
				counter++;
			}
		}
		
		return newArray;
	}

}
