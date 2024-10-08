package pargunov.easy;

public class AddBinary_67 {
    public static void main(String[] args) {
        // binary addition logic:
        // 1 0 0 1
        // 1 0 1 0
        // 0 0 1 1
  // carry 1 0 0 0
        // sum of 11 + 1
        //  11
        //   1
        // 100
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
            sb.append(sum % 2); // 0 % 2 = 0; 1 % 2 = 1; 2 % 2 = 0; 3 % 2 = 1;
            carry = sum / 2; // 0 / 2 = 0; 1 / 2 = 0; 2 / 2 = 1;
            j--;
            i--;
        }

        if(carry != 0) sb.append(carry);

        return sb.reverse().toString();
    }
}
