package baekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// i��° �۾��� �����Ѵ�, �������� �ʴ´ٷ� ����� ����
// d[i] : i��° ���� �����ν� ��ԵǴ� �ִ�����
public class LeaveCompany_14501 {
    static int MAX = 16;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] time = new int[MAX];
        int[] profit = new int[MAX];
        int[] d = new int[MAX];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            profit[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        for(int i = 1; i <= N; i++) {
            // ����� ������ �� ��㿡 �ɸ��� �Ⱓ�� ������� ������ �ȵǹǷ�
            if(i + time[i] <= N + 1) { // i��° ����� ������ ��
                // d[i + time[i]] : ������(i) + i��° ����� �ϱ⿡ �ʿ��� �Ⱓ
                d[i + time[i]] = Math.max(d[i + time[i]], d[i] + profit[i]);
                result = Math.max(result, d[i + time[i]]);
            }
            // i��° ����� �������� ���� ��
            d[i + 1] = Math.max(d[i + 1], d[i]); // ����� �������� �ʾ����Ƿ� ������ ������ ����
            result = Math.max(result, d[i + 1]);
        }
        System.out.println(result);
        br.close();
    }
}
