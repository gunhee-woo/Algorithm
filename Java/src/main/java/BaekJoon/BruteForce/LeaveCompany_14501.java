package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class LeaveCompany_14501 {
    static int MAX = 16;
    static int time[];
    static int profit[];
    static int answer;
    static int N;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        time = new int[MAX];
        profit = new int[MAX];
        answer = 0;
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            time[i] = t;
            profit[i] = p;
        }
        dfs(1, 0);
        System.out.println(answer);
    }

    public static void dfs(int ct, int cp) { // �����ϰ� ���������� ���ڷ� ����
        if(ct >= N + 1) {
            answer = Math.max(answer, cp);
            return;
        }
        // �ش��Ͽ� ����� �����Ѵ�
        if(ct + time[ct] <= N + 1) dfs(ct + time[ct], cp + profit[ct]);
        // �ش��Ͽ� ����� �������� �ʴ´�
        if(ct + 1 <= N + 1) dfs(ct + 1, cp);
    }
}
