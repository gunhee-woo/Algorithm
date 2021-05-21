package BaekJoon.FloydWarshall;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;


import static Util.Constants.INPUT;

// 아스키코드 + 플로이드 와샬 문제
// A => 65, a => 97 부터 시작, 알파벳은 26개, Z와 a 사이의 알파벳이 아닌 문자가 6개 존재
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
                if(d[i][j] != Integer.MAX_VALUE && d[i][j] != 0 && i != j) { // 전건과 후건이 같은 경우는 출력하지 않기로 한다.
                    cnt++;
                    sb.append((char) (i + 'A' - 1)).append(" => ").append((char) (j + 'A' - 1)).append("\n");
                }
            }
        }
        System.out.println(cnt);
        System.out.print(sb.toString());
    }
}
