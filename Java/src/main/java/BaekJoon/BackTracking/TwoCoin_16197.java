package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class TwoCoin_16197 {
    static int N, M;
    static char[][] map;
    static int[] ax = {-1, 1, 0, 0};
    static int[] ay = {0, 0, -1, 1};
    static int answer = 987654321;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[21][21];
        List<coin> coins = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'o') coins.add(new coin(i, j));
            }
        }
        for(int i = 0; i < 4; i++) {
            dfs(coins.get(0), coins.get(1), 1, i);
        }
        if(answer > 10) answer = -1;
        System.out.print(answer);
    }

    private static void dfs(coin c1, coin c2, int cnt, int dir) {
        if(answer < cnt) return;
        if(cnt > 10) {
            answer = Math.min(answer, cnt);
            return;
        }
        coin next1 = new coin(c1.x + ax[dir], c1.y + ay[dir]);
        coin next2 = new coin(c2.x + ax[dir], c2.y + ay[dir]);
        if(rangeOver(next1) && rangeOver(next2)) return;
        else if(rangeOver(next1) && !rangeOver(next2)) {
            answer = Math.min(answer, cnt);
            return;
        }
        else if(!rangeOver(next1) && rangeOver(next2)) {
            answer = Math.min(answer, cnt);
            return;
        }
        if(map[next1.x][next1.y] == '#') next1 = new coin(c1.x, c1.y);
        if(map[next2.x][next2.y] == '#') next2 = new coin(c2.x, c2.y);
        for(int i = 0; i < 4; i++) {
            dfs(next1, next2, cnt + 1, i);
        }
    }

    private static boolean rangeOver(coin c) {
        return c.x < 0 || c.x >= N || c.y < 0 || c.y >= M;
    }

    private static void print() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static class coin {
        int x, y;
        coin(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
