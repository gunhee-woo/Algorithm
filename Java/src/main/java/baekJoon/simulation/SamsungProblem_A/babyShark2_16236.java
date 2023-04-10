package baekJoon.simulation.SamsungProblem_A;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

public class babyShark2_16236 {
    static int N;
    static int[][] map;
    static boolean[][] check;
    static int[] ax = {-1, 0, 0, 1};
    static int[] ay = {0, -1, 1, 0};
    static Shark sk;
    static PriorityQueue<Point> pq;
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(distance(o1) == distance(o2)) {
                    if(o1.x == o2.x) return o1.y - o2.y;
                    else return o1.x - o2.x;
                }
                else return distance(o1) - distance(o2);
            }
        });
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        check = new boolean[N][N];
        List<Point> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) sk = new Shark(i, j,2,0);
                else {
                    if(map[i][j] != 0) list.add(new Point(i, j, map[i][j]));
                }
            }
        }
        pq.addAll(list);

        System.out.println(sk.x + " " + sk.y);
        while(!pq.isEmpty()) {
            int cx = pq.peek().x;
            int cy = pq.peek().y;
            pq.poll();
            System.out.println(cx + " " + cy);
        }
    }

    private static int distance(Point p) {
        return Math.abs(sk.x - p.x) + Math.abs(sk.y - p.y);
    }


    static class Point {
        int x; int y; int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static class Shark {
        int x; int y; int size; int cnt;

        public Shark(int x, int y, int size, int cnt) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.cnt = cnt;
        }
    }
}
