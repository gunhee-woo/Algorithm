package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class SumOfSubsequences_1182 {
    static int N, S;
    static int[] arr;
    static int cnt;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dfs(0, 0);
        if(S == 0) cnt--; // 공집합일 경우 제거
        System.out.print(cnt);
    }

    private static void dfs(int k, int ix) {
       if(ix == N) {
           if(k == S) cnt++;
           return;
       }
       dfs(k, ix + 1); // ix번째 수를 더하지 않음
       dfs(k + arr[ix], ix + 1); // ix번째 수를 더함
    }
}
