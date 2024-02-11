package pargunov.easy;

import java.util.Set;
import java.util.stream.Collectors;

public class LongestNiceSubstring_1763 {
    public String longestNiceSubstring(String s) {
        return divideAndConquer(s);
    }

    private String divideAndConquer(String s) {
        if(s.length() < 2) return "";
        Set<Character> charSet = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        for(int i = 0; i < s.length(); i++) {
            char lower = Character.toLowerCase(s.charAt(i));
            char upper = Character.toUpperCase(s.charAt(i));
            if(!charSet.contains(lower) || !charSet.contains(upper)) {
                String str1 = divideAndConquer(s.substring(0, i));
                String str2 = divideAndConquer(s.substring(i + 1));
                return str1.length() >= str2.length() ? str1 : str2;
            }
        }
        return s;
    }
}
