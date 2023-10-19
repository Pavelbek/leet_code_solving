package pargunov.medium;

public class ReverseInteger_7 {
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

    private static int reverse(int x) {
        int res = 0;

        while(x != 0) {
            int pop = x % 10;
            x /= 10;

            // if reverted number will give overflow than it won't givw overflow if we compare without last digit
            // so by dividing Integer.MAX_VALUE / 10 we check if reversed number already bigger than it is in range of Integer
            // but last digit will do overflow for sure
            // so we need to prevent overflow that is why we make comparison on values divided by 10.
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                return 0;
            }

            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) {
                return 0;
            }

            res = res * 10 + pop;
        }

        return res;
    }
}
