package BaekJoon.GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

// �׸��� �˰���, ����
// ���� ������ �ð��� �������� �������� ���� �� ���� ���� �� ���� �ʿ��� �ð��� ����Ͽ� ����, ������ 0����
// ������ ���� ������ ���� �ʿ��� �ð��� ������ ��� -1 ���

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
