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

//	2. map
	public static int subarraySum_map(int[] nums, int k) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;

		// 2
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];// sum = sum +nums[i]
			System.out.println(sum+"sum");
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}

			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return count;
	}

}
