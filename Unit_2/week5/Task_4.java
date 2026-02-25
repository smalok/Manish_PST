class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxKadane = Integer.MIN_VALUE;
        int minKadane = Integer.MAX_VALUE;
        
        int currentMax = 0;
        int currentMin = 0;
        
        for (int x : nums) {
            totalSum += x;
            
            // Standard Kadane to find the maximum linear subarray
            currentMax += x;
            maxKadane = Math.max(maxKadane, currentMax);
            if (currentMax < 0) currentMax = 0;
            
            // Standard Kadane to find the minimum linear subarray
            currentMin += x;
            minKadane = Math.min(minKadane, currentMin);
            if (currentMin > 0) currentMin = 0;
        }
        
        // If all numbers are negative, maxKadane will be the largest single element.
        // totalSum == minKadane means the entire array was the "minimum subarray".
        if (totalSum == minKadane) {
            return maxKadane;
        }
        
        // Return the better of the linear sum or the circular wrap-around sum
        return Math.max(maxKadane, totalSum - minKadane);
    }
}
