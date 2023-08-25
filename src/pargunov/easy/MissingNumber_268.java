package pargunov.easy;

import java.util.stream.IntStream;

public class MissingNumber_268 {
    //Given an array nums containing n distinct numbers in the range [0, n],
    // return the only number in the range that is missing from the array.
    public static void main(String[] args) {

    }

    // Runtime Beats 29.33% Memory Beats 77.46%
    private static int missingNumber(int[] nums) {
        var n = nums.length;
        var sum = IntStream.of(nums).sum();
        return n * (1 + n) / 2 - sum;
    }
}
