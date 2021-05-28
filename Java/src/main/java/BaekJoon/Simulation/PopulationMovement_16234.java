package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

public class PopulationMovement_16234 {
    static int N, L, R;
    static int[][] map;
    static boolean[][] check;
    static int[] ax = {-1, 1, 0, 0};
    static int[] ay = {0, 0, -1, 1};
    static int MAX = 51;
    static int answer = 0;
    static boolean flag;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[MAX][MAX];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        flag = true;
        while(flag) {
            flag = false;
            check = new boolean[MAX][MAX];
            for(int i = 0; i < N * N; i++) {
                int x = i / N;
                int y = i % N;
                if(!check[x][y]) {
                    move(x, y);
                }
            }
            if(flag) answer++;
        }
        System.out.print(answer);
    }

    public static void move(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        check[x][y] = true;
        List<Point> list = new ArrayList<>();
        list.add(new Point(x, y));
        int total = map[x][y];
        while(!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.peek().y;
            q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cx + ax[i];
                int ny = cy + ay[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N || check[nx][ny]) continue;
                if(isMoveOk(Math.abs(map[cx][cy] - map[nx][ny]))) {
                    total += map[nx][ny];
                    list.add(new Point(nx, ny));
                    q.add(new Point(nx, ny));
                    check[nx][ny] = true;
                    flag = true;
                }
            }
        }
        if(list.size() > 1) {
            int avg = total / list.size();
            for(Point p : list) {
                map[p.x][p.y] = avg;
            }
        }
    }

    public static boolean isMoveOk(int val) {
        return L <= val && val <= R;
    }

    public static void print() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static class Point {
        int x; int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
