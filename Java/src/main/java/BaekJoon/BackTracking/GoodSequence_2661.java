package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

public class GoodSequence_2661 {
    static int N;
    static StringBuilder sb;
    static boolean isStop;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        dfs(0);
    }

    public static void dfs(int k) {
        if(isStop) return;
        if(k == N) {
            isStop = true;
            System.out.print(sb.toString());
            return;
        }
        for(int i = 1; i <= 3; i++) {
            sb.append(i);
            if(check(sb.toString()))
                dfs(k + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static boolean check(String str) {
        int start = str.length() - 1;
        int end = str.length();
        for(int i = 1; i <= str.length() / 2; i++) {
            if(str.substring(start - i, end - i).equals(str.substring(start, end))) {
                return false;
            }
            start -= 1;
        }
        return true;
    }
}
