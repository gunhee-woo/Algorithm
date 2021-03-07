package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

// 이런 문제는 답이 없다 유형을 외우도록 하자
// for문을 여러번 돌려서 찾으려고 하면 시간이 오래1 걸린다
//// 따라서 2차원 배열을 만들어 배열에 각 문자를 비교한다.
//// 비교하고 있는 문자가 같으면 이전 까지의 LCS에서 1을 더해준다
//// 다르면 이전 까지의 LCS에서 각 문자를 넣었을 때의 더 큰 값으로 LCS값을 갱신해준다
//// 표를 그려서 비교하는 문자가 같으면 왼쪽 대각선 + 1 다르다면 MAX(현재 위치 왼쪽 값, 현재 위치 위쪽 값)으로 갱신
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
                // 새로운 공통문자를 찾아냄
                if(c1[i - 1] == c2[j - 1]) {
                    d[i][j] = d[i - 1][j - 1] + 1;
                } else {
                    // 2차원 배열에서 현재 위치의 왼쪽값과 위쪽값을 비교하여 큰값으로 갱신
                    // 현재까지의 공통 문자열의 개수를 갱신
                    d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
                }
            }
        }
        System.out.print(d[c1.length][c2.length]);
    }
}
