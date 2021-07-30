package BaekJoon.Bitmask;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// dfs + dp + ��Ʈ����ũ
// 2 <= N <= 16 �� ������ �����Ƿ� dfs�� �̿��� ����Ž���� �� �ð��ʰ� �߻�
public class TSP_2098 {
    static int N, maxBit;
    static int[][] cost;
    static int[][] dp; // ������ ����, ���� �湮�� ������ ����(��Ʈ����ũ�� ǥ��)�� 2���� �迭�� ����
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
        if(visit == maxBit) { // ��� ������ �湮�� ��� => ��� ���÷� ���ư��� ����
            if(cost[node][0] == 0) return INF; // ���ư��� ���� ����
            return cost[node][0];
        }
        // �޸������̼�, �̹� ����� ���� �����ϸ� ����� �� ����
        if(dp[node][visit] != INF) return dp[node][visit];
        // ��� ���� Ž��
        for(int i = 0; i < N; i++) {
            int next = visit | (1 << i); // i�� ������ �湮�ߴٴ� ���� üũ
            // i�� �������� �� ���� ���ų� �̹� i�� ������ �湮���� ���(��Ʈ����ũ & ������ ���� �� ������ �湮�߾����� üũ)
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
