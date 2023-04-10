package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class StartAndLink_14889 {
    static int[][] map;
    static int MAX = 21, N;
    static int min = 987654321;
    static boolean[] check, check2;
    static int[] arr, arr2;
    static int sum = 0;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[MAX][MAX];
        arr = new int[N / 2];
        check = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1);
        System.out.print(min);
    }

    static void dfs(int k, int ix) {
        if(k == N / 2) {
            int[] temp = new int[N / 2];
            int idx = 0;
            for(int i = 1; i <= N; i++) {
                boolean b = false;
                for(int j = 0; j < N / 2; j++) {
                    if(arr[j] == i) b = true;
                }
                if(!b) temp[idx++] = i;
            }
            sum = 0;
            arr2 = new int[2];
            check2 = new boolean[N / 2];
            solve(arr, 0, 0);
            int r1 = sum;
            sum = 0;
            arr2 = new int[2];
            check2 = new boolean[N / 2];
            solve(temp, 0, 0);
            int r2 = sum;
            min = Math.min(min, Math.abs(r1 - r2));
            return;
        }
        for(int i = ix; i <= N; i++) {
            if(!check[i]) {
                check[i] = true;
                arr[k] = i;
                dfs(k + 1, i);
                check[i] = false;
            }
        }
    }

    static void solve(int[] a, int k, int ix) {
        if(k == 2) {
            sum += (map[arr2[0]][arr2[1]] + map[arr2[1]][arr2[0]]);
            return;
        }
        for(int i = ix; i < a.length; i++) {
            if(!check2[i]) {
                check2[i] = true;
                arr2[k] = a[i];
                solve(a, k + 1, i);
                check2[i] = false;
            }
        }
    }

    static void print() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
