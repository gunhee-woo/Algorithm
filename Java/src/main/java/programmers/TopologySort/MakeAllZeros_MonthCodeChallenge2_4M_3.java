package programmers.TopologySort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class MakeAllZeros_MonthCodeChallenge2_4M_3 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] edges = new int[a.length][2];
        for(int i = 0; i < a.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++) {
                edges[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(solution(a, edges));
    }

    public static long solution(int[] a, int[][] edges) {
        long answer = -2;
        return answer;
    }
}
