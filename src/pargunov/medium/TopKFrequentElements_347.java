package pargunov.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements_347 {
    private static int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] buckets = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            frequencyMap.compute(nums[i], (key, value) -> value == null ? 1 : value + 1);
        }

        for(int key : frequencyMap.keySet()) {
            int requency = frequencyMap.get(key);
            if(buckets[requency] == null) {
                buckets[requency] = new ArrayList<>();
            }
            buckets[requency].add(key);
        }

        int[] res = new int[k];
        int counter = 0;

        for(int j = buckets.length - 1; j >= 0 && counter < k; j--) {
            if(buckets[j] != null) {
                for(Integer num : buckets[j]) {
                    res[counter++] = num;
                }
            }
        }

        return res;
    }
}
