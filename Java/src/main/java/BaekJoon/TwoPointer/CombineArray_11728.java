package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class CombineArray_11728 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] a = new int[N];
        int[] b = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) b[i] = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int ax = 0, bx = 0;
        while(true) {
            if(ax == N) {
                while(bx != M) sb.append(b[bx++]).append(" ");
                break;
            }
            if(bx == M) {
                while(ax != N) sb.append(a[ax++]).append(" ");
                break;
            }
            if(a[ax] > b[bx]) {
                sb.append(b[bx++]).append(" ");
//                System.out.print(b[bx++] + " ");
            } else {
//                System.out.print(a[ax++] + " ");
                sb.append(a[ax++]).append(" ");
            }
        }
        System.out.print(sb.toString());
    }
}
