package baekJoon.SegmentTree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// int 형의 범위는 -2,147,483,648 ~ 2,147,483,647 약 20억
// long 형의 범위는 -9,223,372,036,854,775,808 ~ +9,223,372,036,854,775,807
// C++ long long 형 == Java long 형

public class SumofIntervals_2042 {
    static long[] arr;
    static long[] tree;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        arr = new long[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        tree = new long[N * 4];
        init(0, N - 1, 1);
        for(int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 1) {
                b -= 1;
                long diff = c - arr[b];
                arr[b] = c;
                update(0, N - 1, 1, b, diff);
            } else {
                System.out.println(sum(0, N - 1, 1, b - 1, c - 1));
            }
        }
    }

    private static long init(int start, int end, int node) {
        if(start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    private static long sum(int start, int end, int node, int left, int right) {
        if(left > end || right < start) return 0;
        if(left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    private static void update(int start, int end, int node, int index, long dif) {
        if(index < start || index > end) return;
        tree[node] += dif;
        if(start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, dif);
        update(mid + 1, end, node * 2 + 1, index, dif);
    }
}
