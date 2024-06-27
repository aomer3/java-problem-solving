package udemy.Karimov.DSA.arrays;

import java.util.Arrays;

/*Write a function which takes integer array as a parameter and returns 
 * a new integer array with unique elements. (remove duplicates)

	Example
	
	removeDuplicates({1, 1, 2, 2, 3, 4, 5})
	Output : [1, 2, 3, 4, 5]
 * 
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		displayRemoveDuplicates();

	}
	
	public static void displayRemoveDuplicates() {
		int[] numbers = {1, 1, 2, 2 , 3, 4, 5};
		int[] result = removeDuplicates(numbers);
		
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] removeDuplicates(int[] array) {
		int[] newArray = new int[array.length];
		int j=0;
		
		for (int i = 0; i < array.length-1; i++) {	
			if(array[i] != array[i+1]) {
				newArray[j++] = array[i];
			}
			
		}
		
		newArray[j++] = array[array.length-1];
		
		//Removes zeros and resizes array
		int[] result = removeZeros(newArray);
				
		return result;
	}
	
	public static int[] removeZeros(int[] newArray) {
		int count=0;
		for(int num: newArray) {
			if(num == 0) {
				count++;
			}
		}
		
		int result[] = new int[newArray.length - count];
		int index=0;
		
		for(int i=0; i < newArray.length; i++) {
			if(newArray[i] != 0) {
				result[index] = newArray[i];
				index++;
			}
		}
		
		return result;
	}

}
