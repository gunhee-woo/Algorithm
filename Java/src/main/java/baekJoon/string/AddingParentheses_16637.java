package baekJoon.string;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

// �տ��� �ڷ� �ε����� Ž���ϸ鼭 �ش� �κ��� ��ȣ�� �ϳ� ���ϳķ� dfs Ǯ��
public class AddingParentheses_16637 {
    static int N;
    static String str;
    static int max = -999999999; // ���� ���������� ����
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
        if(k + 2 < N) { // ��ȣ�� �Ѵ� => ��ȣ�� ġ�� 3���� ��� (���� �� ������ ��ȣ���� ��)
            int temp = cal(str.charAt(k) - '0', str.charAt(k + 2) - '0', str.charAt(k + 1));
            dfs(k + 4, cal(sum, temp, c));
        }
        // ��ȣ�� ���� �ʴ´� => (������ ������ ���簪)
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
