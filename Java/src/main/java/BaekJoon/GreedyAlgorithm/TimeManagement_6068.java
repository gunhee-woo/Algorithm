package BaekJoon.GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

// 그리디 알고리즘, 정렬
// 일이 끝나는 시간을 기준으로 내림차순 정렬 후 일이 끝날 때 까지 필요한 시간을 계산하여 갱신, 끝부터 0까지
// 마지막 일을 끝내기 위해 필요한 시간이 부족한 경우 -1 출력

public class TimeManagement_6068 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Time> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Time(a, b));
        }
        Collections.sort(list, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                return o2.end - o1.end;
            }
        });
        int start = list.get(0).end - list.get(0).need;
        for(int i = 1; i < list.size(); i++) {
            Time cur = list.get(i);
            if(start < cur.end) {
                start = start - cur.need;
            } else {
                start = cur.end - cur.need;
            }
        }
        if(start < 0) System.out.print(-1);
        else System.out.print(start);
    }

    private static class Time {
        int need; int end;
        public Time(int need, int end) {
            this.need = need;
            this.end = end;
        }
    }
}
