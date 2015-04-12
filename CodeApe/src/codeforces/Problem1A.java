package codeforces;

import java.util.Scanner;

// http://codeforces.com/contest/1/problem/A

public class Problem1A {
    
    static Scanner sr = new Scanner(System.in);
    public static void main(String args[])
    {
        //takes in the dimensions of the square and tiles
        long n = sr.nextInt();
        long m = sr.nextInt();
        long a = sr.nextInt();
        
        //calculates the biggest properly sized square with those tiles
        System.out.println(((n-1)/a + 1) * ((m-1)/a + 1));      
    }

}