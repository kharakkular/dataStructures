package main.random;

public class UtilityClass {
	
	public int majorityElement(int[] nums) {
		int majorElement = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] == majorElement) {
				count++;
			} else {
				if( count > 0) {
					count--;
				} else {
					majorElement = nums[i];
					count++;
				}
			}
		}
		return majorElement;
	}
}
