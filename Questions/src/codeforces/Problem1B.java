package codeforces;

import java.util.Scanner;

// http://codeforces.com/contest/1/problem/B

public class Problem1B {

    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        //takes in the dimensions of the square and tiles
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String coord = sc.nextLine();
            System.out.println(convert(coord));
        }
    }

    static String convert(String input) {
        // check 1 part num or 2 part num
        int p = 0;
        while (p < input.length() && !isNumber(input.charAt(p))) {
            p++;
        }
        while (p < input.length() && isNumber(input.charAt(p))) {
            p++;
        }
        if (p == input.length()) {
            // this is a alpha-numeric type
            return convertToNums(input);
        }
        return convertToAlphas(input);
    }

    public static boolean isNumber(char ch) {
        return '0' <= ch && ch <= '9';
    }

    static String convertToNums(String input) {
        int p = 0;
        while (p < input.length() && !isNumber(input.charAt(p))) {
            p++;
        }
        // p points to the first number
        String result = "R" + input.substring(p) + "C";

        // convert alphabets to numbers
        int l = 0;
        int sum = 0;
        while (l != p) {
            sum = sum * 26 + (input.charAt(l) - 'A' + 1);
            l++;
        }
        return result + String.valueOf(sum);
    }

    static String convertToAlphas(String input) {
        int p = input.indexOf('C');
        String num1 = input.substring(1, p);
        int num2 = Integer.parseInt(input.substring(p + 1));
        String alphabet = "";

        while (num2 != 0) {
            num2--;
            // note that doing this is wrong:
            // alphabet = (char) ('A' + num2 % 26 - 1) + alphabet;
            // because when num2 % 26 == 0, we should print 'Z' instead of 'A' -1
            alphabet = (char) ('A' + num2 % 26) + alphabet;
            num2 /= 26;
        }
        return alphabet + num1;
    }
}
