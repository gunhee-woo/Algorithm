package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// 중복조합 (순서가 없고, 중복 O)
// 1부터 N까지 자연수 중에서 M개를 고른 수열
// 같은 수를 여러 번 골라도 된다.
// 고른 수열은 비내림차순이어야 한다. 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
public class NandM4_15652 {
    static int N, M;
    static StringBuilder sb;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        sb = new StringBuilder();
        dfs(0, 0);
        System.out.print(sb.toString());
    }

    public static void dfs(int k, int ix) {
        if(k == M) {
            for(int i = 0; i < M; i++)
                sb.append(arr[i] + 1).append(" ");
            sb.append("\n");
            return;
        }
        for(int i = ix; i < N; i++) {
            arr[k] = i;
            dfs(k + 1, i);
        }
    }
}
