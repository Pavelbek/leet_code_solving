package pargunov.easy;

import java.util.*;

public class FindAllNumbersDisappearedInArray_448 {

    public static void main(String[] args) {
        int[] arr1 = {4,3,2,7,8,2,3,1}; // 5, 6
        int[] arr2 = {1,1}; // 2

        System.out.println(findDisappearedNumbers2(arr1));
    }

    // 448. Find All Numbers Disappeared in an Array
    // Attempt 1: Runtime Beats 30.76% Memory Beats 13.92%
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> unique = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            unique.add(nums[i]);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!unique.contains(i)) res.add(i);
        }

        return res;
    }

    // 448. Find All Numbers Disappeared in an Array
    // Attempt 2: cyclic sorting algorithm: Runtime Beats 89.40% Memory Beats 98.18%
    // we are swapping elements until they are in right place
    // and when some element is not in order it means it is duplicate and think about it
    // like we mark lost element this way
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> res = new ArrayList<>();

        //sort
        int i = 0;
        while (i < nums.length) {
            var expectedPos = nums[i] - 1;
            if (nums[i] != nums[expectedPos]) {
                var tmp = nums[i];
                nums[i] = nums[expectedPos];
                nums[expectedPos] = tmp;
            } else {
                i++;
            }
        }

        for (int j  = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) res.add(j + 1);
        }

        return res;
    }
}
