package BaekJoon.DynamicProgramming.PrefixSum;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class SumOfRemainder_10986 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] sum = new long[N + 1]; // ������ ����
        int[] remain = new int[M]; // �������� �� �������� ������ ����
        st = new StringTokenizer(br.readLine());
        long answer = 0;
        for(int i = 1; i <= N; i++) {
            long num = Long.parseLong(st.nextToken());
            sum[i] = sum[i - 1] + num;
            if(sum[i] % M == 0) answer++; // �������� M���� ������ �������� ������ ��
            remain[(int)(sum[i] % M)]++; // ������
        }
        for(int i = 0; i < M; i++) {
            // �������� �������� ������ ������ ����
            answer += (long) remain[i] * (long) (remain[i] - 1) / 2;
        }
        System.out.print(answer);
    }
}
