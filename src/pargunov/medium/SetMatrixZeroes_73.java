package pargunov.medium;

public class SetMatrixZeroes_73 {

    private void setZeroes(int[][] matrix) {
        var row_zero = false;
        var col_zero = false;
        var rLen = matrix.length;
        var cLen = matrix[0].length;

        for(int i = 0; i < rLen; i++) {
            if(matrix[i][0] == 0) {
                row_zero = true;
            }
        }

        for(int j = 0; j < cLen; j++) {
            if(matrix[0][j] == 0) {
                col_zero = true;
            }
        }

        for(int i = 1; i < rLen; i++) {
            for(int j = 1; j < cLen; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < rLen; i++) {
            for(int j = 1; j < cLen; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(row_zero) {
            for(int i = 0; i < rLen; i++) {
                matrix[i][0] = 0;
            }
        }

        if(col_zero) {
            for(int i = 0; i < cLen; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
