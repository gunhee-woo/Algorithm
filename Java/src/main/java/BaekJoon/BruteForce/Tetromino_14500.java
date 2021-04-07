package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class Tetromino_14500 {
    static int N, M;
    static int MAX = 501;
    static int[][] map;
    static boolean[][] check;
    static int max = 0;
    static int[] ax = {0,0,-1,1};
    static int[] ay = {-1,1,0,0};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[MAX][MAX];
        check = new boolean[MAX][MAX];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                for(int k = 0; k < check.length; k++) Arrays.fill(check[k], false);
                dfs(i, j, 0, map[i][j]);

            }
        }

    }

    static void dfs(int x, int y, int k, int sum) {
        check[x][y] = true;
        if(k == 3) {
            max = Math.max(max, sum);
            return;
        }
        for(int i = 0; i < 4; i++) {
            int nx = x + ax[i];
            int ny = y + ay[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(!check[nx][ny]) {
                dfs(nx, ny, k + 1, sum + map[nx][ny]);
                check[nx][ny] = false;
            }
        }
    }

    static void figure1(int x, int y) {
        int temp = map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x][y + 3];
        max = Math.max(max, temp);
    }

    static void figure2(int x, int y) {
        int temp = map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 2][y + 1];
        max = Math.max(max, temp);
    }

    static void figure3(int x, int y) {
        int temp = map[x][y] + map[x + 1][y] + map[x][y + 1] + map[x + 1][y + 1];
        max = Math.max(max, temp);
    }

    static boolean figure4(int x, int y) {
        int temp = map[x][y] + map[x + 1][y] + map[x + 1][y + 1] + map[x + 1][y + 2];
        max = Math.max(max, temp);
    }
}
