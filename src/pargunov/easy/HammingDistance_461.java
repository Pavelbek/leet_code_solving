package pargunov.easy;

public class HammingDistance_461 {
    public static void main(String[] args) {
        byte five = 0b100;
        System.out.println(Integer.toBinaryString(five & 1));
    }

    // & 1 it is kind of bitmask it gives us: 00000001 -> so we compare only first bit from two numbers
    // because & will return zeroes for all others in case of this comparing, example:
//    6 -> 00000000000000000000000000000110
//         &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
//    1 -> 00000000000000000000000000000001
// res     00000000000000000000000000000000
//    0 and 0 -> 0 ; 1 & 1 = 1;
//    so if we want to check bit by bit if numbers are different we check if last bits are both 1 and after make shift
//    by 1 bit to right to check next last bits.
    // 00010 representation after right shift by 1 bit will be >> 0001
    // so we compare bit by bit shifting each time to right by 1 bit
    // 6 & 1 = will return 0 or 1
    private static int hammingDistance(int x, int y) {
        int ans = 0;
        while(x > 0 || y > 0) {
            int mask1 = x & 1;
            int mask2 = y & 1;
            if(mask1 != mask2) {
                ans++;
            }
            x >>= 1;
            y >>= 1;
        }
        return ans;
    }
}
