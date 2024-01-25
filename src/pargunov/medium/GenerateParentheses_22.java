package pargunov.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
    public static void main(String[] args) {
        int i = 1 ^ 4;
        System.out.println(4 ^ 1);
    }
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        generate(0, 0, new StringBuilder(), n);
        return res;
    }

    private void generate(int openCount, int closeCount, StringBuilder builder, int n) {
        if(openCount > n) return;
        if(closeCount > openCount) return;
        if(openCount + closeCount == n * 2) {
            res.add(builder.toString());
            return;
        }

        builder.append("(");
        generate(openCount + 1, closeCount, builder, n);
        builder.deleteCharAt(builder.length() - 1);

        builder.append(")");
        generate(openCount, closeCount + 1, builder, n);
        builder.deleteCharAt(builder.length() - 1);
    }
}
