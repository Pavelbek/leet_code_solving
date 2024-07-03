package pargunov.medium;

public class MaximumProductSubarray_152 {
    // Given an integer array nums, find a subarray
    // that has the largest product, and return the product.
    // The test cases are generated so that the answer will fit in a 32-bit integer.
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int leftMax = 1;
        int rightMax = 1;

        for(int i = 0; i < nums.length; i++) {
            if(leftMax == 0) leftMax = 1;
            if(rightMax == 0) rightMax = 1;
            leftMax *= nums[i];
            rightMax *= nums[nums.length - i - 1];
            max = Math.max(max, Math.max(leftMax, rightMax));
        }

        return max;
    }
}
