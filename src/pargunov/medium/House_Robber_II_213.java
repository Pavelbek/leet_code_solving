package pargunov.medium;

public class House_Robber_II_213 {
    // Nikhil Lohia https://youtu.be/ucmqYGVGQK8?si=saNd7II_VtePrm9u
    public int rob(int[] nums) {
        if(nums.length < 2) return nums[0];

        int[] skipLastHouse = new int[nums.length - 1];
        int[] skipFirstHouse = new int[nums.length - 1];

        for(int i = 0; i < nums.length - 1; i++) {
            skipLastHouse[i] = nums[i];
            skipFirstHouse[i] = nums[i + 1];
        }

        int maxSkippingLast = robHelper(skipLastHouse);
        int maxSkippingFirst = robHelper(skipFirstHouse);

        return Math.max(maxSkippingLast, maxSkippingFirst);
    }

    private int robHelper(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        for(int num : nums) {
            int tmp = Math.max(num + rob1, rob2);
            rob1 = rob2;
            rob2 = tmp;
        }

        return rob2;
    }
}
