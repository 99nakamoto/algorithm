package algo.questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateWithinKdistance {

    public static void main(String[] args) {
        DuplicateWithinKdistance ins = new DuplicateWithinKdistance();
        long startTime = System.currentTimeMillis();

        System.out.println("Code Ape Run... ");

        System.out.println();
        System.out.println(ins.dupWithinK(3, new int[]{1, 2, 3, 4, 5, 6, 7}) + " should be false");
        System.out.println(ins.dupWithinK(3, new int[]{1, 2, 3, 4, 3, 2, 1}) + " should be true");
        System.out.println(ins.dupWithinK(3, new int[]{4, 5, 6, 7, 4, 5, 4, 7}) + " should be true");
        System.out.println();

        System.out.print("Total time = ");
        System.out.print((System.currentTimeMillis() - startTime) / 1000.0);
    }

    public boolean dupWithinK(int k, int[] arr) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                return true;
            }
            if (i < k) {
                // the first k numbers
                set.add(arr[i]);
            } else {
                // the (k+1) th number and onwards
                set.add(arr[i]);
                set.remove(arr[i - k]);
            }
        }
        return false;
    }

}
