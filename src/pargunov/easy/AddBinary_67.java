package pargunov.easy;

public class AddBinary_67 {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }

    private static String addBinary(String a, String b) {
        var sb = new StringBuilder();
        var i = a.length() - 1;
        var j = b.length() - 1;
        var carry = 0;

        while(i >= 0 || j >= 0) {
            var sum = carry;
            if(i >= 0) sum += a.charAt(i) - '0';
            if(j >= 0) sum += b.charAt(j) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
            j--;
            i--;
        }

        if(carry != 0) sb.append(carry);

        return sb.reverse().toString();
    }
}
