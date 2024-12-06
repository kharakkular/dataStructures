package main.random;

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] nums) {
		
		int lastIndex = nums.length;
		int index = 0;
		
		int p = index + 1;
		while (p < lastIndex) {
			while (nums[p] == nums[index]) {
				p++;
				if( p >= lastIndex) {
					return index + 1;
				}
			}
			nums[index + 1] = nums[p++];
			index++;
		}
		return index + 1;
	}
}
