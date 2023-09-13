package pargunov.easy;

import java.util.HashMap;
import java.util.Map;

public class BinarySearch_704 {
    public static void main(String[] args) {
        int[] arr1 = { -1, 0, 3, 5, 9, 12 }; // target 9 output 4
        int[] arr2 = { -1, 0, 3, 5, 9, 12 }; // target 2 output -1
        int[] arr3 = { 5 }; // target 5 output 0

        System.out.println(search(arr1, 9));
        System.out.println(search(arr2, 2));
        System.out.println(search(arr3, 5));
    }

    // Runtime Beats 100% Memory Beats 28.43%
    private static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(target == nums[mid]) return mid;

            if (target < nums[mid]) {
                end = mid - 1;
            }

            if (target > nums[mid]) {
                start = mid + 1;
            }
        }

        return -1;
    }
}
