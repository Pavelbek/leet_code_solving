package pargunov.easy;

public class Sqrt_x_69 {
    public static void main(String[] args) {
        int i = 5;
        System.out.println(i ^= 4);
    }

    private static int mySqrt(int x) {
        long l = 0;
        long r = x;
        long res = 0;

        while(l <= r) {
            long m = l + (r - l) / 2;
            if(m * m > x) {
                r = m - 1;
            } else if(m * m < x) {
                l = m + 1;
                res = m;
            } else {
                return (int) m;
            }
        }

        return (int) res;
    }
}
