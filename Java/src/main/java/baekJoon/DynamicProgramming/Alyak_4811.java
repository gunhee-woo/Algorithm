package baekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

public class Alyak_4811 {
    static int MAX = 33;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] d = new long[MAX][MAX];
        for(int i = 0; i < MAX; i++) {
            for(int j = 0; j < MAX; j++) {
                if(i > j) continue;
                if(i == 0) d[j][i] = 1;
                else d[j][i] = d[j - 1][i] + d[j][i - 1];
            }
        }
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            System.out.println(d[N][N]);
        }
    }

}
