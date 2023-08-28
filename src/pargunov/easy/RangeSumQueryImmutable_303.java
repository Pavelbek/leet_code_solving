package pargunov.easy;

public class RangeSumQueryImmutable_303 {
    public static void main(String[] args) {
        int[] arr1 = {-2, 0, 3, -5, 2, -1};

        var numArray = new NumArray(arr1);

        System.out.println(numArray.sumRange2(0, 2)); // return (-2) + 0 + 3 = 1
        System.out.println(numArray.sumRange2(2, 5)); // return 3 + (-5) + 2 + (-1) = -1
        System.out.println(numArray.sumRange2(0, 5)); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
    }
}

class NumArray {

    private final int[] nums;
    private final int[] sums;
    public NumArray(int[] nums) {
        this.nums = nums;
        this.sums = new int[nums.length];
        calculateAllSums();
    }

    // best solution is to calculate all sums one and just return answer once
    private void calculateAllSums() {
        var currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            sums[i] = currentSum;
        }
    }


    // better solution as we have prepared sums: Runtime Beats 90.20% Memory Beats 8.09%
    public int sumRange2(int left, int right) {
        return left == 0 ? sums[right] : sums[right] - sums[left - 1];
    }

    // Runtime Beats 34.05% Memory Beats 43.71% - IT'S EXPENSIVE TO DO SUM CALCULATION EVERY TIME HERE
    public int sumRange(int left, int right) {
        var sum = 0;

        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }

        return sum;
    }
}
