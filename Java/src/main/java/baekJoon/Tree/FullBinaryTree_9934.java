package baekJoon.Tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class FullBinaryTree_9934 {
    static int K;
    static int[] arr;
    static List<Integer>[] list;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        if(K == 1) {
            System.out.print(br.readLine());
            System.exit(0);
        }
        int n = (int) Math.pow(2, K) - 1;
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        list = new List[K];
        for(int i = 0; i < K; i++) list[i] = new ArrayList<>();
        dfs(0, n - 1, 0);
        for(int i = 0; i < K; i++) {
            for(int j = 0; j < list[i].size(); j++) {
                System.out.print(list[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int s, int e, int d) {
        if(s == e) {
            list[d].add(arr[s]);
            return;
        }
        int mid = (s + e) / 2;
        list[d].add(arr[mid]);
        dfs(s, mid - 1, d + 1);
        dfs(mid + 1, e, d + 1);
    }
}
