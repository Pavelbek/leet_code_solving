package pargunov.easy;

public class SearchInsertPosition_35 {

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,6};
        System.out.println(searchInsert(arr1, 5));
    }

    private static int searchInsert(int[] nums, int target) {
        var l = 0;
        var r = nums.length - 1;

        while(l <= r) {
            var mid = l + (r - l) / 2;
            if(target == nums[mid]) return mid;
            if(nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if(l + 1 == r && nums[l] > target) {
            return l + 1;
        } else {
            return l - 1;
        }
    }
}
