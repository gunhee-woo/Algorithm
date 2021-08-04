package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

public class Laboratory2_17141 {
    static int N, M;
    static int[][] map, cmap;
    static int[] ax = {-1, 1, 0, 0};
    static int[] ay = {0, 0, -1, 1};
    static List<Point> enableVirus;
    static boolean[] check;
    static Point[] virus;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        cmap = new int[N][N];
        enableVirus = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = cmap[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) enableVirus.add(new Point(i, j, 0));
            }
        }
        print();
        check = new boolean[enableVirus.size()];
        virus = new Point[M];
        dfs(0, 0);
        if(answer == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(answer);
    }

    private static void dfs(int n, int k) {
        if(n == M) {
            for(int i = 0; i < M; i++) {
                System.out.print(virus[i].x + "," + virus[i].y + " ");
            }
            System.out.println();
            setting();
            bfs();
            print2();
            return;
        }
        for(int i = k; i < enableVirus.size(); i++) {
            if(!check[i]) {
                check[i] = true;
                virus[n] = enableVirus.get(i);
                dfs(n + 1, i);
                check[i] = false;
            }
        }
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>(Arrays.asList(virus));
        for(Point p : virus) {
            cmap[p.x][p.y] = 0;
        }
        int time = 0;
        while(!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.peek().y;
            int ct = q.peek().time;
            time = Math.max(time, ct);
            q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cx + ax[i];
                int ny = cy + ay[i];
                int nt = ct + 1;
                if(nx < 0 || nx >= N || ny < 0 || ny >= N || cmap[nx][ny] == -2) continue;
                if(cmap[nx][ny] == -1) {
                    cmap[nx][ny] = nt;
                    q.add(new Point(nx, ny, nt));
                } else {
                    if(cmap[nx][ny] > nt) {
                        cmap[nx][ny] = nt;
                        q.add(new Point(nx, ny, nt));
                    }
                }
            }
        }
        System.out.println("time : " + time);
        if(!isEmptyArea())
            answer = Math.min(answer, time);
    }

    private static boolean isEmptyArea() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(cmap[i][j] == -1) return true;
            }
        }
        return false;
    }

    private static void setting() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] != 1) cmap[i][j] = -1;
                else cmap[i][j] = -2;
            }
        }
    }

    private static class Point {
        int x; int y; int time;
        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    private static void print() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void print2() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(cmap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
