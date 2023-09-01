package pargunov.medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray_442 {
    public static void main(String[] args) {

    }

    //Given an integer array nums of length n where all the integers of nums are in the range [1, n]
    // and each integer appears once or twice, return an array of all the integers that appears twice.
    // Runtime Beats 95.29% Memory Beats 42.50%
    private static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            var current = Math.abs(nums[i]);
            if(nums[current - 1] < 0) res.add(current);
            else nums[current - 1] *= -1;
        }

        return res;
    }
}
