package pargunov.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SomeSolvings {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
//        String letters = "aaaabbccc";
//        System.out.println(countLetters(letters));
//        System.out.println(countLettersCompute(letters));
        System.out.println(indexOfStr(needle, haystack));
    }

    private static int indexOfStr(String needle, String haystack) {
        int nIndex = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(nIndex)) {
                nIndex++;
            } else {
                i -= nIndex;
                nIndex = 0;
            }
            if (nIndex == needle.length()) return i - nIndex + 1;
        }
        return -1;
    }


    private static Map<Character, Long>  countLetters(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static Map<String, Integer> countLettersCompute(String str) {
        Map<String, Integer> res = new HashMap<>();
        Arrays.stream(str.split(""))
                .forEach(e -> res.compute(e, (k, v) -> v == null ? 1 : v + 1));
        return res;
    }
}
