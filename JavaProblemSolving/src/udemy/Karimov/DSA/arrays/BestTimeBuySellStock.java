package udemy.Karimov.DSA.arrays;

/*Best Time to Buy and Sell Stock - LeetCode 121
You are given an array prices where prices[i] is the price of a given stock on the ith day. 
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

	Example:
	
	Input: prices = [7, 1, 5, 3, 6, 4] 
	Output: 5 
	Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * 
 */
public class BestTimeBuySellStock {

	public static void main(String[] args) {
		displayProfit();

	}
	
	public static void displayProfit() {
		int[] prices = {7, 1, 5, 3, 6, 4};
		int profit = findBestTime(prices);
		
		System.out.println("Profit: " + profit);
	}
	
	public static int findBestTime(int[] prices) {
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		int maxAfterMin = Integer.MIN_VALUE;
		
		for(int i=0; i < prices.length; i++) {
			if(prices[i] < min) {
				min = prices[i];
				minIndex = i;
			}
			if(i > minIndex) {
				if(prices[i] > maxAfterMin) {
					maxAfterMin = prices[i];
				}
			}
		}
		return maxAfterMin - min;
	}

}
