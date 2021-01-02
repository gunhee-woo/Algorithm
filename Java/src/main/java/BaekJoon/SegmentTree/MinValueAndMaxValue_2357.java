package BaekJoon.SegmentTree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class MinValueAndMaxValue_2357 {
    static long[] arr;
    static pair[] tree; // first Min, second Max
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        arr = new long[N];
        tree = new pair[N * 4];
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        init(0, N - 1, 1);
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            pair res = query(0, N - 1, 1, left - 1, right - 1);
            System.out.println(res.first + " " + res.second);
        }
    }

    private static pair init(int start, int end, int node) {
        if(start == end) {
            tree[node] = new pair(arr[start], arr[start]);
            return tree[node];
        }
        int mid = (start + end) / 2;
        pair left = init(start, mid, node * 2);
        pair right = init(mid + 1, end, node * 2 + 1);
        return tree[node] = new pair(Math.min(left.first, right.first), Math.max(left.second, right.second));
    }

    private static pair query(int start, int end, int node, int left, int right) {
        if(left > end || right < start) return new pair(1000000000, 0);
        if(left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        pair l = query(start, mid, node * 2, left, right);
        pair r = query(mid + 1, end, node * 2 + 1, left, right);
        return new pair(Math.min(l.first, r.first), Math.max(l.second, r.second));
    }
}

class pair {
    public long first;
    public long second;

    public pair(long first, long second) {
        this.first = first;
        this.second = second;
    }
}
