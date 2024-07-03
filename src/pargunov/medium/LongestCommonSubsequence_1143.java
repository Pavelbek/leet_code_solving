package pargunov.medium;

public class LongestCommonSubsequence_1143 {

    // Time: O(m x n) m is length of first string, n is length of second string
    // Space: O(m x n) as we use memoization and store all the results
    private static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for(int i = 1; i <= text1.length(); i++) {
            for(int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}
