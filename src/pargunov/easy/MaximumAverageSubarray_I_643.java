package pargunov.easy;

public class MaximumAverageSubarray_I_643 {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(nums, 4));
    }
    private static double findMaxAverage(int[] nums, int k) {
        double max = 0;

        for (int i = 0; i < k; i++) {
            max += nums[i];
        }

        double currentMax = max;
        for (int i = k; i < nums.length; i++) {
            currentMax -= nums[i - k];
            currentMax += nums[i];
            max = Math.max(max, currentMax);
        }

        return max / k;
    }
}
