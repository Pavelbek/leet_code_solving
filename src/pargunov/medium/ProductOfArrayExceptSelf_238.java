package pargunov.medium;

public class ProductOfArrayExceptSelf_238 {
    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;

        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int product = 1;
        for(int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * product;
            product *= nums[i];
        }

        return res;
    }
}
