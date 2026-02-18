class Task_6 {
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;

        // Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt] = nums[i];
                lastNonZeroFoundAt++;
            }
        }

        // Fill the rest of the array with zeros
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
