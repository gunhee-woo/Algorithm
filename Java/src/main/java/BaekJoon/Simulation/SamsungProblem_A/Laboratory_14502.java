package BaekJoon.Simulation.SamsungProblem_A;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

public class Laboratory_14502 {
    static int N, M;
    static int[][] map, cmap;
    static int[] ax = {-1, 1, 0, 0};
    static int[] ay = {0, 0, -1, 1};
    static List<Point> virus;
    static int answer;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cmap = new int[N][M];
        virus = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = cmap[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) virus.add(new Point(i, j));
            }
        }
        dfs(0);
        System.out.print(answer);
    }

    // dfs를 돌면서 세개의 벽을 세움
    private static void dfs(int n) {
        if(n == 3) {
            copy();
            bfs();
            answer = Math.max(answer, count());
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(n + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>(virus);
        while(!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.peek().y;
            q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cx + ax[i];
                int ny = cy + ay[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(cmap[nx][ny] == 0) {
                    cmap[nx][ny] = 2;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }

    private static int count() {
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(cmap[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    private static void copy() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                cmap[i][j] = map[i][j];
            }
        }
    }

    private static class Point {
        int x; int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void print() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void print2() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(cmap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
