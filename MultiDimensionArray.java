package com.yishu;

public class MultiDimensionArray {
	// This is a provided function, Assume it works
    public static Long getValue(int... indexOfDimension) {
        //... 
        return value;
    }
    // lengthOfDeminsion: each dimension's length, assume it is valid: lengthOfDeminsion[i]>0.
    public static Long sum(MultiDimensionArray mArray, int[] lengthOfDeminsion) { 
   // Your resolution 
   // Time complexity:  
   // Space complexity: 
    	long sum = 0;
    	if (mArray == null || lengthOfDeminsion == null || lengthOfDeminsion.length == 0) {
    		return sum;
    	}
    	int n = lengthOfDeminsion.length;
    	int[] fact = new int[n + 1];
    	fact[0] = 1;
    	for (int i = 1; i <= n; i++) {
    		fact[i] = fact[i - 1] * lengthOfDeminsion[i - 1];
    	}
    	int[] arguments = new int[n];
    	for (int i = 0; i < fact[n]; i++) {
    		int index = i;
    		for (int j = n - 1; j >= 0; j--) {
    			arguments[j] = index / fact[j];
    			index = index % fact[j];
    		}
    		sum += getValue(mArray, arguments);
    	}
    	return sum;
    	
    }
}
//Since this algorithm visits each element once, the time complexity is O(n1 * n2 *...), where
//n1, n2 represents each dimension's length

//Since two arrays are used, the space complexity is O(n), where n is the number of dimensions 
//in the multidimensional array.