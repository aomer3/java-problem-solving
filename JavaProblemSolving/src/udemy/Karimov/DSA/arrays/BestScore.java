package udemy.Karimov.DSA.arrays;

import java.util.Arrays;


/*Given an array, write a function to get first, second best scores from the array and return it in new array.

	Array may contain duplicates.
	
	Example
	
	myArray = {84,85,86,87,85,90,85,83,23,45,84,1,2,0}
	firstSecond(myArray) // {90, 87}
 * 
 */
public class BestScore {

	public static void main(String[] args) {
		displayBestScore();

	}
	
	public static void displayBestScore() {
		int[] result = calculateBestScore();
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] calculateBestScore() {
		int[] array = {84,85,86,87,85,90,85,83,23,45,84,1,2,0};
		int[] newArray = new int[2];
		int max=0;
		int second=0;
		
		for(int i=0; i < array.length; i++) {
			
			if(array[i] > max) {
				max = array[i];
				newArray[0] = max;
			}
		}
		
		for(int i=0; i < array.length; i++) {
			
			if(array[i] > second && array[i] < max) {
				second = array[i];
				newArray[1] = second;
			}
		}
		
		return newArray;
	}

}
