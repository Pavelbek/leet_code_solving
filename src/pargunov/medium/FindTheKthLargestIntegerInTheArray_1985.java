package pargunov.medium;

import java.math.BigInteger;
import java.util.PriorityQueue;

public class FindTheKthLargestIntegerInTheArray_1985 {

    // k log n time complexity space O(k);
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<BigInteger> minHean = new PriorityQueue();

        for(String s : nums) {
            minHean.offer(new BigInteger(s));
            if(minHean.size() > k) {
                minHean.poll();
            }
        }

        return minHean.poll().toString();
    }
}
