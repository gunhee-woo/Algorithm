package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// N개의 자연수 중에서 M개를 고른 수열
// 같은 수를 여러 번 골라도 된다.
public class n과m7_15656 {
    static int N, M;
    static int[] arr, value;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        value = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        sb = new StringBuilder();
        dfs(0);
        System.out.print(sb.toString());
    }

    public static void dfs(int k) {
        if(k == M) {
            for(int i = 0; i < M; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++) {
            arr[k] = value[i];
            dfs(k + 1);
        }
    }
}
