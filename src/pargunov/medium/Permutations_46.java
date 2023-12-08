package pargunov.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Permutations_46 {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        findAllPermutations(0, nums);
        return result;
    }

    private void findAllPermutations(int i, int[] nums) {
        if(i == nums.length) {
            result.add(IntStream.of(nums).boxed().toList());
            return;
        }

        for(int j = i; j < nums.length; j++) {
            swap(i, j, nums);
            findAllPermutations(i + 1, nums);
            swap(i, j, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        var tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
