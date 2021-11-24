package Programmers;

import java.io.FileInputStream;
import java.util.*;

import static Util.Constants.INPUT;

public class MazeEscape {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        int n = 4; int start = 1; int end = 4;
        int[][] roads = {{1, 2, 1}, {3, 2, 1}, {2, 4, 1}};
        int[] traps = {2, 3};
        print(sol(n, start, end, roads, traps));
    }

    public static void print(Object o) {
        System.out.print(o);
    }

    static List<Node>[] lists;
    static List<Node>[] reverse;
    static int[] d;
    static int INF = 987654321;
    public static int sol(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;
        d = new int[n + 1];
        Arrays.fill(d, INF);
        lists = new List[n + 1];
        reverse = new List[n + 1];
        for(int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }
        Set<Integer> trapSet = new HashSet<>();
        for (int trap : traps) trapSet.add(trap);
        for(int i = 0; i < roads.length; i++) {
            int a = roads[i][0]; int b = roads[i][1]; int c = roads[i][2];
            if(trapSet.contains(b)) {
                lists[a].add(new Node(new Point(b, true), c));
                reverse[b].add(new Node(new Point(a, false), c));
            } else {
                lists[a].add(new Node(new Point(b, false), c));
            }
        }
//        d[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(new Point(start, false), 0));
        while(!pq.isEmpty()) {
            Point cur = pq.peek().end;
            int cost = pq.peek().cost;
            pq.poll();
//            if(d[cur.num] < cost) continue;
            for(int i = 0; i < lists[cur.num].size(); i++) {
                Point next = lists[cur.num].get(i).end;
                int nextCost = cost + lists[cur.num].get(i).cost;
//                d[cur.num] = nextCost;
                if(next.isTrap) {

                } else {

                }
                pq.add(new Node(next, nextCost));
            }
        }

        return answer;
    }

    public static class Node implements Comparable<Node>{
        Point end; int cost;
        public Node(Point end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static class Point {
        int num; boolean isTrap;
        public Point(int num, boolean isTrap) {
            this.num = num;
            this.isTrap = isTrap;
        }
    }
}
