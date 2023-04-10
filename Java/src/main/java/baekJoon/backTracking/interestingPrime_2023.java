package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

// 중복순열 + 에라토스테네스의 체
public class interestingPrime_2023 {
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        dfs(0);
    }

    public static void dfs(int k) {
        if(k == N) {
            print(sb.toString() + "\n");
            return;
        }
        for(int i = 1; i <= 9; i++) {
            sb.append(i);
            if(isPrime(Integer.parseInt(sb.toString()))) {
                dfs(k + 1);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static boolean isPrime(int num) {
        if(num == 1) return false;
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    public static void print(Object o) {
        System.out.print(o);
    }
}
