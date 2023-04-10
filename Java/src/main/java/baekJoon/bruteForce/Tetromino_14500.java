package baekJoon.bruteForce;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// DFS + 브루트포스
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
                check[i][j] = true;
                dfs(i, j, 0, map[i][j]);
                middleFinger(i, j);
                check[i][j] = false;
            }
        }
        System.out.print(max);
    }

    static void dfs(int x, int y, int k, int sum) {
        if(k == 3) {
            max = Math.max(max, sum);
//            print();
            return;
        }
        for(int i = 0; i < 4; i++) {
            int nx = x + ax[i];
            int ny = y + ay[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(!check[nx][ny]) {
                check[nx][ny] = true;
                dfs(nx, ny, k + 1, sum + map[nx][ny]);
                check[nx][ny] = false;
            }
        }
    }

    static void middleFinger(int x, int y) {
        if(x <= N && x >= 1 && y + 2 <= M && y >= 0) { // ㅗ
            int temp = map[x][y] + map[x][y + 1] + map[x - 1][y + 1] + map[x][y + 2];
            max = Math.max(max, temp);
        }
        if(x + 2 <= N && x >= 0 && y >= 0 && y + 1 <= M) { // ㅏ
            int temp = map[x][y] + map[x + 1][y] + map[x + 1][y + 1] + map[x + 2][y];
            max = Math.max(max, temp);
        }
        if(x + 1 <= N && x >= 0 && y + 2 <= M && y >= 0) { // ㅜ
            int temp = map[x][y] + map[x][y + 1] + map[x + 1][y + 1] + map[x][y + 2];
            max = Math.max(max, temp);
        }
        if(x + 2 <= N && x >= 0 && y >= 1 && y <= M) { // ㅓ
            int temp = map[x][y] + map[x + 1][y] + map[x + 1][y - 1] + map[x + 2][y];
            max = Math.max(max, temp);
        }
    }

    static void print() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(check[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
