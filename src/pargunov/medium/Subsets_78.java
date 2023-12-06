package pargunov.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    List<List<Integer>> result;
    private List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        dfs(0, nums, new ArrayList<Integer>());
        return result;
    }

    private void dfs(int i, int[] nums, List<Integer> container) {
        if(i == nums.length) {
            result.add(new ArrayList<>(container));
            return;
        }

        dfs(i + 1, nums, container);

        container.add(nums[i]);
        dfs(i + 1, nums, container);
        container.remove(container.size() - 1);
    }
}
