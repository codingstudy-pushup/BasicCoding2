package Map;

import java.util.*;

public class MapTest02 {

	public static void main(String[] args) {

		int[] nums = {1,1,2,2,2,3,5,5,5,5};
		int k = 2;
		System.out.println(new MapTest02().topKFrequent(nums, k));		
		
	}

	public List<Integer> topFrequent(int[] nums, int k) {
		Map<Integer, Integer> hm = new HashMap<>();
		List<Integer>[] list = new List[nums.length + 1];
		List<Integer> res = new ArrayList<>();

		for (int num : nums) {
			hm.put(num, hm.getOrDefault(num, 0) + 1);
		}
		for (int key : hm.keySet()) {
			int topFrequent = hm.get(key);
			if (list[topFrequent] == null)
				list[topFrequent] = new ArrayList<>();
			list[topFrequent].add(key);
		}
		
		//
		for (int lastIndex = list.length - 1; lastIndex >= 0; lastIndex--) {
			if (list[lastIndex] != null) {
				for (int i = 0; i < list[lastIndex].size() && res.size() < k; i++)
					res.add(list[lastIndex].get(i));
			}
		}
		return res;
	}
}
