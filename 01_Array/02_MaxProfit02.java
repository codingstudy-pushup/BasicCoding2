package Array;

public class MaxProfit02 {

	public static void main(String[] args) {
//		int[] nums = { 7, 1, 5, 3, 6, 4 };
		int[] nums = { 8, 2, 6, 5, 1, 7, 5 };
		System.out.println(maxProfit01(nums));
		System.out.println(maxProfit02(nums));
	}
	
	 public static int maxProfit01(int[] prices) {
	        if(prices == null || prices.length < 2) return 0;
	        int profit = 0;
	        for(int i = 1; i < prices.length; i++){
	            if(prices[i-1] < prices[i]){
	                profit += prices[i] - prices[i-1];
	            }
	        }
	        return profit;
	    }

	public static int maxProfit02(int[] prices) {
		int profit = 0;
		for (int i = 1; i < prices.length; i++)
			profit += Math.max(0, prices[i] - prices[i - 1]);
		return profit;
	}
	
	

}
