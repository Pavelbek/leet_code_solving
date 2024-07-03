package pargunov.easy;

public class NumberOf1Bits_191 {
    // Write a function that takes the binary representation of a positive integer and returns the number of set bits
    // it has (also known as the Hamming weight).
    private static int hammingWeight(int n) {
        int res = 0;

        while(n > 0) {
            int mask = n & 1;
            if(mask == 1) res++;
            n >>= 1;
        }

        return res;
    }
}
