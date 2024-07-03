package pargunov.easy;

import java.util.Arrays;

public class CountingBits_338 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits2(2)));
    }

    private static int[] countBits(int n) {
        int[] res = new int[n + 1];

        for(int i = 1; i < n + 1; i++) {
            res[i] = res[i >> 1] + i % 2;
        }

        return res;
    }

    private static int[] countBits2(int n) {
        int[] bits = new int[n + 1];
        for(int i = 1; i <= n; i++){
            bits[i] = bits[i / 2] + i % 2 ;
        }
        return bits;
    }

    public int[] countBits3(int n) {
        int[] res = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            res[i] = res[i >> 1] + (i & 1); // (i & 1) - in braces because + has bigger priority and without () we will add and only after apply &
        }

        return res;
    }
}
