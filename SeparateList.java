package com.yishu;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SeparateList {
	public boolean separate(List<Integer> list, int k){
		   // Your resolution 
		   // Time complexity:  k * (n!) where n is the number of elements in the list
		   // Space complexity: generally it should be O(n + k). since k < n, the space complexity is O(n),
		   // where n is the number of length
			if (list == null ||  k <= 0) {
				return false;
			}
			int n = list.size();
			if (k == 1) {
				return true;
			}
			if (n < k) {
				return false;
			}
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += list.get(i);
			}
			if (sum % k != 0) {
				return false;
			}
			sum = sum / k;
			boolean used[] = new boolean[n];
			int[] subLists = new int[k];
			return canPartition(list, subLists, used, sum, n, k, 0);
		}
	//subLists: the sum of each subList
	//used: an array to represent whether we have used this element, if yes, we cannot use it again
	//sum: the sum we want to reach for each subList
	//n: number of elements in the original list
	//k: number of subLists we want to split into
	//subIndex: we are currently hoping to find elements to be categorized into this subList
	public boolean canPartition(List<Integer> list, int[] subLists, boolean[] used, int sum,
			int n, int k, int subIndex) {
		if (subLists[subIndex] == sum) {
			if (subIndex == k - 2) {
				return true;
			}
			return canPartition(list, subLists, used, sum, n, k, subIndex + 1);			
		}
		for (int i = 0; i < n; i++) {
			if (used[i] == true) {
				continue;
			}
			int tempSum = subLists[subIndex] + list.get(i);
			if (tempSum <= sum) {
				subLists[subIndex] = tempSum;
				used[i] = true;
				boolean find = canPartition(list, subLists, used, sum, n, k, subIndex);
				if (find) {
					return true;
				}
				used[i] = false;
				subLists[subIndex] -= list.get(i);
			}
		}
		return false;
	}
		  // JUnit test cases
	@Test
	public void test() {
		SeparateList test = new SeparateList();	
		List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 11);		
		assertEquals(true, test.separate(input, 1));
		assertEquals(true, test.separate(input, 2));
		assertEquals(true, test.separate(input, 3));
		assertEquals(true, test.separate(input, 4));
		assertEquals(false, test.separate(input, 5));
		assertEquals(true, test.separate(input, 6));
		assertEquals(false, test.separate(input, 7));
		
	}
	
}
