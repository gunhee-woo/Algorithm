package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// 중복순열 (순서가 있고, 중복 O)
// 1부터 N까지 자연수 중에서 M개를 고른 수열
// 같은 수를 여러 번 골라도 된다.
public class n과m3_15651 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        arr = new int[M];
        dfs(0);
        System.out.print(sb.toString());
    }

    public static void dfs(int k) {
        if(k == M) {
            for(int i = 0; i < M; i++)
                sb.append(arr[i] + 1).append(" ");
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++) {
            arr[k] = i;
            dfs(k + 1);
        }
    }
}
