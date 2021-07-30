package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// dfs
// N이 10 이하이므로 완전탐색으로 최소 값 찾을 수 있음
public class TSP2_10971 {
    static int N;
    static int[][] cost;
    static boolean[] check;
    static int start; // 어느 점에서 시작했는지 저장 => 순회를 위해 나중에 다시 돌아갈 지점을 저장함
    static int answer = 987654321;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N; i++) {
            check = new boolean[N];
            start = i;
            check[i] = true;
            dfs(i, 0, 0);
        }
        System.out.print(answer);
    }

    private static void dfs(int n, int s, int cnt) {
        if(cnt == N - 1) { // 마지막점에 도달
            if(cost[n][start] != 0) { // 순회를 위해 시작점으로 돌아가는 길이 존재하는지 체크 존재하면 최소값 비교해서 갱신
                answer = Math.min(answer, s + cost[n][start]);
                return;
            }
        }
        for(int i = 0; i < N; i++) {
            if(!check[i] && cost[n][i] != 0) { // 아직 방문안했는지, 길이 없는지 체크
                check[i] = true;
                dfs(i, s + cost[n][i], cnt + 1);
                check[i] = false;
            }
        }
    }

    private static void print() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(cost[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
