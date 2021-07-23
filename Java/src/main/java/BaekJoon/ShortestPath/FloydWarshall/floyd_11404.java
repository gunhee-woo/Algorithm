package BaekJoon.ShortestPath.FloydWarshall;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import static Util.Constants.INPUT;

// �÷��̵� �ͼ� �˰���
// ��� �������� ��� ���������� �ִܰ�θ� ���Ҷ� ���, ���İ��� ������ �������� ��
// ������ k�� �ΰ� i���� j���� ���� �Ÿ��� i���� k���� ���ٰ� k���� j���� ���� �Ÿ��� ���Ͽ� �ּҰ��� �ִܰŸ��� ����
// ���ͽ�Ʈ�� �˰����� ���� ���� ����� �ϳ��� �����Ѵٸ� �÷��̵� �ͼ��� ���İ��� ������ �������� ����
// �⺻������ ���̳��� ���α׷����� ���
// ������ ���� V��ŭ �ݺ����� 3������ �����ϹǷ� �ð����⵵�� O(V^3), �׸��� �������� ������ V * V ũ�� ������Ŀ� ������Ƿ� �������⵵�� O(V^2)
public class floyd_11404 {
    static int INF = 1000000000;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] d = new int[N + 1][N + 1]; // ����� �����ϴ� �迭
        for(int i = 1; i <= N; i++) {
            Arrays.fill(d[i], INF); // ���Ѵ�� �ʱ�ȭ
            d[i][i] = 0; // A���� A�� ���� ����� �翬�� 0
        }

        for(int i = 0; i < M; i++) {
            int[] str = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            d[str[0]][str[1]] = Math.min(d[str[0]][str[1]], str[2]); // ���� ����� �Է��� �־��� �� �����Ƿ�
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(d[i][j] >= INF) sb.append("0 "); // ������ ������ �� ���� ���ð� ������ �� 0���� ����ϵ��� ��
                else sb.append(d[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
