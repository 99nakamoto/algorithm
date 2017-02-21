package online.GrabTaxi;

import java.util.HashMap;
import java.util.Map;

public class Question3 {

    public static void main(String[] args) {
        Question3 s = new Question3();

        System.out.println(s.solution(new int[]{3, 5, 6, 3, 3, 5}));
        System.out.println(s.solution(new int[]{1, 2, 5, 2, 1, 6, 6}));
    }

    public int solution(int[] A) {
        if (A == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // map counts the number of occurrence of each values
        for (int i: A) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int result = 0;
        for (int i: map.values()) {
            if (i > 1) {
                // just 1 occurrence won't make a pair, so.
                result += i * (i - 1) / 2;
            }
        }

        return result;
    }

}
