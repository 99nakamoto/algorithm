package online.epic.easy;

import java.util.ArrayList;
import java.util.List;

import common.Common;

public class WellOrderedInt {

    public static void main(String[] args) {
        WellOrderedInt ins = new WellOrderedInt();
        Common.printList(ins.wellOrdered(2));
        System.out.println();
    }

    private List<Integer> wellOrdered(int length) {
        List<Integer> ans = new ArrayList<Integer>();
        helper(ans, 0, 0, length);
        return ans;
    }

    private void helper(List<Integer> ans, int current, int start, int len) {
        if (len == 0) {
            ans.add(current);
            return;
        }
        for (int i = start; i <= 9; i++) {
            helper(ans, current * 10 + i, i + 1, len - 1);
        }
    }

}
