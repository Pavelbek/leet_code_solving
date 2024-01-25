package pargunov.easy;

public class PalindromeNumber_9 {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x < 10) return true;
        if(x % 10 == 0) return false;

        int copy = x;
        int inv = 0;

        while(copy > 0) {
            inv = inv * 10 + copy % 10;
            copy /= 10;
        }

        return x == inv;
    }
}
