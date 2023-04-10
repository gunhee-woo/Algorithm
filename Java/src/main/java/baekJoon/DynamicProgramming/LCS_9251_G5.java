package baekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

// �̷� ������ ���� ���� ������ �ܿ쵵�� ����
// for���� ������ ������ ã������ �ϸ� �ð��� ����1 �ɸ���
//// ���� 2���� �迭�� ����� �迭�� �� ���ڸ� ���Ѵ�.
//// ���ϰ� �ִ� ���ڰ� ������ ���� ������ LCS���� 1�� �����ش�
//// �ٸ��� ���� ������ LCS���� �� ���ڸ� �־��� ���� �� ū ������ LCS���� �������ش�
//// ǥ�� �׷��� ���ϴ� ���ڰ� ������ ���� �밢�� + 1 �ٸ��ٸ� MAX(���� ��ġ ���� ��, ���� ��ġ ���� ��)���� ����
public class LCS_9251_G5 {
    static int MAX = 1001;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c1 = br.readLine().toCharArray();
        char[] c2 = br.readLine().toCharArray();
        int[][] d = new int[MAX][MAX];
        for(int i = 1; i <= c1.length; i++) {
            for(int j = 1; j <= c2.length; j++) {
                // ���ο� ���빮�ڸ� ã�Ƴ�
                if(c1[i - 1] == c2[j - 1]) {
                    d[i][j] = d[i - 1][j - 1] + 1;
                } else {
                    // 2���� �迭���� ���� ��ġ�� ���ʰ��� ���ʰ��� ���Ͽ� ū������ ����
                    // ��������� ���� ���ڿ��� ������ ����
                    d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
                }
            }
        }
        System.out.print(d[c1.length][c2.length]);
    }
}
