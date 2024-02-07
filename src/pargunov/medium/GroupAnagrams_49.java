package pargunov.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> groups = new HashMap<>();

        for(String str : strs) {
            String frequencyString = getFrequencyString(str);

            if(groups.containsKey(frequencyString)) {
                groups.get(frequencyString).add(str);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                groups.put(frequencyString, strList);
            }
        }

        return new ArrayList<List<String>>(groups.values());
    }

    private String getFrequencyString(String str) {
        int[] buckets = new int[26];

        // each char has integer code
        // 'a' = 65 for example, and all the alpha char code will go one by one like
        // 65 66 67 ..... diff between first and last will be size of alphabet
        // so by excluding 65 code values before we start from 0 and each char will have its bucket
        for(char c : str.toCharArray()) {
            buckets[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        // we are going through alphabet and create string like: a1b0c3d0...
        for(int i = 0; i < buckets.length; i++) {
            if(buckets[i] != 0) {
                sb.append((char) 'a' + i);
                sb.append(buckets[i]);
            }
        }

        return sb.toString();
    }
}
