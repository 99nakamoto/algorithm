import common.Common;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution ins = new Solution();
        System.out.println(ins.fractionToDecimal(1, 6));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        int integer = numerator / denominator;
        int reminder = numerator % denominator;
        if (reminder == 0) {
            return String.valueOf(integer);
        }
        return integer + "." + fraction(reminder, denominator);
    }

    String fraction(int num, int denum) {
        // eg. num = 1, denum = 4, should return "25"

        List<Pair> list = new ArrayList<Pair>();
        String result = "";
        while (num != 0) {
            num *= 10;
            int digit = num / denum;

            // eg. 1 / 333 = (003), so the pairs would be like this:
            // {10, 0}, {100, 0}, {1000, 3}, {10, 0}...
            Pair cur = new Pair(num, digit);
            num %= denum;

            // now add cur Pair to the list
            if (list.indexOf(cur) == -1) {
                list.add(cur);
            } else {
                // found a recurring dicimal in the previous output stream
                int pos = list.indexOf(cur);
                for (int i = 0; i < pos; i++) {
                    result += list.get(i).digit;
                }
                result += "(";
                for (int i = pos; i < list.size(); i++) {
                    result += list.get(i).digit;
                }
                result += ")";
                break;
            }
        }

        // if there is recurring digit, the result should have already been generated
        if (result.length() == 0) {
            for (Pair p : list) {
                result += p.digit;
            }
        }
        return result;
    }
}

class Pair {
    int num;
    int digit;

    public Pair(int a, int b) {
        num = a;
        digit = b;
    }

    @Override
    public boolean equals(Object obj) {
        Pair p = (Pair) obj;
        return this.num == p.num && this.digit == p.digit;
    }
}
