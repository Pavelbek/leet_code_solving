package pargunov.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LongestIncreasingSubsequence_300 {

    // perfect explanation on Nikhil Lohia channel https://youtu.be/Xq3hlMvhrkE?si=DcsmQWh5ID-l8CTN
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return IntStream.of(dp).max().getAsInt() + 1;
    }

    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for(int i = nums.length - 1; i >= 0; i--) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return IntStream.of(dp).max().getAsInt();
    }
}
