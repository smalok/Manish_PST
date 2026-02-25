public class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize with the first element of the array
        int maxSoFar = nums[0];
        int currentSum = nums[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Choice: Extend the existing subarray or start a new one at nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update the global maximum encountered so far
            maxSoFar = Math.max(maxSoFar, currentSum);
        }

        return maxSoFar;
    }
}
