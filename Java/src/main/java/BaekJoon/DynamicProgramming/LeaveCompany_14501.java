package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// i번째 작업을 수행한다, 수행하지 않는다로 나누어서 생각
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
            if(i + time[i] <= N + 1) { // i번째 상담을 진행할 때
                d[i + time[i]] = Math.max(d[i + time[i]], d[i] + profit[i]);
                result = Math.max(result, d[i + time[i]]);
            }
            // i번째 상담을 진행하지 않을 때
            d[i + 1] = Math.max(d[i + 1], d[i]);
            result = Math.max(result, d[i + 1]);
        }
        System.out.println(result);
        br.close();
    }
}
