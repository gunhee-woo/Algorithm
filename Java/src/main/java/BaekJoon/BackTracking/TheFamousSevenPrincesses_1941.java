package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

public class TheFamousSevenPrincesses_1941 {
    static char[][] map;
    static boolean[] check;
    static int[] arr;
    static int[] ax = {-1,1,0,0};
    static int[] ay = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        check = new boolean[25];
        arr = new int[7];
        for(int i = 0; i < 5; i++) {
           map[i] = br.readLine().toCharArray();
        }

    }

    private static void dfs(int k, int ix, int cnt) {
        if(k == 7) {
            if(cnt == 4) {
                // TODO BFS Å½»ö
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
}
