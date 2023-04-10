package baekJoon.shortestPath.FloydWarshall;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// �÷��̵� �ͼ� �˰��� ���� ����
// �� ��尡 ��ǥ�� �־����� ��� ��ǥ�� ����� �� ����(���� ���� �����) => ���� ��� ��ǥ�� Ž���ϸ� ���� ���� ���� ���� �׷����� �׸�
// �������� �÷��̵� �ͼ� �˰����� ���Ͽ� �ּұ��̸� ������
// �����Լ��� Math.floor()
public class PowerPlantInstallation_1277 {
    static int N, W;
    static double M;
    static double[][] d;
    static double INF = 200001.0;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        M = Double.parseDouble(br.readLine());
        List<Point> list = new ArrayList<>();
        d = new double[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            Arrays.fill(d[i], INF);
            d[i][i] = 0.0;
        }
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x, y, i));
        }
        for(int i = 0; i < W; i++) { // �̹� ����Ǿ� �ִ� ��ǥ => ���̸� 0���� �ʱ�ȭ
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            d[a][b] = 0.0;
            d[b][a] = 0.0;
        }
        for(int i = 0; i < list.size() - 1; i++) {
            for(int j = 1; j < list.size(); j++) {
                Point p1 = list.get(i);
                Point p2 = list.get(j);
                double dist = distance(p1, p2);
                if(dist <= M) { // ���ѱ��� ����� ���� ����
                    d[p1.n][p2.n] = Math.min(d[p1.n][p2.n], dist);
                    d[p2.n][p1.n] = Math.min(d[p2.n][p1.n], dist);
                }
            }
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
        System.out.print((int)(Math.floor(d[1][N] * 1000)));
    }

    private static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(Math.abs(p1.x - p2.x), 2) + Math.pow(Math.abs(p1.y - p2.y), 2));
    }

    private static class Point {
        int x; int y; int n; // n�� ������ ��ȣ
        public Point(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }
}
