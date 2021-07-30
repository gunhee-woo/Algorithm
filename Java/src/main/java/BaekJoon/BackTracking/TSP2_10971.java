package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// dfs
// N�� 10 �����̹Ƿ� ����Ž������ �ּ� �� ã�� �� ����
public class TSP2_10971 {
    static int N;
    static int[][] cost;
    static boolean[] check;
    static int start; // ��� ������ �����ߴ��� ���� => ��ȸ�� ���� ���߿� �ٽ� ���ư� ������ ������
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
        if(cnt == N - 1) { // ���������� ����
            if(cost[n][start] != 0) { // ��ȸ�� ���� ���������� ���ư��� ���� �����ϴ��� üũ �����ϸ� �ּҰ� ���ؼ� ����
                answer = Math.min(answer, s + cost[n][start]);
                return;
            }
        }
        for(int i = 0; i < N; i++) {
            if(!check[i] && cost[n][i] != 0) { // ���� �湮���ߴ���, ���� ������ üũ
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
