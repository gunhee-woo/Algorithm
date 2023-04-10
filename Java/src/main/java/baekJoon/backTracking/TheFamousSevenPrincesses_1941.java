package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import static Util.Constants.INPUT;

public class TheFamousSevenPrincesses_1941 {
    static char[][] map;
    static boolean[] check;
    static int[] arr;
    static int[] ax = {-1,1,0,0};
    static int[] ay = {0,0,-1,1};
    static int count;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        check = new boolean[25];
        arr = new int[7];
        for(int i = 0; i < 5; i++) {
           map[i] = br.readLine().toCharArray();
        }
        dfs(0,0,0);
        System.out.print(count);
    }

    private static void dfs(int k, int ix, int cnt) {
        if(k == 7) {
            if(cnt >= 4) {
                if(bfs() == 7)
                    count++;
            }
            return;
        }
        for(int i = ix; i < 25; i++) {
            if(!check[i]) {
                check[i] = true;
                arr[k] = i;
                if(map[i / 5][i % 5] == 'S') dfs(k + 1, i, cnt + 1);
                else dfs(k + 1, i, cnt);
                check[i] = false;
            }
        }
    }

    private static int bfs() {
        Queue<pair> q = new LinkedList<>();
        boolean[][] check2 = new boolean[5][5];
        for(int i = 0; i < 7; i++) {
            int ix = arr[i] / 5;
            int iy = arr[i] % 5;
            check2[ix][iy] = true;
        }
        q.add(new pair(arr[0] / 5, arr[0] % 5));
        check2[arr[0] / 5][arr[0] % 5] = false;
        int result = 0;
        while(!q.isEmpty()) {
            result++;
            int cx = q.peek().x;
            int cy = q.peek().y;
            q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cx + ax[i];
                int ny = cy + ay[i];
                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if(check2[nx][ny]) {
                    check2[nx][ny] = false;
                    q.add(new pair(nx, ny));
                }
            }
        }
        return result;
    }

    static class pair {
        public int x;
        public int y;
        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
