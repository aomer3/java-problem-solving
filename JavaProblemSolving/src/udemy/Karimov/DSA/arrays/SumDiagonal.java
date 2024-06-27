package udemy.Karimov.DSA.arrays;

import java.util.Arrays;
import java.util.Iterator;

/*Given 2D array calculate the sum of diagonal elements.

	Example
	
	myArray2D= {{1,2,3},{4,5,6},{7,8,9}};
	 
	sumDiagonalElements(myArray2D) # 15
 * 
 */
public class SumDiagonal {

	public static void main(String[] args) {
		displaySumDiagnol();

	}
	
	public static void displaySumDiagnol() {
		int result = calculateDiagnol();
		
		System.out.println(result);
		
	}
	
	public static int calculateDiagnol(){
		int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
		int sum=0;
		
		for (int i = 0; i < array.length; i++) {
			sum += array[i][i];
		}
		
		return sum;
	}

}
