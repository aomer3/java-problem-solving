package udemy.Karimov.DSA.arrays;

import java.util.Arrays;

/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target. 
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.

	Examples
	
	Input: nums = [2,7,11,15], target = 9
	Output: [0,1]
	Output: Because nums[0] + nums[1] == 9, we return [0, 1]
	
	
	Input: nums = [3,2,4], target = 6
	Output: [1,2]
 * 
 */
public class TwoSum {

	public static void main(String[] args) {
		displayIndices();

	}
	
	public static void displayIndices() {
		int[] array = {2,7,11,15};
		int target = 9;
		int[] indices = findIndices(array, target);
		
		System.out.println("Indices: " + Arrays.toString(indices));
	}

	public static int[] findIndices(int[] array, int target) {
		int[] indices = new int[2];
		
		for(int i=0; i < array.length; i++) {
			for(int j=0; j < array.length; j++) {
				if(array[i] != array[j] && (array[i] + array[j] == target)) {
					indices[0] = array[i];
					indices[1] = array[j];
				}
			}
		}
		
		return indices;
	}
}
