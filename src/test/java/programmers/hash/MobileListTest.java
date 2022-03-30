package programmers.hash;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 문제 설명
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 *
 *  구조대 : 119
 *  박준영 : 97 674 223
 *  지영석 : 11 9552 4421
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
 * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 사항
 *  phone_book의 길이는 1 이상 1,000,000 이하입니다.
 *      각 전화번호의 길이는 1 이상 20 이하입니다.
 *      같은 전화번호가 중복해서 들어있지 않습니다.
 */
public class MobileListTest {
    @Test
    public void main() {
        assertEquals(false, solution(new String[]{"119", "97674223", "1195524421"}));
        assertEquals(true, solution(new String[]{"123","456","789"}));
        assertEquals(false, solution(new String[]{"12","123","1235","567","88"}));
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        // 오름차순으로 정렬
        Arrays.sort(phone_book);


        int idx = 0;
        HashMap<Integer, String> hm = new HashMap<>();
        for (String phone : phone_book) {
            hm.put(idx++, phone);
        }

        for (int i = 0; i < phone_book.length-1; i++) {
            if (hm.get(i + 1).startsWith(hm.get(i))) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}
