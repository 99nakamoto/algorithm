package online.epic.easy;

import java.util.ArrayList;
import java.util.List;

import common.Common;

public class WellOrderedString {

    public static void main(String[] args) {
        WellOrderedString ins = new WellOrderedString();
        Common.printList(ins.wellOrdered(2));
        System.out.println();
    }

    private List<String> wellOrdered(int length) {
        List<String> ans = new ArrayList<String>();
        helper(ans, "", 'a', length);
        return ans;
    }

    private void helper(List<String> ans, String current, char start, int len) {
        if (len == 0) {
            ans.add(current);
            return;
        }
        for (char c = start; c <= 'z'; c++) {
            helper(ans, current + c, (char) (c + 1), len - 1);
        }
    }
}
