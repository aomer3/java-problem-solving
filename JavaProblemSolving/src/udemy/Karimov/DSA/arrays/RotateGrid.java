package udemy.Karimov.DSA.arrays;
import java.util.*;

//Problem: Given a grid, rotate grid by 90 degrees
public class RotateGrid {
	
	public static void main(String[] args) {
		rotateGrid();
	}

	public static void rotateGrid() {
		//specify size of grid (same length for rows and columns)
		int rows = 3;
		
		int[][] grid = makeGrid(rows);
        int n = grid.length;
        
        displayGrid(grid);
        
        
        System.out.println(" ");
        
        int rotation = 1;
        for(int i=0; i < (n+1)/2; i++){
            for(int j=0; j < (n/2); j++){
                System.out.println("\nRotation: " + rotation++);

                //Swap boxes 
                //temporary = bottom left
                int temp = grid[n - 1 - j][i]; //grid[2][0] save temp = 7
                
                //bottom right to bottom left
                grid[n - 1 - j][i] = grid[n - 1 - i][n - j - 1]; //grid[2][0] = grid[2][2], box 9->7 
                //top right to bottom left
                grid[n - 1 - i][n - j - 1] = grid[j][n - 1 - i]; //grid[2][2] = grid[0][2], box 3->9
                //top left to top right
                grid[j][n - 1 - i] = grid[i][j]; //grid[0][2] = grid[0][0], box 1->3
                //top left to bottom left
                grid[i][j] = temp; //grid[0][0]=grid[2][0], box 7->1
                
                displayGrid(grid);
            }
        }
		
	}
	
	public static int[][] makeGrid(int rows) {
		int[][] grid = new int[rows][rows];
		int count=1;
		for(int i=0; i < rows; i++) {
			for(int j=0; j < rows; j++) {
				grid[i][j] = count;
				count++;
			}
		}
		return grid;
	}
	
	public static void displayGrid(int[][] grid) {
		for(int[] row : grid) {
			System.out.println(Arrays.toString(row));
		}
	}
	
}
