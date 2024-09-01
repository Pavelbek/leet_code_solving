package pargunov.medium;

import java.util.List;

public class WordBreak_139 {
    // video which helped https://youtu.be/iWenZCZEBIA?si=1RCGf2bSmyWAVNSi
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        int maxLen = 0;

        for(String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        for(int i = 0; i <= n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(i - j > maxLen) continue;
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
