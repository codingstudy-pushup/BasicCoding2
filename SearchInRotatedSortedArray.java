package ama02;

public class A059_SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;
		System.out.println(search(nums, target));
	}


	public int search_1(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target)
				return mid;

			if (nums[start] <= nums[mid]) {
				if (target < nums[mid] && target >= nums[start])
					end = mid - 1;
				else
					start = mid + 1;
			}

			if (nums[mid] <= nums[end]) {
				if (target > nums[mid] && target <= nums[end])
					start = mid + 1;
				else
					end = mid - 1;
			}
		}
		return -1;
	}

	// 1. recursive
	public static int search(int[] nums, int target) {
		return binarySearch(nums, 0, nums.length - 1, target);
	}

	public static int binarySearch(int[] nums, int left, int right, int target) {
		if (left > right)
			return -1;

		int mid = left + (right - left) / 2;

		if (target == nums[mid])
			return mid;

		if (nums[left] <= nums[mid]) {
			if (nums[left] <= target && target < nums[mid]) {
				return binarySearch(nums, left, mid - 1, target);
			} else {
				return binarySearch(nums, mid + 1, right, target);
			}
		} else {
			if (nums[mid] < target && target <= nums[right]) {
				return binarySearch(nums, mid + 1, right, target);
			} else {
				return binarySearch(nums, left, mid - 1, target);
			}
		}
	}
	

	public int search11(int[] nums, int target) {
		int start = 0, end = nums.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] >= nums[start]) {
				if (target >= nums[start] && target < nums[mid])
					end = mid - 1;
				else
					start = mid + 1;
			} else {
				if (target <= nums[end] && target > nums[mid])
					start = mid + 1;
				else
					end = mid - 1;
			}
		}
		return -1;
	}
}
