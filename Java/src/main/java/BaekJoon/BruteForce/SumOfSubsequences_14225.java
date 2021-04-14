package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// 시간초과 코드
public class SumOfSubsequences_14225 {
    static int N, total;
    static int[] arr, temp;
    static int MAX = 2000001;
    static boolean[] check, numbers;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }
        numbers = new boolean[total + 1];
        for(int i = 1; i <= N; i++) {
            check = new boolean[N];
            temp = new int[i];
            dfs(0, i);
        }
        for(int i = 1; i <= total; i++) {
            if(!numbers[i]) {
                System.out.print(i);
                System.exit(0);
            }
        }
        System.out.print(total + 1);
    }

    static void dfs(int k, int n) {
        if(k == n) {
            int sum = 0;
            for(int i = 0; i < k; i++) {
                sum += temp[i];
            }
            numbers[sum] = true;
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!check[i]) {
                check[i] = true;
                temp[k] = arr[i];
                dfs(k + 1, n);
                check[i] = false;
            }
        }
    }
}
