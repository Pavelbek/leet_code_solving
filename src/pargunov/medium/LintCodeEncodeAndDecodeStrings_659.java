package pargunov.medium;

import java.util.ArrayList;
import java.util.List;

public class LintCodeEncodeAndDecodeStrings_659 {
    public static void main(String[] args) {
        String[] strs = {"paha", "maha"};
        System.out.println(encodeStrings(strs));
    }
    private static String encodeStrings(String[] strs) {
        StringBuilder encodedStringBuilder = new StringBuilder();

        for(String str : strs) {
            encodedStringBuilder.append(str.length()).append("#").append(str);
        }

        return encodedStringBuilder.toString();
    }

    private List<String> decodeString(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
        }

        return res;
    }
}
