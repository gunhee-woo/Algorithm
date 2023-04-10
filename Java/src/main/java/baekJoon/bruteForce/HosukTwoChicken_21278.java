package baekJoon.bruteForce;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// �÷��̵� �ͼ� + ����(��Ʈ��ŷ) + ���Ʈ����
// ġŲ���� ��� ��ġ�ϳ��� ����� ���� ���Ʈ������ ���ؼ� ã�´�
// N�� 100 �ۿ� �ȵǴ� ���� ���̹Ƿ� �÷��̵� �ͼ� �˰������� ��� ������ �ּҰŸ��� ����
// ġŲ���� ��ġ�� ��ҿ� ���� ������ ������ ���� �� ��带 ����
// ���� �� ��带 ���� ���� ������ ġŲ���� ã��
public class HosukTwoChicken_21278 {
    static int N, M;
    static int[][] d;
    static int INF = Integer.MAX_VALUE;
    static int[] arr;
    static boolean[] check;
    static Chicken chicken;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        d = new int[N + 1][N + 1];
        arr = new int[2];
        check = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            Arrays.fill(d[i], INF);
            d[i][i] = 0;
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            d[a][b] = Math.min(d[a][b], 2);
            d[b][a] = Math.min(d[b][a], 2);
        }
        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(d[i][k] != INF && d[k][j] != INF) {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                }
            }
        }
        dfs(0, 1);
        System.out.println(chicken.b1 + " " + chicken.b2 + " " + chicken.sum);
    }

    private static void dfs(int k, int ix) {
        if(k == 2) {
            int a = arr[0]; int b = arr[1];
            int[] dist = new int[N + 1];
            for(int i = 1; i <= N; i++)
                dist[i] = Math.min(d[i][a], d[i][b]);
            int sum = 0;
            for(int i = 1; i <= N; i++)
                sum += dist[i];
            if(chicken == null) {
                chicken = new Chicken(a, b, sum);
            } else {
                if(sum < chicken.sum) {
                    chicken = new Chicken(a, b, sum);
                } else if(sum == chicken.sum) {
                    if(a < chicken.b1) {
                        chicken = new Chicken(a, b, sum);
                    } else if(a == chicken.b1) {
                        if(b < chicken.b2) {
                            chicken = new Chicken(a, b, sum);
                        }
                    }
                }
            }
            return;
        }
        for(int i = ix; i <= N; i++) {
            if(!check[i]) {
                check[i] = true;
                arr[k] = i;
                dfs(k + 1, i);
                check[i] = false;
            }
        }
    }

    private static class Chicken {
        int b1; int b2; int sum;
        public Chicken(int b1, int b2, int sum) {
            this.b1 = b1;
            this.b2 = b2;
            this.sum = sum;
        }
    }


}
