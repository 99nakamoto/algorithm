import common.Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestNumber(new int[]{
                12, 123, 45
        }));
    }

    public String largestNumber(int[] num) {
        if (num == null || num.length == 0) {
            return "0";
        }
        String[] strs = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            strs[i] = String.valueOf(num[i]);
        }
        Arrays.sort(strs, new LargerComparator());

        String res = "";
        for (String str : strs) {
            res = res + str;
        }
        return res;
    }


    class LargerComparator implements Comparator<String> {

        public int compare(String a, String b) {
            String first = a + b;
            String second = b + a;
            return second.compareTo(first);
        }
    }
}