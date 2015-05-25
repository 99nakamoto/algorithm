import common.Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfix(new int[]{
                3, 5, 1, 4, 9
        }));
    }

    int maxProfix(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxReturn = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // for each price, calculate the max possible return
            maxReturn = Math.max(maxReturn, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxReturn;
    }
}