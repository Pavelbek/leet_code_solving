package pargunov.medium;

public class Sum_of_Two_Integers_371 {

    private static int getSum(int a, int b) {
        while (b != 0) { // we use b for the carry
            int tmp = (a & b) << 1; // we shift bit to the left as carry will go to the left as 1 & 1 << 1 = 10
            a ^= b; // XOR returns 1 only if only one bit is 1, like: 1 ^ 0 or 0 ^ 1 it can be used to simulate addition
            // 0 + 0 = 0; 1 + 0 = 1; 0 + 1 = 1; 1 + 1 = 0 - or 2 in binary 10 so we put 0 and carry the 1
            b = tmp; // we have carry only in one case when both bits are 1s 1 & 1  so AND here is perfect
        }

        return a;
    }
}
