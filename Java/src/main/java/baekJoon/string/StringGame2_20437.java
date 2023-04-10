package baekJoon.string;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static Util.Constants.INPUT;

public class StringGame2_20437 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());
            Map<Character, ArrayList<Integer>> map = new HashMap<>();
            for(int i = 0; i < 26; i++) // 알파벳 소문자를 모두 Map에 담아서 초기화
                map.put((char)('a' + i), new ArrayList<>());
            for(int i = 0; i < str.length(); i++)
                map.get(str.charAt(i)).add(i);
            int min = 987654321, max = 0;
            boolean b = false; // 연산을 한 번이라도 수행했는지 안했는지 체크하는 플래그
            for(Map.Entry<Character, ArrayList<Integer>> entry : map.entrySet()) {
                ArrayList<Integer> list = entry.getValue();
                if(list.size() >= k) { // k개 이상 들어있는 문자의 리스트만 연산 수행
                    b = true;
                    int s = 0, e = k - 1; // 투 포인터 알고리즘
                    while (e != list.size()) {
                        min = Math.min(min, list.get(e) - list.get(s) + 1); // 3번 => 어차피 해당 문자가 양 끝에 있을때가 가장 짧을 수 밖에 없음
                        max = Math.max(max, list.get(e) - list.get(s) + 1); // 4번
                        s++;
                        e++;
                    }
                }
            }
            if(b) {
                System.out.print(min + " ");
                System.out.println(max);
            } else
                System.out.println(-1);
        }
    }
}
