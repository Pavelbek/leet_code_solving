package pargunov.medium;

import java.util.ArrayList;
import java.util.List;

public class Pacific_Atlantic_Water_Flow_417 {
    private int ROWS;
    private int COLS;
    private int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.ROWS = heights.length;
        this.COLS = heights[0].length;
        this.heights = heights;
        boolean[][] pacVisited = new boolean[ROWS][COLS];
        boolean[][] atlVisited = new boolean[ROWS][COLS];
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < COLS; i++) {
            dfs(0, i, pacVisited, heights[0][i]);
            dfs(ROWS - 1, i, atlVisited, heights[ROWS - 1][i]);
        }

        for(int i = 0; i < ROWS; i++) {
            dfs(i, 0, pacVisited, heights[i][0]);
            dfs(i, COLS - 1, atlVisited, heights[i][COLS - 1]);
        }

        for(int i = 0; i < pacVisited.length; i++) {
            for(int j = 0; j < pacVisited[i].length; j++) {
                if(pacVisited[i][j] && atlVisited[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    public void dfs(int row, int col, boolean[][] visited, int prevHeight) {
        if(
            row < 0 || col < 0 ||
            row == ROWS || col == COLS ||
            prevHeight > heights[row][col] ||
            visited[row][col]
        ) return;

        visited[row][col] = true;

        dfs(row + 1, col, visited, heights[row][col]);
        dfs(row - 1, col, visited, heights[row][col]);
        dfs(row, col - 1, visited, heights[row][col]);
        dfs(row, col + 1, visited, heights[row][col]);
    }
}
