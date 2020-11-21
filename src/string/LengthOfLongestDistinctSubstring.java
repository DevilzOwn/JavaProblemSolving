package string;

import java.util.Arrays;

public class LengthOfLongestDistinctSubstring {
    public int longestDistinctSubstring(String str) {
        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);
        int i = 0, val = 0;
        for (int j = 0; j < str.length(); j++) {
            i=Math.max(i,lastIndex[str.charAt(j) - 'a'] + 1);
            val = Math.max(val, j - i + 1);
            lastIndex[str.charAt(j) - 'a']=j;
        }
        return val;
    }
}
