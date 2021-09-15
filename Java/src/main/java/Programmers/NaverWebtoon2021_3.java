package Programmers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

public class NaverWebtoon2021_3 {
    static int[][] answer;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] ans = solution(br.readLine());
        printArray(ans);
    }

    public static int[][] solution(String str) {
        String[] s = str.split(" ");
        arr = new int[s.length];
        int len = 1;
        for(int i = 0; i < s.length; i++) {
            len *= Integer.parseInt(s[i]);
            arr[arr.length - 1 - i] = Integer.parseInt(s[i]);
        }
        print(len);
        answer = new int[len][len];
//        set(1, 2, 0, 5, 1);
        rotate(0, 0, 0, len, 1);
        return answer;
    }

    public static int rotate(int x, int y, int ix, int ln, int k) {
        print("rotate - x : " + x + ", y : " + y + ", ix : " + ix + ", ln : " + ln + ", k : " + k);
        if(ix == arr.length - 1) {
            return set(x, y, 0, ln, k);
        }
        int n = arr[ix];
        int val = k;
        for(int i = x; i < x + ln; i += n) {
            for(int j = y; j < y + ln; j += n) {
                val += rotate(i, j, ix + 1, ln / n , val);
                print("val : " + val);
            }
        }
        return val;
    }


    public static int set(int x, int y, int ix, int n, int k) {
        //int[][] temp = new int[n * n][n * n];
        int full = k + n * n;
        while(k < full) {
            print("set - x : " + x + ", y : " + y + ", ix : " + ix + ", n : " + n + ", k : " + k);
            for(int i = y + ix; i < (n + y) - ix; i++) {
                answer[x + ix][i] = k;
                k++;
            }
            for(int i = x + 1 + ix; i < (n + x) - ix; i++) {
                answer[i][(n + y) - 1 - ix] = k;
                k++;
            }
            for(int i = (y + n) - 2 - ix; i >= y + ix; i--) {
                answer[(x + n) - 1 - ix][i] = k;
                k++;
            }
            for(int i = (x + n) - 2 - ix; i > x + ix; i--) {
                answer[i][y + ix] = k;
                k++;
            }
            ix++;
        }
        printArray(answer);
        return k;
        //return temp;
    }

    public static void printArray(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void print(Object o) {
        System.out.println(o);
    }
}
