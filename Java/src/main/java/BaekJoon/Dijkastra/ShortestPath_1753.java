package BaekJoon.Dijkastra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

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
