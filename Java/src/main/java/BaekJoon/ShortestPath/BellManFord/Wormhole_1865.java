package BaekJoon.ShortestPath.BellManFord;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// �������� �˰���
// �� ���������� �������� �־����� �ʰ� ���� ����Ŭ�� �����ϳ�
// ���� ��� ������ ���������� ������ ������ �ð� �ʰ�

// d[j] != INF �� ������ �����ؾ� ��
// d[j] != INF => �� ���ǿ� ���� �׳� ����ġ�� �ȴٸ� �ڿ� �ִ� Cycle�� ���� ���θ� �Ǵ��� �� ����
// �� ������ ���� ����Ŭ�� �����Ѵٴ� ���� ã�⸸ �ϸ� �ǹǷ� �� ������ ���־� ��
// �ݷ�
// 1
// 2 0 1
// 2 2 1

public class Wormhole_1865 {
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int[] d = new int[N + 1];
            Arrays.fill(d, INF);
            List<Node>[] lists = new List[N + 1];
            for(int i = 1; i <= N; i++) lists[i] = new ArrayList<>();
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                lists[s].add(new Node(e, t));
                lists[e].add(new Node(s, t));
            }
            for(int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                lists[s].add(new Node(e, -t));
            }
            d[1] = 0;
            boolean isMinusCycle = false;
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    for(Node node : lists[j]) {
                        int next = node.end;
                        int nextTime = node.time;
                        if(d[next] > d[j] + nextTime) {
                            d[next] = d[j] + nextTime;
                            if(i == N) isMinusCycle = true;
                        }
                    }
                }
            }
            if(isMinusCycle) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static class Node {
        int end; int time;
        public Node(int end, int time) {
            this.end = end;
            this.time = time;
        }
    }
}
