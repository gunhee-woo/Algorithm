package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// 조합 문제
// N개의 수 중에서 6개의 수를 중복을 허용하지 않고 순서가 없도록 뽑으면 됨
public class Lotto_6603 {
    static int N;
    static int[] value, arr;
    static boolean[] check;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N == 0) return;
            value = new int[N];
            arr = new int[6];
            check = new boolean[N];
            for(int i = 0; i < N; i++)
                value[i] = Integer.parseInt(st.nextToken());
            dfs(0, 0);
            System.out.println();
        }
    }

    private static void dfs(int k, int ix) {
        if(k == 6) {
            for(int i = 0; i < 6; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }
        for(int i = ix; i < N; i++) {
            if(!check[i]) {
                check[i] = true;
                arr[k] = value[i];
                dfs(k + 1, i);
                check[i] = false;
            }
        }
    }
}
