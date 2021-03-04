package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

public class FibonacciNumberExpansion_1788 {
    static int MAX = 1000001;
    static long[] d;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        d = new long[MAX];
        d[0] = 0;
        d[1] = 1;
        if(N < 0) {
            fibo(-N);
            if(N == -1) {
                System.out.println(1);
                System.out.print(1);
                return;
            }
            System.out.println(N % 2 == 0 ? -1 : 1);
            System.out.print(d[-N]);
        } else {
            fibo(N);
            if(N == 0) {
                System.out.println(0);
                System.out.print(0);
                return;
            }
            System.out.println(1);
            System.out.print(d[N]);
        }
    }

    public static void fibo(int N) {
        for(int i = 2; i <= N; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 1000000000;
        }
    }
}
