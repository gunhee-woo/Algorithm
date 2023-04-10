package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

// 중복 순열
public class p_1248 {
    static int N;
    static int[] arr;
    static char[][] map;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        map = new char[10][10];
        String str = br.readLine();
        int ix = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                map[i][j] = str.charAt(ix++);
            }
        }
        dfs(0);
    }

    static void dfs(int k) {
        if(k == N) {
            for(int i = 0; i < N; i++)
                System.out.print(arr[i] + " ");
            System.exit(0);
        }
        for(int i = -10; i <= 10; i++) {
            arr[k] = i;
            if(check(k)) dfs(k + 1);
        }
    }

    static boolean check(int k) {
        int sum = 0;
        for(int i = k; i >= 0; i--) {
            sum += arr[i];
            if(map[i][k] == '+' && sum <= 0) return false;
            if(map[i][k] == '-' && sum >= 0) return false;
            if(map[i][k] == '0' && sum != 0) return false;
        }
        return true;
    }


    static void print() {
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
