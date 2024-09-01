package pargunov.medium;

public class Jump_Game_55 {
    public boolean canJump(int[] nums) {
        int finalPosIdx = nums.length - 1;

        for(int idx = nums.length - 2; idx >= 0; idx--) {
            if(idx + nums[idx] >= finalPosIdx) finalPosIdx = idx;
        }

        return finalPosIdx == 0;
    }
}
