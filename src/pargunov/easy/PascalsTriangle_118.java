package pargunov.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_118 {

    public static void main(String[] args) {
        System.out.println((double)3 / 1);
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) return res;
        if(numRows == 1) {
            res.add(List.of(1));
            return res;
        }
        if(numRows == 2) {
            res.add(List.of(1));
            res.add(List.of(1, 1));
            return res;
        }
        res.add(List.of(1));
        res.add(List.of(1, 1));
        List<Integer> prev;
        List<Integer> row;
        for(int i = 2; i < numRows; i++) {
            prev = res.get(i - 1);
            row = new ArrayList<>();
            row.add(1);
            for(int j = 0; j < i - 1; j++) {
                row.add(prev.get(j) + prev.get(j + 1));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}
