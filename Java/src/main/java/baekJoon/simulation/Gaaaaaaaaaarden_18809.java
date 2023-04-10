package baekJoon.simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class Gaaaaaaaaaarden_18809 {
    static int N, M, G, R;
    static int[][] map, cmap, reds, greens;
    static boolean[][] check;
    static int[] ax = {-1, 1, 0, 0};
    static int[] ay = {0, 0, -1, 1};
    static List<Point> list;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cmap = new int[N][M];
        reds = new int[N][M];
        greens = new int[N][M];
        check = new boolean[N][M];
        list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) list.add(new Point(i, j));
            }
        }
        copy();
        dfs(0, R, G);
    }

    public static void copy() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                cmap[i][j] = map[i][j];
            }
        }
    }

    public static void print() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(cmap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void dfs(int k, int rc, int gc) {
        if(k == G + R) {
            print();
            return;
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 2 && !check[i][j]) {
                    check[i][j] = true;
                    if(rc > 0) {
                        cmap[i][j] = 3;
                        rc--;
                        dfs(k + 1, rc, gc);
                        rc++;
                    } else {
                        cmap[i][j] = 4;
                        gc--;
                        dfs(k + 1, rc, gc);
                        gc++;
                    }
                    check[i][j] = false;
                    cmap[i][j] = 2;
                }
            }
        }
    }

    public static class Point {
        int x; int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
