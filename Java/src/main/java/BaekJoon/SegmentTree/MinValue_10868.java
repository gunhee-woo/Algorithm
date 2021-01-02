package BaekJoon.SegmentTree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class MinValue_10868 {
    static long[] arr;
    static long[] tree;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        arr = new long[N];
        tree = new long[N * 4];
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        init(0, N - 1, 1);
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            System.out.println(query(0, N - 1, 1, l - 1, r - 1));
        }
    }

    private static long init(int start, int end, int node) {
        if(start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
    }

    private static long query(int start, int end, int node, int left, int right) {
        if(left > end || right < start) return 1000000000;
        if(left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return Math.min(query(start, mid, node * 2, left, right), query(mid + 1, end, node * 2 + 1, left, right));
    }
}
