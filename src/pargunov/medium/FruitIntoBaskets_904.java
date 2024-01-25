package pargunov.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FruitIntoBaskets_904 {
    public static void main(String[] args) {
    }

    public int totalFruit(int[] fruits) {
        int res = 0;
        int start = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for(int end = 0; end < fruits.length; end++) {
            int current = fruits[end];
            count.compute(current, (k, v) -> v == null ? 1 : v + 1);

            while(count.keySet().size() > 2) {
                if(count.get(fruits[start]) == 1) {
                    count.remove(fruits[start]);
                } else {
                    count.compute(fruits[start], (k, v) -> v - 1);
                }
                start++;
            }

            res = Math.max(res, end - start + 1);
        }

        return res;
    }
}
