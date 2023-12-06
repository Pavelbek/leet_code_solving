package pargunov.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {

    private List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rStart = 0;
        int rEnd = matrix.length - 1;
        int cStart = 0;
        int cEnd = matrix[0].length - 1;

        while(rStart <= rEnd && cStart <= cEnd) {
            for(int i = cStart; i <= cEnd; i++) {
                res.add(matrix[rStart][i]);
            }

            rStart++;

            for(int i = rStart; i <= rEnd; i++) {
                res.add(matrix[i][cEnd]);
            }

            cEnd--;

            if(rStart <= rEnd) {
                for(int i = cEnd; i >= cStart; i--) {
                    res.add(matrix[rEnd][i]);
                }
            }

            rEnd--;

            if(cStart <= cEnd) {
                for(int i = rEnd; i >= rStart; i--) {
                    res.add(matrix[i][cStart]);
                }
            }

            cStart++;
        }

        return res;
    }
}
