package BaekJoon.String;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

// �տ��� �ڷ� �ε����� Ž���ϸ鼭 �ش� �κ��� ��ȣ�� �ߴ��� ���ߴ��� ���� üũ
public class AddingParentheses_16637_2 {
    static int N;
    static String str;
    static int max = -999999999; // ���� ���������� ����
    static int[] arr;
    static boolean[] check;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        arr = new int[N / 2];
        check = new boolean[N / 2];
        int ix = 0;
        for(int i = 0; i < N; i++) {
            if(!Character.isDigit(str.charAt(i))) {
                arr[ix++] = i;
            }
        }
        System.out.print(max);
    }

    static void dfs(int k) {
        if(k >= N) {

            return;
        }
        if(k + 2 < N) {

        }

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
