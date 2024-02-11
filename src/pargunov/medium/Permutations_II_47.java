package pargunov.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Permutations_II_47 {
    List<List<Integer>> result;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        backtrack(0, nums);
        return result;
    }

    private void backtrack(int i, int[] nums) {
        if(i == nums.length) {
            result.add(IntStream.of(nums).boxed().toList());
            return;
        }

        Set<Integer> used = new HashSet<>();
        for(int j = i; j < nums.length; j++) {
            if(used.contains(nums[j])) continue;
            used.add(nums[j]);
            swap(i, j, nums);
            backtrack(i + 1, nums);
            swap(i, j, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        var tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
