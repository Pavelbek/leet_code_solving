package pargunov.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {
    public static void main(String[] args) {
        String s = "aa"; // left 0, 6, 9
        String t = "aa";
        System.out.println(minWindow(s, t));
    }

    private static String minWindow(String s, String t) {
        if("".equals(t) || t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char ch : t.toCharArray()) {
            countT.compute(ch, (key, value) -> value == null ? 1 : value + 1);
        }
        int have = 0;
        int need = t.length();
        int left = 0;
        int[] resCandidate = {-1, -1};
        int resLength = Integer.MAX_VALUE;

        for(int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            if(countT.containsKey(current)) {
                window.compute(current, (key, value) -> value == null ? 1 : value + 1);
                if(countT.get(current) >= window.get(current)) {
                    have++;
                }
            }

            while(have == need) {
                if(right - left + 1 < resLength) {
                    resLength = right - left + 1;
                    resCandidate[0] = left;
                    resCandidate[1] = right;
                }

                char currentLeft = s.charAt(left);
                if(window.containsKey(currentLeft)) {
                    window.compute(currentLeft, (key, value) -> value - 1);
                    if(window.get(currentLeft) < countT.get(currentLeft)) {
                        have--;
                    }
                }
                left++;
            }
        }
        return resLength != Integer.MAX_VALUE ?
                s.substring(resCandidate[0], resCandidate[1] + 1) :
                "";
    }
}
