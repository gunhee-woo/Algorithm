package BaekJoon.FloydWarshall;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;


import static Util.Constants.INPUT;

// �ƽ�Ű�ڵ� + �÷��̵� �ͼ� ����
// A => 65, a => 97 ���� ����, ���ĺ��� 26��, Z�� a ������ ���ĺ��� �ƴ� ���ڰ� 6�� ����
public class ProofOfProposition_2224 {
    static int MAX = 'z' - 'A' + 1;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] d = new int[MAX + 1][MAX + 1];
        for(int i = 1; i <= MAX; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);
            d[i][i] = 0;
        }
        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" => ");
            d[str[0].charAt(0) - 'A' + 1][str[1].charAt(0) - 'A' + 1] = 1;
        }
        for(int k = 1; k <= MAX; k++) {
            for(int i = 1; i <= MAX; i++) {
                for(int j = 1; j <= MAX; j++) {
                    if(d[i][k] != Integer.MAX_VALUE && d[k][j] != Integer.MAX_VALUE) {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i = 1; i <= MAX; i++) {
            for(int j = 1; j <= MAX; j++) {
                if(d[i][j] != Integer.MAX_VALUE && d[i][j] != 0 && i != j) { // ���ǰ� �İ��� ���� ���� ������� �ʱ�� �Ѵ�.
                    cnt++;
                    sb.append((char) (i + 'A' - 1)).append(" => ").append((char) (j + 'A' - 1)).append("\n");
                }
            }
        }
        System.out.println(cnt);
        System.out.print(sb.toString());
    }
}
