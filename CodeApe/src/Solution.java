import common.Common;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Solution ins = new Solution();
        List<List<Integer>> res = ins.combine(5, 2);
        System.out.println(res.size());
        for (List<Integer> l: res)
            Common.printList(l);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (n == 0 || k == 0 || n < k) {
            return ans;
        }
        helper(ans, new LinkedList<Integer>(), n, k, 1);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> path, int n, int k, int pos) {
        if (path.size() == k) {
            ans.add(path);
            return;
        }
        for (int i = pos; i <= n; i++) {
            path.add(i);
            helper(ans, path, n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
