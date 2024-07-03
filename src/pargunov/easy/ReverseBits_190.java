package pargunov.easy;

public class ReverseBits_190 {
    // you need treat n as an unsigned value
    private static int reverseBits(int n) {
        int res = 0;

        for(int i = 0; i < 32; i++) {
            res += (n & 1) << (31 - i); // we can use |= (OR equal) here because for 1 it will add 1 for 0 it will add zero in correctly shifted position
            n >>= 1;
        }

        return res;
    }
}
