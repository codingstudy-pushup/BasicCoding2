
package ama001;

public class A055_BestTimeToBuyandSellStock {

	public static void main(String[] args) {
		int[] prices = {8,2,6,4,7,9};
		System.out.println(maxProfit(prices));
	}
	public static int maxProfit(int[] prices) {
		 if (prices.length == 0) {
			 return 0 ;
		 }		
		 int max = 0 ;
		 int sofarMin = prices[0] ;
	     for (int i = 0 ; i < prices.length ; ++i) {
	    	 if (prices[i] > sofarMin) {
	    		 max = Math.max(max, prices[i] - sofarMin) ;
	    	 } else{
	    		sofarMin = prices[i];  
	    	 }
	     }	     
	    return  max ;
	 }
}
