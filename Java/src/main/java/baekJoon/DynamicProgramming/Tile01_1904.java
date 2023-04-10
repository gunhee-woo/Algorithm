package baekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

// �������� �Ǻ���ġ ���� ����
// ���ø� �����غ��� �Ǻ���ġ �������� �� �� ����
// ��ġ�� MAX�� 1000000 �̹Ƿ� int ũ�⸦ �Ѿ�� long Ÿ������ ���� �����ؾ� �Ѵ�
// �׸��� for������ ���� ����Ҷ����� 15746�� ������ ������ �����ؾ� �Ѵ�
public class Tile01_1904 {
    static int MAX = 1000001;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long d[] = new long[MAX];
        d[1] = 1;
        d[2] = 2;
        for(int i = 3; i <= N; i++)
            d[i] = (d[i - 1] + d[i - 2]) % 15746;
        System.out.print(d[N]);
    }
}
