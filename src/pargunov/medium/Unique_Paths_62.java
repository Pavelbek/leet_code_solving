package pargunov.medium;

import java.util.Arrays;

public class Unique_Paths_62 {

    // complexity O(m * n) - time; O(n) - space
    public int uniquePaths(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row, 1);
        // input: m = 3; n = 7;
        // row    = 1 1 1 1 1 1 1 -> 7 6 5 4 3 2 1 -> 28 21 15 10 6 3 1
        // 0 iteration: newRow = 7 6 5 4 3 2 1
        // 1 iteration: newRow = 28 21 15 10 6 3 1
        // result: 28

        // we work with rows except of last one, last index is 2 so we loop 0 1 as last is 1s
        // нижний ряд всегла 1 и правый ряд всегда 1
        // поэтому мы заолнаяем кдиницами чтобы удобно каждый раз j брало начальное правое значение 1 и нижнее значение из row
        // далее j становаитсян а иденкс меньше а у нас есть новое правое значение и нижние значения мы всегда берем из row
        for(int i = 0; i < m - 1; i++) {
            int[] newRow = new int[n];
            Arrays.fill(newRow, 1);
            // here we don't need to work with right most column as it always 1s
            for(int j = n - 2; j >= 0; j--) {
                newRow[j] = newRow[j + 1] + row[j];
            }
            row = newRow;
        }

        return row[0];
    }
}
