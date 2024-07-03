package pargunov.medium;

public class FindMinimumInRotatedSortedArray_153 {
    public int findMin(int[] nums) {
        int min = nums[0];
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            if(nums[l] < nums[r]) {
                min = Math.min(min, nums[l]);
                break;
            }
            int m = l + (r - l) / 2;
            min = Math.min(min, nums[m]);
            if(nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return min;
    }

    public int findMin2(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = nums[l];

        while (l <= r) {
            int m = l + (r - l) / 2;
            min = Math.min(min, nums[m]);

            if(nums[m] < nums[r]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return min;
    }
}
