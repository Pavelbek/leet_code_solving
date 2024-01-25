package pargunov.easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses_929 {
    public static void main(String[] args) {
        String[] emails = { "test.email+alex@leetcode.com", "test.email.leet+alex@code.com" };
        System.out.println(numUniqueEmails(emails));
    }

    private static int numUniqueEmails(String[] emails) {
        Set<String> res = new HashSet<>();

        for(String email : emails) {
            String[] split = email.split("@");
            String name = split[0];

            if(name.indexOf("+") > 0) {
                name = name.substring(0, name.indexOf("+"));
            }
            res.add(name.replace(".", "") + "@" + split[1]);
        }
        return res.size();
    }
}
