package BaekJoon.MinimumSpanningTree.Kruskal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class MinimumSpanningTree_1197 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Edge> list = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Edge(a, b, c));
        }
        Collections.sort(list);

        int[] parent = new int[N + 1];
        for(int i = 1; i <= N; i++) parent[i] = i; // 자기자신으로 초기화

        int sum = 0;
        for(int i = 0; i < list.size(); i++) {
            if(!findParent(parent, list.get(i).node[0], list.get(i).node[1])) {
                sum += list.get(i).cost;
                unionParent(parent, list.get(i).node[0], list.get(i).node[1]);
            }
        }
        System.out.print(sum);
    }

    private static int getParent(int[] parent, int x) {
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    private static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a != b) parent[b] = a;
    }

    private static boolean findParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        return a == b;
    }

    private static class Edge implements Comparable<Edge> {
        int[] node = new int[2];
        int cost;

        public Edge(int a, int b, int c) {
            this.node[0] = a;
            this.node[1] = b;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
