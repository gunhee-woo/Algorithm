package BaekJoon.BackTracking;

import AlgorithmStudy.Array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class CreatePassword_1759 {
    static int N, M;
    static char[] value, arr;
    static boolean[] check;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        value = br.readLine().toCharArray();
        arr = new char[N];
        check = new boolean[M];
        dfs(0, 0, 0, 0);
    }

    private static void dfs(int k, int ix, int a, int b) {
        if(k == N) {
            if(a > 0 && b > 1) {
                for(int i = 0; i < N; i++)
                    System.out.print(arr[i]);
                System.out.println();
                return;
            }
            return;
        }
        for(int i = ix; i < M; i++) {
            if(!check[i]) {
                check[i] = true;

            }
        }
    }

    private static boolean isVowel(char c) {
        char[] ch = {'a', 'e', 'i', 'o', 'u'};
        return Arrays.stream(ch).



    }
}
