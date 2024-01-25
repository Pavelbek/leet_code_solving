package pargunov.easy;

public class AddDigits_258 {
    // recursive solution;
    public int addDigits(int num) {
        if(num < 10) return num;
        int total = 0;
        while(num > 0) {
            total += num % 10;
            num /= 10;
        }
        return addDigits(total);
    }
}
