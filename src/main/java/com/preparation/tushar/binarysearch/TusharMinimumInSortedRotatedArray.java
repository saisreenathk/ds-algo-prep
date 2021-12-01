package com.preparation.tushar.binarysearch;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class TusharMinimumInSortedRotatedArray {
	public static void main(String[] args) {
		TusharMinimumInSortedRotatedArray m = new TusharMinimumInSortedRotatedArray();
		int[] nums = { 3, 4, 5, 1, 2 };
		System.out.println(m.findMin(nums));
	}

	public int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			int middle = (low + high) / 2;
			if ((middle == 0 && nums[middle] < nums[middle + 1]) || (middle > 0 && nums[middle] < nums[middle - 1])) {
				return nums[middle];
			} else if (nums[middle] > nums[high]) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		return nums[low];
	}
}
