package pargunov.easy;

public class MajorityElement_169 {
    private int majorityElement(int[] nums) {
        int res = 0;
        int vote = 0;

        for(int num : nums) {
            if(vote == 0) {
                res = num;
            }
            if(num == res) {
                vote++;
            } else {
                vote--;
            }
        }

        return res;
    }
}
