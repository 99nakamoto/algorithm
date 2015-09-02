import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        List<Integer> stick = new LinkedList<Integer>();
        for (int i = 0; i < N; i++) {
            stick.add(sc.nextInt());
        }
        while (!stick.isEmpty()) {
            System.out.println(stick.size());
            stick = cutOnce(stick);
        }
    }

    private static List<Integer> cutOnce(List<Integer> stick) {
        // pass in stick length
        // return the result after cutting smallest
        stick.remove(0);
        return stick;
    }
}
