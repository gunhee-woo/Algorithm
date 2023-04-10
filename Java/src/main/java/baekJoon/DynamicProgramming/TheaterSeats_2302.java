package baekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

public class TheaterSeats_2302 {
    static int MAX = 41;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final int M = Integer.parseInt(br.readLine());
        int[] d = new int[MAX];
        d[0] = 1;
        d[1] = 1;
        for (int i = 2; i <= N; i++)
            d[i] = d[i - 1] + d[i - 2];
        int result = 1;
        int pre = 0;
        for (int i = 0; i < M; i++) {
            int a = Integer.parseInt(br.readLine());
            result *= d[a - pre - 1];
            pre = a;
        }
        result *= d[N - pre];
        System.out.println(result);
        br.close();
    }
}

