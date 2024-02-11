package pargunov.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortAnArray_912 {
    public static void main(String[] args) {
    }
    // merge sort n lon(n)
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int[] mergeSort(int[] arr, int left, int right) {
        if(left == right) return arr;
        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);

        return arr;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        for(int i = 0; i < leftSize; i++) {
            leftArr[i] = nums[left + i];
        }

        for(int i = 0; i < rightSize; i++) {
            rightArr[i] = nums[mid + i + 1];
        }

        int i = 0;
        int j = 0;
        while(i < leftSize && j < rightSize) {
            if(leftArr[i] <= rightArr[j]) {
                nums[left] = leftArr[i];
                i++;
            } else {
                nums[left] = rightArr[j];
                j++;
            }
            left++;
        }

        while(i < leftSize) {
            nums[left++] =  leftArr[i++];
        }

        while(j < rightSize) {
            nums[left++] =  rightArr[j++];
        }
    }
}
