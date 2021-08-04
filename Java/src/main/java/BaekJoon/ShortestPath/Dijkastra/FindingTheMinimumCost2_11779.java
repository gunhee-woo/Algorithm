package BaekJoon.ShortestPath.Dijkastra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

// ���ͽ�Ʈ�� �˰��� ���� => ��������� ���������� ���İ��� ��带 ����ϴ� ����
// N�� 1000�̰� �ð������� 1�� �̹Ƿ� �÷��̵� �ͼ� �˰����� ����ϸ� �ð� �ʰ�
// ��������� 0���� ũ�� 100,000���� ���� ������� ������ �����Ƿ� ���� ������ ������� ���� => �������� �˰��� X
// ���� ���ͽ�Ʈ�� �˰����� ����Ͽ� ��������� ������������ �ּ� ����� ���ϸ� ��
// ��������� ���������� ���İ��� ����� ������ �迭�� ����Ͽ� �������� �ε����� �������� ������ �����ϴ� ������� ���󰡸鼭 ã���� �ְ� ��
public class FindingTheMinimumCost2_11779 {
    static int N, M;
    static int[] d;
    static int INF = Integer.MAX_VALUE;
    static List<Node>[] list;
    static int[] route; // route[i]�� ���� ������ ����, ��� ������ ����
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        d = new int[N + 1];
        Arrays.fill(d, INF);
        list = new List[N + 1];
        route = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
        }
        String[] str = br.readLine().split(" ");
        int start = Integer.parseInt(str[0]);
        int end = Integer.parseInt(str[1]);
        d[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()) {
            int cur = pq.peek().end;
            int cost = pq.peek().cost;
            pq.poll();
            if(d[cur] < cost) continue;
            for(int i = 0; i < list[cur].size(); i++) {
                int next = list[cur].get(i).end;
                int nextCost = cost + list[cur].get(i).cost;
                if(d[next] > nextCost) {
                    d[next] = nextCost;
                    route[next] = cur;
                    pq.add(new Node(next, nextCost));
                }
            }
        }
        System.out.println(d[end]);
        List<Integer> nodes = new ArrayList<>();
        int temp = end;
        while(true) { // ��� ����
            nodes.add(temp);
            if(temp == start) break;
            temp = route[temp]; // ���������� ����
        }
        System.out.println(nodes.size());
        for(int i = nodes.size() - 1; i >= 0; i--) {
            System.out.print(nodes.get(i) + " ");
        }
    }

    private static class Node implements Comparable<Node> {
        int end; int cost;
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
