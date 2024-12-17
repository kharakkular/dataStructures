package main.random;

import java.util.HashMap;

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

	public int maxProfit(int[] prices) {
		int maxP = 0;
		int minPrice = Integer.MAX_VALUE;
		if(prices.length <= 1) {
			return maxP;
		}
		
		for (int i = 0; i < prices.length; i++) {
			if(prices[i] < minPrice) {
				minPrice = prices[i];
			} else if (prices[i] - minPrice > maxP) {
				maxP = prices[i] - minPrice;
			}
		}
		return maxP;	
	}

	public int romanToInt(String s) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);
		int sum = 0;
		for(int i=0; i< s.length(); i++) {
			if(i < s.length()-1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
				sum -= map.get(s.charAt(i));
			} else {
				sum += map.get(s.charAt(i));
			}
		}
		return sum;
	}
}
