package BaekJoon.ShortestPath.Dijkastra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

// 다익스트라 알고리즘 응용 => 출발점부터 도착점까지 거쳐가는 노드를 출력하는 문제
// N이 1000이고 시간제한이 1초 이므로 플로이드 와샬 알고리즘을 사용하면 시간 초과
// 버스비용이 0보다 크고 100,000보다 작은 정수라는 조건이 있으므로 음수 간선을 사용하지 않음 => 벨만포드 알고리즘 X
// 따라서 다익스트라 알고리즘을 사용하여 출발점부터 도착점까지의 최소 비용을 구하면 됨
// 출발점부터 도착점까지 거쳐가는 노드의 저장은 배열을 사용하여 현재정점 인덱스에 이전정점 정보를 저장하는 방식으로 따라가면서 찾을수 있게 함
public class FindingTheMinimumCost2_11779 {
    static int N, M;
    static int[] d;
    static int INF = Integer.MAX_VALUE;
    static List<Node>[] list;
    static int[] route; // route[i]는 이전 정점을 저장, 경로 추적을 위함
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
        while(true) { // 경로 추적
            nodes.add(temp);
            if(temp == start) break;
            temp = route[temp]; // 이전정점을 꺼냄
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
