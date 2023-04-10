package baekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class Opening2_13902 {
    static List<Integer> list;
    static int[] arr;
    static boolean[] check;
    static int[] d; // i : 짜장면 그릇, d[i] : 최소 요리 횟수
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        check = new boolean[N + 1];
        d = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int k = Integer.parseInt(st.nextToken());
            list.add(k);
            check[k] = true;
        }
        int size = list.size();
        for(int i = 0; i < size - 1; i++) {
            for(int j = i + 1; j < size; j++) {
                int sum = list.get(i) + list.get(j);
                if(sum > N) continue;
                if(!check[sum]) {
                    check[sum] = true;
                    list.add(sum);
                }
            }
        }
//        dfs(0, 0);
//        list.addAll(cooks);

        for(int i = 0; i < list.size(); i++) {
            int val = list.get(i);
            d[val] = 1;
            for(int j = val + 1; j <= N; j++) {
                if(d[j - val] == 0) continue;
                if(d[j] == 0 || d[j] > d[j - val] + 1) {
                    d[j] = d[j - val] + 1;
                }
            }
        }
        if(d[N] == 0) System.out.print(-1);
        else System.out.print(d[N]);
    }

    private static void dfs(int k, int ix) {
        if(k == 2) {
            int sum = 0;
            for(int i = 0; i < 2; i++) {
                sum += arr[i];
            }
            list.add(sum);
            return;
        }
        for(int i = ix; i < list.size(); i++) {
            if(!check[i]) {
                check[i] = true;
                arr[k] = list.get(i);
                dfs(k + 1, i);
                check[i] = false;
            }
        }
    }
}
