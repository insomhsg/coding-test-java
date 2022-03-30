package programmers.hash;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 문제 설명
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
 * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * completion의 길이는 participant의 길이보다 1 작습니다.
 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 참가자 중에는 동명이인이 있을 수 있습니다.
 */
public class RunnerTest {
    @Test
    public void main() {
        assertEquals("leo", solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        assertEquals("vinko", solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        assertEquals("mislav", solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // 완주자 리스트를 map으로 변경. 동명이인이 있을 수 있으니 사람 수 카운트
        Map<String, Integer> mapComp = new HashMap<>();
        for (String comp : completion) {
            if (mapComp.containsKey(comp)) { //동명이인이 있을 경우
                int cnt = mapComp.get(comp) + 1;
                mapComp.remove(comp); //삭제 후
                mapComp.put(comp, cnt); //+1한 값으로 재등록
            }
            else {
                mapComp.put(comp, 1);
            }
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
