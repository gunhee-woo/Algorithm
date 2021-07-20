package BaekJoon.ShortestPath.FloydWarshall;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// 전형적인 플로이드 와샬 문제
public class SeoGangGround_14938 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] items = new int[n + 1];
        int[][] d = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);
            d[i][i] = 0;
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            d[a][b] = Math.min(d[a][b], c);
            d[b][a] = Math.min(d[b][a], c);
        }
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(d[i][k] != Integer.MAX_VALUE && d[k][j] != Integer.MAX_VALUE) {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                }
            }
        }
        int max = 0;
        for(int i = 1; i <= n; i++) {
            int val = 0;
            for(int j = 1; j <= n; j++) {
                if(d[i][j] > m) continue;
                val += items[j];
            }
            max = Math.max(max, val);
        }
        System.out.print(max);
    }
}
