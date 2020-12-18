package Array;

public class MaxProfit01 {

	public static void main(String[] args) {
		int[] prices = { 8, 2, 6, 5, 1, 7, 5 };
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		//1
		int max = 0;
		int sofarMin = prices[0];
		
		//2
		// 8에 샀으면 버린다. 2에 샀으면
		for (int i = 0; i < prices.length; ++i) {
			if (prices[i] < sofarMin) {
				sofarMin = prices[i];
			} else {
				max = Math.max(max, prices[i] - sofarMin);

			}
		}
		return max;
	}
}
