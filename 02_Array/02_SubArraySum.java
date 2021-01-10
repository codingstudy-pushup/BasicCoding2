package Array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

	public static void main(String[] args) {
		int[] nums = { 3, 4, 7, 2, -3, 1, 4, 2 };
		int k = 7;
		System.out.println(subarraySum(nums, k));
//		System.out.println(subarraySum_map(nums, k));

	}

//  1. 이중 for
	public static int subarraySum(int[] nums, int k) {
		int count = 0;

		for(int i=0; i<nums.length; i++) {
			int sum =0;
			for(int j=i; j<nums.length;j++) {
				sum = sum +nums[j];
	
				if(sum==k) {
					System.out.println("sum "+sum+" nums["+j+"]"+nums[j]);
					count++;
				}
			}
		}
		
		
		
		return count;
	}

}
