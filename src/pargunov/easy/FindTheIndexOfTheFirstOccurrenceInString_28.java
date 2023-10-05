package pargunov.easy;

import java.util.TreeMap;

public class FindTheIndexOfTheFirstOccurrenceInString_28 {
    public static void main(String[] args) {
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        String haystack2 = "aasabutsad";
        String needle2 = "sad";
        String haystack3 = "mississippi";
        String needle3 = "issipi";
        System.out.println(strStr(haystack1, needle1)); // 0
        System.out.println(strStr(haystack2, needle2)); // 7
        System.out.println(strStr(haystack3, needle3)); // 4
    }

    private static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;

        for (int i = 0; i < haystack.length() + 1 - needle.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
                if(j == needle.length() - 1) return i;
            }
        }

        return -1;
    }

    public int strStr2(String haystack, String needle) {
        int nLen = needle.length();
        int nIndex = 0;
        for(int i = 0; i < haystack.length(); i++){
            // as long as the characters are equal, increment needleIndex
            if(haystack.charAt(i) == needle.charAt(nIndex)){
                nIndex++;
            }
            else{
                // start from the next index of previous start index
                i = i - nIndex;
                // needle should start from index 0
                nIndex = 0;
            }
            // check if needleIndex reached needle length
            if(nIndex == nLen){
                // return the first index
                return i - nLen + 1;
            }
        }
        return -1;
    }
}
