package pargunov.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2_119 {
    public static void main(String[] args) {
        System.out.println(getRow(4));
    }
    private static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i <= rowIndex; i++) {
            res.add(1);
            for(int j = i - 1; j > 0; j--) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
        }
        return res;
    }
}
