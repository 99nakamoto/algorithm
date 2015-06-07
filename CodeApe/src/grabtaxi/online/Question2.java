package grabtaxi.online;

import java.util.HashMap;
import java.util.Map;

public class Question2 {

    public static void main(String[] args) {
        Question2 s = new Question2();

        System.out.println(s.solution("ABBCC"));
        System.out.println(s.solution("AABCC"));
        System.out.println(s.solution("ABCC"));
        System.out.println(s.solution("ACCC"));
        System.out.println(s.solution("ACC"));
        System.out.println(s.solution("AC"));
        System.out.println(s.solution("AUBCVCACB"));
        System.out.println(s.solution("CACACCCAAA"));
    }

    public String solution(String s) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("AB", "AA");
        map.put("BA", "AA");
        map.put("CB", "CC");
        map.put("BC", "CC");
        map.put("AA", "A");
        map.put("CC", "C");

        while (transformable(map, s) != -1) {
            int ind = transformable(map, s);
            s = s.substring(0, ind) + map.get(s.substring(ind, ind + 2)) + s.substring(ind + 2);
        }

        return s;
    }

    int transformable(Map<String, String> map, String str) {
        for (String key: map.keySet()) {
            if (str.indexOf(key) != -1) {
                return str.indexOf(key);
            }
        }
        return -1;
    }
}
