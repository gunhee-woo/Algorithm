package BaekJoon.Bitmask;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// dfs + dp + 비트마스크
// 2 <= N <= 16 의 조건이 있으므로 dfs를 이용한 완전탐색할 시 시간초과 발생
public class TSP_2098 {
    static int N, maxBit;
    static int[][] cost;
    static int[][] dp; // 현재의 정점, 현재 방문한 도시의 상태(비트마스크로 표현)를 2차원 배열로 저장
    static int INF = 987654321;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maxBit = (1 << N) - 1;
        cost = new int[N][N];
        dp = new int[N][(1 << N) - 1];
        for(int i = 0; i < N; i++) Arrays.fill(dp[i], INF);
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        print();
        System.out.print(dfs(0, 1));
    }

    private static int dfs(int node, int visit) {
        if(visit == maxBit) { // 모든 지점을 방문한 경우 => 출발 도시로 돌아가고 종료
            if(cost[node][0] == 0) return INF; // 돌아가는 길이 없다
            return cost[node][0];
        }
        // 메모이제이션, 이미 계산한 값이 존재하면 계산한 값 리턴
        if(dp[node][visit] != INF) return dp[node][visit];
        // 모든 지점 탐색
        for(int i = 0; i < N; i++) {
            int next = visit | (1 << i); // i번 지점을 방문했다는 것을 체크
            // i번 지점으로 갈 길이 없거나 이미 i번 지점을 방문했을 경우(비트마스크 & 연산을 통해 그 지점이 방문했었는지 체크)
            if(cost[node][i] == 0 || (visit & (1 << i)) != 0) continue;
            dp[node][visit] = Math.min(dp[node][visit], dfs(i, next) + cost[node][i]);
        }
        return dp[node][visit];
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
