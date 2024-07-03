package pargunov.medium;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement_1838 {
    public int maxFrequency(int[] nums, int k) {
        int maxFrequency = 0;
        long currentSum = 0;
        int left = 0;

        Arrays.sort(nums);

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum + k < (long) nums[right] * (right - left + 1)) {
                currentSum -= nums[left];
                left++;
            }

            maxFrequency = Math.max(maxFrequency, right - left + 1);
        }

        return maxFrequency;
    }
}
