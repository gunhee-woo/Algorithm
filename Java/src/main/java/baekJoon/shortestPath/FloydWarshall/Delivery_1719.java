package baekJoon.shortestPath.FloydWarshall;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// �÷��̵� �ͼ� �˰��� ���� => ���� ���� ���İ��� ��� ������ ����ϴ� ����
// N�� �ִ� 200�̹Ƿ� �÷��̵� �ͼ� �˰��� ������ ����
public class Delivery_1719 {
    static int N, M;
    static int[][] d;
    static String[][] v;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        d = new int[N + 1][N + 1];
        v = new String[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            Arrays.fill(d[i], INF);
            d[i][i] = 0;
            Arrays.fill(v[i], "-");
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            d[a][b] = Math.min(d[a][b], c);
            v[a][b] = String.valueOf(b);
            d[b][a] = Math.min(d[b][a], c);
            v[b][a] = String.valueOf(a);
        }
        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(d[i][k] != INF && d[k][j] != INF) {
                        if(d[i][j] > d[i][k] + d[k][j]) {
                            d[i][j] = d[i][k] + d[k][j];
                            if(Integer.parseInt(v[i][k]) != k) // ��������� ���� ���� ���İ� ��带 ã�°��̹Ƿ� d[i][k]�� ���İ� ��尡 ������ ����
                                v[i][j] = String.valueOf(v[i][k]);
                            else
                                v[i][j] = String.valueOf(k);
                        }
                    }
                }
            }
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
    }
}
