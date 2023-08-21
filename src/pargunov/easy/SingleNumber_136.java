package pargunov.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class SingleNumber_136 {
    public static void main(String[] args) {
        int[] nums1 = {2, 2, 1}; // 1
        int[] nums2 = {4, 1, 2, 1, 2}; // 4
        int[] nums3 = {1}; // 1

        System.out.println(singleNumber3(nums1));
        System.out.println(singleNumber3(nums2));
        System.out.println(singleNumber3(nums3));
    }

    private static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.stream(nums)
                .forEach(e -> {
                    map.compute(e, (k, v) -> v == null ? 1 : v + 1);
                });
        System.out.println(map);
        return 1;
    }

    // Runtime Beats 9.64% Memory Beats 27.65%
    private static int singleNumber2(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums)
                        .boxed()
                        .collect(groupingBy(Function.identity(), counting()));

        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (entry.getValue() == 1) return Math.toIntExact(entry.getKey());
        }

        return -1;
    }

    // using XOR
    // Runtime Beats 100.00% Memory Beats 27.65%
    private static int singleNumber3(int[] nums) {
        int res = 0;

        for (int num : nums) {
            res ^= num;
        }

        return res;
    }
}
