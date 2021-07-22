package BaekJoon.ShortestPath.Dijkastra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

// 다익스트라 알고리즘
// 특정한 하나의 정점에서 다른 모든 정점으로 가는 최단 경로를 찾는 알고리즘
// 다만 이때, 벨만포드 알고리즘과는 달리 음의 간선을 포함할 수 없음
// 다익스트라 알고리즘은 기본적으로 다이나믹 프로그래밍 문제임 => 최단거리는 여러 개의 최단거리로 이루어졌기 때문
// 하나의 최단거리를 구할 때 그 이전까지 구했던 최단 거리 정보를 그대로 사용한다
// 최소 힙(우선순위 큐)을 사용하여 시간 복잡도를 O(NlogN)으로 구현할 수 있음

public class ShortestPath_1753 {
    static int MAX = 20001;
    static int INF = 987654321;
    static int v, e, start;
    static int[] d;
    static List<Node>[] arr;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        d = new int[v + 1];
        Arrays.fill(d, INF);
        arr = new ArrayList[v + 1];
        for(int i = 1; i <= v; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int vv = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[u].add(new Node(vv, w));
        }
        dijkstra();
        for(int i = 1; i <= v; i++) {
            if(d[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(d[i]);
            }
        }
    }

    static void dijkstra() {
        d[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()) {
            int cur = pq.peek().end;
            int dist = pq.peek().weight;
            pq.poll();
            if(d[cur] < dist) continue;
            for(int i = 0; i < arr[cur].size(); i++) {
                int next = arr[cur].get(i).end;
                int nextDist = dist + arr[cur].get(i).weight;
                if(nextDist < d[next]) {
                    d[next] = nextDist;
                    pq.add(new Node(next, nextDist));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int end;
        int weight;
        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
