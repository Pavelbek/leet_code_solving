package pargunov.medium;

import java.util.HashMap;

public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {
        var exploreMap = new HashMap<Integer, Boolean>();
        var longetSequence = 0;

        for(int num : nums) {
            exploreMap.put(num, false);
        }


        for(var num : nums) {
            var currentSequence = 1;

            var nextNum = num + 1;
            while(exploreMap.containsKey(nextNum) && !exploreMap.get(nextNum))  {
                currentSequence++;
                exploreMap.put(nextNum, true);
                nextNum++;
            }

            var prevNum = num - 1;
            while(exploreMap.containsKey(prevNum) && !exploreMap.get(prevNum)) {
                currentSequence++;
                exploreMap.put(prevNum, true);
                prevNum--;
            }

            longetSequence = Math.max(longetSequence, currentSequence);
        }

        return longetSequence;
    }
}
