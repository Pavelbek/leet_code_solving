package pargunov.easy;

public class BackspaceStringCompare_844 {

    private boolean backspaceCompare(String s, String t) {
        s = convertString(s);
        t = convertString(t);
        return s.equals(t);
    }

    private String convertString(String s) {
        StringBuilder sb = new StringBuilder();
        int hashCounter = 0;

        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != '#' && hashCounter == 0) {
                sb.append(s.charAt(i));
            } else if (s.charAt(i) == '#') {
                hashCounter++;
            } else {
                hashCounter--;
            }
        }

        return sb.reverse().toString();
    }
}
