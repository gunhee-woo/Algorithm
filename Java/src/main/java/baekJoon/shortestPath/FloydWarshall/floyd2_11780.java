package baekJoon.shortestPath.FloydWarshall;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

// 플로이드 와샬 알고리즘 응용 문제 => 각 점
public class floyd2_11780 {
    static int N, M;
    static int[][] d;
    static int INF = Integer.MAX_VALUE;
    static List<Integer>[][] set;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        d = new int[N + 1][N + 1];
        set = new List[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                d[i][j] = INF;
                set[i][j] = new ArrayList<>();
            }
            d[i][i] = 0;
        }
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            d[a][b] = Math.min(d[a][b], c);
        }
        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(i == j) continue;
                    if(d[i][k] != INF && d[k][j] != INF) {
                        if(d[i][j] > d[i][k] + d[k][j]) {
                            d[i][j] = d[i][k] + d[k][j];
                            if(!set[i][j].isEmpty()) set[i][j].clear();
                            if(!set[i][k].isEmpty()) {
                                set[i][j].addAll(set[i][k]);
                            }
                            set[i][j].add(k);
                            if(!set[k][j].isEmpty()) {
                                set[i][j].addAll(set[k][j]);
                            }
                        }
                    }
                }
            }
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(d[i][j] == INF) System.out.print(0 + " ");
                else System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
        for(int k = 1 + N; k <= N * N + N; k++) {
            int i = k / N;
            int j = k % N;
            if(j == 0) {
                i--;
                j += N;
            }
            if(d[i][j] == INF) System.out.println(0);
            else {
                if(set[i][j].isEmpty()) {
                    if(i == j) System.out.println(0);
                    else {
                        System.out.println(2 + " " + i + " " + j);
                    }
                }
                else {
                    System.out.print(2 + set[i][j].size() + " " + i + " ");
                    for(int val : set[i][j]) {
                        System.out.print(val + " ");
                    }
                    System.out.print(j);
                    System.out.println();
                }
            }
        }
    }
}
