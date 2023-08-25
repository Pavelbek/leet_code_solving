package pargunov.medium;

public class MaximumSubarray_53 {
    public static void main(String[] args) {

        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // 6

        System.out.println(maxSubArray(arr1));
    }

    // Runtime Beats 100.00% Memory Beats 53.11%
    private static int maxSubArray(int[] nums) {
        var maxSum = nums[0];
        var currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            var currentNum = nums[i];
           if (currentNum > currentNum + currentSum) { // can replace it with: Math.max(currentNum, currentNum + currentSum);
               currentSum = currentNum;
           } else {
               currentSum = currentNum + currentSum;
           }
           if (currentSum > maxSum) maxSum = currentSum; // can replace with Math.max(currentSum, maxSum);
        }

        return maxSum;
    }
}
