package main.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

	public static int removeDuplicatesMedium(int[] nums) {
		int index = 0;
		int p = index + 1;
		while (p < nums.length) {
			int count = 1;
			while (p < nums.length && nums[index] == nums[p]) {
				p++;
				count++;
				if(count == 2) {
					nums[++index] = nums[p-1];
				}
			}
			if(p < nums.length) {
				nums[++index] = nums[p++];
			}
		}
		return index + 1;
			// count = count > allowedCount ? allowedCount: count;
			// if(count >= allowedCount) {
			// } else {
			// 	nums[++index] = nums[p++];
			// }
		// }
		// 	while(nums[index] == nums[p]) {
		// 		count = count + 1;
		// 		p++;
		// 		if(p >= nums.length) {
		// 			count = count > allowedCount ? allowedCount: count;
		// 			// index += count--;
		// 			for (int i = 1; i < count; i++) {
		// 				index += i;
		// 				nums[index] = nums[p-1];
		// 			}
		// 			// while (count > 0) {
		// 			// 	nums[index - count--] = nums[p - 1];
		// 			// }
		// 			return index;
		// 		}
		// 	}
		// 	if(count > allowedCount) {
		// 		nums[index + allowedCount] = nums[p++];
		// 		index += allowedCount;
		// 	} else {
		// 		for (int i = 1; i < count; i++) {
		// 			index += i;
		// 			nums[index] = nums[p];
		// 		}
		// 		// nums[index+count] = nums[p++];
		// 		p++;
		// 		// index += count;
		// 	}
		// }
		// return index + 1;
	}

	public static void rotate(int[] nums, int k) {
		if (nums.length > 1)
			return;
		k = k % nums.length;
		int length = nums.length;
		List<Integer> list = new ArrayList<Integer>();
		if (k > 0) {
			for (int i = 0; i < nums.length; i++) {
				list.add(i + k >= length ? i + k - length : i + k, nums[i]);
				// temp[i + k >= length ? i + k - length : i + k] = nums[i];
			}
	
		}

		// int[] temp = new int[nums.length];
		// int length = nums.length;
		// if(k > 0) {
		// for (int i = 0; i < nums.length; i++) {
		// temp[i+k >= length ? i + k - length: i + k] = nums[i];
		// }
		// System.arraycopy(temp, 0, nums, 0, nums.length);
		// }
	}


	public static int lengthOfLastWord(String s) {

		String[] words = s.trim().split(" ");

		return words[words.length - 1].length();
	}

	public static boolean canJump(int[] nums) {
		int maxJump = 0;
		int stepsCount = 0;
		while (stepsCount < nums.length - 1) {
			int currentJump = (stepsCount) + nums[stepsCount];

			maxJump = maxJump > currentJump ? maxJump : currentJump;
			if(maxJump <= stepsCount) {
				return false;
			}
			stepsCount++;
		}

		return true;
	}

	public static int jump(int[] nums) {
		int nearJump = 0;
		int farJump = 0;
		int jump = 0;
		while (farJump < nums.length - 1) {
			int farthest = 0;
			for (int i = nearJump; i <= farJump ; i++) {
				farthest = Math.max(farthest, i + nums[i]);
			}
			nearJump = farJump + 1;
			farJump = farthest;
			jump++;
		}
		return jump;
	}

	public static int divide(int dividend, int divisor) {
        
		if(dividend <= Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}

		if(dividend <= Integer.MIN_VALUE && divisor == 1) {
			return Integer.MIN_VALUE;
		}

		if(dividend >= Integer.MAX_VALUE && divisor == 1) {
			return Integer.MAX_VALUE;
		}


		boolean isNegative = dividend < 0 ^ divisor < 0;

		// absolute values in long variables
		long absDividend = Math.abs((long) dividend);
		long absDivisor = Math.abs((long) divisor);
		int count = 0;
		while (absDividend >= absDivisor) {
			int power = 1;
			while (Math.pow(absDivisor, power) < absDividend) {
				if(Math.pow(absDivisor, power + 1) > absDividend) {
					break;
				}
				power++;
			}
			absDividend -= Math.pow(absDivisor, power);

			count = count + (int) Math.pow(absDivisor, power - 1);
		}

		return isNegative ? Math.negateExact(count) : count;
    }
}
