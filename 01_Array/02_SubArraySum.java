package Array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

	public static void main(String[] args) {
		int[] nums = { 3, 4, 7, 2, -3, 1, 4, 2 };
		int k = 7;
		System.out.println(subarraySum(nums, k));
		System.out.println(subarraySum2(nums, k));
	}
//방법1
// Time complexity : O(n^2)
// Space complexity : O(1)
	public static int subarraySum2(int[] nums, int k) {
		int count = 0;
		for (int start = 0; start < nums.length; start++) {
			int sum = 0;
			for (int end = start; end < nums.length; end++) {
				System.out.println("00start: " + start + " end: " + end + " sum: " + sum);
				sum += nums[end];
				if (sum == k) {
					System.out.println("start: " + start + " end: " + end + " sum: " + sum + " k:" + k);
					count++;
				}
			}
		}
		return count;
	}
	//방법2
// Time complexity : O(n)
// Space complexity : O()
	public static int subarraySum(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		Map<Integer, Integer> map = new HashMap<>();

		map.put(0, 1); //
		int sum = 0;
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				System.out.println("sum-k "+(sum-k));
				count += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return count;
	}

}
