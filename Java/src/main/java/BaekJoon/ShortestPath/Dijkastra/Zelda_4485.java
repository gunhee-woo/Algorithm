package BaekJoon.ShortestPath.Dijkastra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

public class Zelda_4485 {
//    static int[] ax = {0, 0, -1, 1};
//    static int[] ay = {1, -1, 0, 0};
//    static int MAX = 987654321;
//    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream(INPUT));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int cnt = 1;
//        while(true) {
//            int N = Integer.parseInt(br.readLine());
//            if(N == 0) break;
//            int[][] map = new int[N][N];
//            int[][] d = new int[N][N];
//            for(int i = 0; i < N; i++) Arrays.fill(d[i], MAX);
//            for(int i = 0; i < N; i++) {
//                StringTokenizer st = new StringTokenizer(br.readLine());
//                for(int j = 0; j < N; j++) {
//                    map[i][j] = Integer.parseInt(st.nextToken());
//                }
//            }
//            Queue<Point> q = new LinkedList<>();
//            q.add(new Point(0, 0));
//            d[0][0] = map[0][0];
//            while(!q.isEmpty()) {
//                int cx = q.peek().x;
//                int cy = q.peek().y;
//                q.poll();
//                for(int i = 0; i < 4; i++) {
//                    int nx = cx + ax[i];
//                    int ny = cy + ay[i];
//                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
//                    if(d[nx][ny] > d[cx][cy] + map[nx][ny]) {
//                        d[nx][ny] = d[cx][cy] + map[nx][ny];
//                        q.add(new Point(nx, ny));
//                    }
//                }
//            }
//            System.out.println("Problem " + cnt + ": " + d[N - 1][N - 1]);
//            cnt++;
//        }
//    }
//
//    public static class Point {
//        int x; int y;
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }

    static int[] ax = {0, 0, -1, 1};
    static int[] ay = {1, -1, 0, 0};
    static int MAX = 987654321;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 1;
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            int[][] map = new int[N][N];
            int[][] d = new int[N][N];
            for(int i = 0; i < N; i++) Arrays.fill(d[i], MAX);
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0, 0, map[0][0]));
            d[0][0] = map[0][0];
            while(!pq.isEmpty()) {
                int cx = pq.peek().x;
                int cy = pq.peek().y;
                int cost = pq.peek().cost;
                pq.poll();
                for(int i = 0; i < 4; i++) {
                    int nx = cx + ax[i];
                    int ny = cy + ay[i];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    int nextCost = cost + map[nx][ny];
                    if(d[nx][ny] > nextCost) {
                        d[nx][ny] = nextCost;
                        pq.add(new Node(nx, ny, nextCost));
                    }
                }
            }
            System.out.println("Problem " + cnt + ": " + d[N - 1][N - 1]);
            cnt++;
        }
    }

    public static class Node implements Comparable<Node> {
        int x; int y; int cost;
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
