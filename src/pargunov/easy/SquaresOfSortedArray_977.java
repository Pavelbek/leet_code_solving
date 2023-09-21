package pargunov.easy;

public class SquaresOfSortedArray_977 {
    private static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        int l = 0;
        int r = nums.length - 1;

        for(int i = nums.length - 1; i >= 0; i--) {
            if(Math.abs(nums[r]) > Math.abs(nums[l])) {
                res[i] = (int) Math.pow(nums[r], 2);
                r--;
            } else {
                res[i] = (int) Math.pow(nums[l], 2);
                l++;
            }
        }

        return res;
    }
}
