package pargunov.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation_784 {
    private List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();

        dfs(0, s, new StringBuilder(), result);

        return result;
    }

    private void dfs(int index, String s, StringBuilder sb, List<String> result) {
        if(index == s.length()) {
            result.add(sb.toString());
            return;
        }

        Character current = s.charAt(index);

        if(Character.isDigit(current)) {
            sb.append(current);
            dfs(index + 1, s, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(Character.toUpperCase(current));
            dfs(index + 1, s, sb, result);
            sb.deleteCharAt(sb.length() - 1);

            sb.append(Character.toLowerCase(current));
            dfs(index + 1, s, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
