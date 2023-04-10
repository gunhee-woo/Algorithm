package baekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import static Util.Constants.INPUT;

public class TriangularGraph_4883 {
    static int MAX = 100001;
    static int INF = 987654321;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int k = 1; ; k++) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) return;
            long[][] arr = new long[MAX][3];
            long[][] d = new long[MAX][3];
            Arrays.stream(d).forEach(a -> Arrays.fill(a, 0)); // 2차원 배열 값 초기화 방법
            for(int i = 0; i < N; i++)
               arr[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            d[0][0] = INF;
            d[0][1] = arr[0][1];
            d[0][2] = d[0][1] + arr[0][2];
            for(int i = 1; i < N; i++) {
                d[i][0] = Math.min(d[i - 1][0], d[i - 1][1]) + arr[i][0];
                d[i][1] = Math.min(Math.min(d[i - 1][0], d[i - 1][1]), Math.min(d[i - 1][2], d[i][0])) + arr[i][1];
                d[i][2] = Math.min(d[i - 1][1], Math.min(d[i - 1][2], d[i][1])) + arr[i][2];
            }
            System.out.println(k + ". " + d[N - 1][1]);
        }
    }
}
