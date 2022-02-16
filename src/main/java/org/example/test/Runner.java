package org.example.test;

import java.util.HashMap;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        String result = getRunner(participant, completion);

        System.out.println("============================");
        System.out.println("result : " + result);
        System.out.println("============================");
    }

    private static String getRunner(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> mapComp = new HashMap<>();
        for (String comp : completion) {
            if (mapComp.containsKey(comp)) {
                int cnt = mapComp.get(comp) + 1;
                mapComp.remove(comp);
                mapComp.put(comp, cnt);
            }
            else {mapComp.put(comp, 1);}
        }

        for (String part : participant) {
            if (mapComp.containsKey(part) && mapComp.get(part) > 0) {
                int cnt = mapComp.get(part);
                mapComp.remove(part);
                if (cnt > 0) {
                    mapComp.put(part, cnt - 1);
                }
            }
            else {
                answer = part;
                break;
            }
        }

        return answer;
    }
}
