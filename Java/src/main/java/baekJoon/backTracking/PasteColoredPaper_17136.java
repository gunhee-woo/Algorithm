package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class PasteColoredPaper_17136 {
    static int[][] arr;
    static int[] stk = {0, 5, 5, 5, 5, 5};
    static int min = 987654321;
    static int one = 0;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[10][10];
        for(int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[i][j] = val;
                if(val == 1) one++;
            }
        }
        dfs(0, 0);
        if(one == 100) System.out.print(4);
        else if(min == 987654321) System.out.print(-1);
        else System.out.print(min);
//        print();
    }

    static void dfs(int x, int y) {
        if(y >= 10) {
            dfs(x + 1, 0);
            return;
        }
        if(x >= 10) {
            min = Math.min(min, count());
            return;
        }

        if(arr[x][y] == 0) {
            dfs(x, y + 1);
            return;
        }

        for(int p = 1; p <= 5; p++) {
            if(check(x, y, p) && stk[p] >= 1) {
                paste(x, y, p);
                stk[p]--;
                dfs(x, y + p);
                stk[p]++;
                recovery(x, y, p);
            }
        }

//        for(int i = x; i < 10; i++) {
//            for(int j = y; j < 10; j++) {
//                if(arr[i][j] == 1) {
//                    for(int p = 1; p <= 5; p++) {
//                        if(check(i, j, p) && stk[p] >= 1) {
//                            paste(i, j, p);
//                            stk[p]--;
//                            one -= p * p;
//                            dfs(i, j + 1);
//                            one += p * p;
//                            stk[p]++;
//                            recovery(i, j, p);
//                        }
//                    }
//                }
//            }
//        }
    }

    static int count() {
        int c = 25;
        for(int i = 1; i <= 5; i++) {
            c -= stk[i];
        }
        return c;
    }

    static void recovery(int x, int y, int k) {
        for(int i = x; i < x + k; i++) {
            for(int j = y; j < y + k; j++) {
                arr[i][j] = 1;
            }
        }
    }

    static void paste(int x, int y, int k) {
        for(int i = x; i < x + k; i++) {
            for(int j = y; j < y + k; j++) {
                arr[i][j] = 0;
            }
        }
    }

    static boolean check(int x, int y, int k) {
        if(rangeOver(x, y, k)) return false;
        for(int i = x; i < x + k; i++) {
            for(int j = y; j < y + k; j++) {
                if(arr[i][j] == 0) return false;
            }
        }
        return true;
    }

    static boolean rangeOver(int x, int y, int k) {
        return x + k > 10 || y + k > 10;
    }

    static void print() {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
