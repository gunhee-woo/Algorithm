package baekJoon.string;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

// 앞에서 뒤로 인덱스를 탐색하면서 해당 부분이 괄호를 하냐 안하냐로 dfs 풀이
public class AddingParentheses_16637 {
    static int N;
    static String str;
    static int max = -999999999; // 음수 최저값으로 설정
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        dfs(0, 0);
        System.out.print(max);
    }

    static void dfs(int k, int sum) {
        if(k >= N) {
            max = Math.max(max, sum);
            return;
        }
        char c = k == 0 ? '+' : str.charAt(k - 1);
        if(k + 2 < N) { // 괄호를 한다 => 괄호를 치면 3개를 사용 (이전 값 연산자 괄호안의 값)
            int temp = cal(str.charAt(k) - '0', str.charAt(k + 2) - '0', str.charAt(k + 1));
            dfs(k + 4, cal(sum, temp, c));
        }
        // 괄호를 하지 않는다 => (이전값 연산자 현재값)
        dfs(k + 2, cal(sum, str.charAt(k) - '0', c));
    }

    static int cal(int a, int b, char c) {
        int result = a;
        switch (c) {
            case '+':
                result += b;
                break;
            case '*':
                result *= b;
                break;
            case '-':
                result -= b;
                break;
        }
        return result;
    }
}
