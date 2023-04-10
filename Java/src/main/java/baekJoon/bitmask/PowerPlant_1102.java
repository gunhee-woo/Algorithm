package baekJoon.bitmask;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class PowerPlant_1102 {
    static int[][] cost;
    static int N, P;
    static int[] d;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        d = new int[1 << N];
        Arrays.fill(d, -1);
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        String str = br.readLine();
        P = Integer.parseInt(br.readLine());

        int stat = 0; int cnt = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'Y') {
                stat = stat | (1 << i);
                cnt++;
            }
        }
        if(cnt == 0) { // NNN, N만 존재할때
            if(P == 0) System.out.print(0);
            else System.out.print(-1);
        } else if(cnt >= P) {
            System.out.print(0);
        } else {
            System.out.print(dfs(cnt, stat));
        }
    }

    private static int dfs(int k, int stat) {
        if(k >= P) return 0;
        if(d[stat] != -1) return d[stat]; // 메모이제이션
        d[stat] = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            if((stat & (1 << i)) == (1 << i)) { // 현재 켜진 발전기를 찾고
                for(int j = 0; j < N; j++) {
                    if(i == j) continue;
                    if((stat & (1 << j)) == 0) { // 꺼진 발전기를 찾음
                        d[stat] = Math.min(d[stat], dfs(k + 1, stat | (1 << j)) + cost[i][j]);
                    }
                }
            }
        }
        return d[stat];
    }
}
