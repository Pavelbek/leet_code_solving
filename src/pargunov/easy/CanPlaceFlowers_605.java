package pargunov.easy;

import java.util.stream.Stream;

public class CanPlaceFlowers_605 {
    public static void main(String[] args) {
        String s = new String("s");
        String t = new String("s");
        System.out.println(s.equals(t));
    }

    private boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) return true;
        for(int i = 0; i < flowerbed.length; i++) {

            if( flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) &&
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) ) {
                flowerbed[i] = 1;
                n--;
                if(n == 0) return true;
            }
        }

        return false;
    }
}
