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
// ���ͽ�Ʈ�� �˰���� ���� ������ ���������� �ٸ� ��� ���������� �ִܰ�θ� ���ϴ� �˰���
// �������� ������ Cost�� ������ ���� ����� �� �ִٴ� ��!! ex) Ÿ�Ӹӽ��� Ÿ�� ���Ÿ� �����ϴ� �Ͱ� ���� ��
// �ִܰ�θ� ���ϱ� ���� ���� for���� ����Ͽ� ��� ��츦 Ž��
// ������ �ִ� ����� ���� ������ ���ƺ��� V - 1��
// ���� ������ V - 1�� ������ k��° �������� ���������κ��� �� �������� k���� ������ ���ļ� ������ �� �ִ� �ִܰ�θ� �������ش�
// ���� �׷����� ���� ����Ŭ�� �����Ѵٸ� �� ���Ŀ� ������ �� ��� �ִܰŸ��� ���ŵǴ� ���� �߻���
// ���� ���� ����Ŭ�� ���� ���θ� �Ǵ��ϱ� ���� �� �������� Ȯ���� ������ �� �� �� ���� �ִܰŸ��� ���ŵǴ��� Ȯ��
// ���� ������ �ȴٸ� ���� ����Ŭ�� �����Ѵٴ� ��
public class timeMachine_11657 {
    static long INF = Long.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Node>[] lists = new List[501];
        long [] d = new long[N + 1];
        Arrays.fill(d, INF);
        for(int i = 1; i <= N; i++) lists[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lists[a].add(new Node(b, c));
        }
        d[1] = 0;
        boolean minusCycle = false; // ���� ����Ŭ�� �����ϴ��� �Ǵ��ϱ� ���� Flag
        for(int i = 1; i <= N; i++) {
//        for(int i = 1; i <= N - 1; i++) { // ���� N - 1 ��ŭ ������ ���� �ִܰŸ� ����
            for(int j = 1; j <= N; j++) {
                for(Node node : lists[j]) {
                    int next = node.end;
                    int nextTime = node.time;
                    if(d[j] != INF && d[next] > d[j] + nextTime) {
                        d[next] = d[j] + nextTime;
                        if(i == N - 1) minusCycle = true;
                    }
                }
            }
        }
        if(minusCycle) System.out.print(-1);
        else {
            for(int i = 1; i <= N; i++) {
                if(d[i] != INF) System.out.println(d[i]);
                else System.out.println(-1);
            }
        }
    }

    public static class Node {
        int end;
        int time;
        public Node(int end, int time) {
            this.end = end;
            this.time = time;
        }
    }
}
