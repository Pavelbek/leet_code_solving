package pargunov.easy;

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference_389 {

    public static void main(String[] args) {
        char res = 0;
        String s = "abcd";
//        String t = "a";

        for(char c : s.toCharArray()) {
            res ^= c;
        }

//        for(char c : t.toCharArray()) {
//            res ^= c;
//        }

        System.out.println(res);
    }
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> sCounter = countCharactrers(s);
        Map<Character, Integer> tCounter = countCharactrers(t);
        char res = 0;
        for(char ch : t.toCharArray()) {
            if(!sCounter.containsKey(ch)) {
                res = ch;
                break;
            } else if(sCounter.get(ch) < tCounter.get(ch)) {
                res = ch;
                break;
            }
        }
        return res;
    }

    private Map<Character, Integer> countCharactrers(String str) {
        Map<Character, Integer> counter = new HashMap<>();

        for(char ch : str.toCharArray()) {
            counter.compute(ch, (key, value) -> value == null ? 1 : value + 1);
        }

        return counter;
    }

    // bit manipulation using XOR beats 100%
    public char findTheDifference2(String s, String t) {
        int res = 0;
        for(char ch : t.toCharArray()) {
            res ^= ch;
        }
        for(char ch : s.toCharArray()) {
            res ^= ch;
        }
        return (char) res;
    }
}
