package BaekJoon.MinimumSpanningTree.Kruskal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// 최대 간선이 1000개 이므로 크루스칼 알고리즘을 적용하여도 시간초과가 나지 않음
public class BBangSang_1774 {
    static int[] parent;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Point> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x, y, i + 1));
        }
        parent = new int[N + 1];
        for(int i = 1; i <= N; i++) parent[i] = i;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(!findParent(a, b)) unionParent(a, b);
        }
        List<Edge> edges = new ArrayList<>();
        // 모든 점들에 대하여 거리를 계산
        //
        for(int i = 0; i < N - 1; i++) {
            Point p1 = new Point(list.get(i));
            for(int j = 1; j < N; j++) {
                Point p2 = new Point(list.get(j));
                edges.add(new Edge(p1, p2));
            }
        }
        Collections.sort(edges);
        double answer = 0;
        for(int i = 0; i < edges.size(); i++) {
            int a = edges.get(i).node[0].n;
            int b = edges.get(i).node[1].n;
            if(!findParent(a, b)) {
                answer += edges.get(i).distance;
                unionParent(a, b);
            }
        }
        // Math.round(answer * 100) / 100.0 을 사용하면 소수점에서 0이나오는 경우 절삭해버림
        // 따라서 String.format("%.2f", answer) 를 사용하여 온전하게 출력해야 함
        System.out.print(String.format("%.2f", answer));
    }

    private static int getParent(int x) {
        if(parent[x] == x) return x;
        else return parent[x] = getParent(parent[x]);
    }

    private static void unionParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if(a != b) parent[b] = a;
    }

    private static boolean findParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        return a == b;
    }

    private static class Edge implements Comparable<Edge> {
        Point[] node = new Point[2];
        double distance;

        public Edge(Point a, Point b) {
            this.node[0] = a;
            this.node[1] = b;
            this.distance = Math.sqrt(Math.pow(Math.abs(b.x - a.x), 2) + Math.pow(Math.abs(b.y - a.y), 2));
        }

        @Override
        public int compareTo(Edge o) {
            if(this.distance < o.distance) return -1;
            else return 1;
        }
    }

    private static class Point {
        int x; int y; int n;
        public Point(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }
        public Point(Point p) {
            this.x = p.x;
            this.y = p.y;
            this.n = p.n;
        }
    }
}
