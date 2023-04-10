package programmers.TwoPointer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static Util.Constants.INPUT;

public class JewelryShopping_2020_kakao_intern_3 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int[] sol = solution(str);
        System.out.print(sol[0] + " " + sol[1]);
    }

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        Point p = new Point(0, 100001);
        Set<String> set = new HashSet<>();
        for(int i = 0; i < gems.length; i++) set.add(gems[i]);
        int ts = set.size();
        Map<String, Integer> map = new HashMap<>();
        int s = 0; int e = 0;
        while(true) {
            if(map.size() == ts) {
                int plen = p.end - p.start;
                int mlen = e - s;
                if(plen > mlen) {
                    p = new Point(s, e);
                } else if(plen == mlen) {
                    if(p.start > s) {
                        p = new Point(s, e);
                    }
                }
                map.put(gems[s], map.get(gems[s]) - 1);
                if(map.get(gems[s]) == 0) map.remove(gems[s]);
                s++;
            } else if(e == gems.length) {
                break;
            } else {
                if(map.containsKey(gems[e])) {
                    int temp = map.get(gems[e]);
                    map.put(gems[e], temp + 1);
                } else {
                    map.put(gems[e], 1);
                }
                e++;
            }
        }
        answer[0] = p.start + 1;
        answer[1] = p.end;
        return answer;
    }

    public static class Point {
        int start; int end;
        public Point(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
