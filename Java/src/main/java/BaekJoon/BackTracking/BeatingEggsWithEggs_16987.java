package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class BeatingEggsWithEggs_16987 {
    static int N;
    static egg[] arr;
    static boolean[] check; // 계란이 깨진 계란인지 아닌지 체크
    static int count = 0;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new egg[N];
        check = new boolean[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        dfs(0, 0, 0,false);
        System.out.print(count);
    }

    // k는 손에 쥐고 있는 계란 인덱스
    // ix는 K와 부딪힐 계란의 인덱스
    // cnt는 k번째 계란이 깬 계란의 갯수
    // b는 k번째 계란이 깨졌냐
    private static void dfs(int k, int ix, int cnt, boolean b) {
        if(b) {

            return;
        }
        for(int i = k + 1; i < N; i++) {
            if(!check[i]) {


            }
        }
    }

    private static void solve(int k, int i) {
        if(arr[k].s - arr[i].w <= 0) {

        } else {

        }
        if(arr[i].s - arr[k].w <= 0) {

        } else {

        }
    }

    static class egg {
        int s;
        int w;
        egg(int s, int w) {
            this.s = s;
            this.w = w;
        }
    }
}
