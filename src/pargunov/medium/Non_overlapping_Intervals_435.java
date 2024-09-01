package pargunov.medium;

import java.util.Arrays;

import static java.util.Comparator.comparingInt;

public class Non_overlapping_Intervals_435 {

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {2, 3}, {3, 4}, {1, 3}}; // 1,2 2,3 1,3 3,4
        System.out.println(eraseOverlapIntervals(arr));
    }

    private static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, comparingInt(a -> a[1]));
        int res = 0;
        int prevEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < prevEnd) {
                res++;
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return res;
    }
}
