package pargunov.medium;

import java.util.*;

public class The3Sum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return new ArrayList();
        Set<List<Integer>> triplets = new HashSet<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if(currentSum == 0) {
                    triplets.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if(currentSum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return new ArrayList<>(triplets);
    }
}
