package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

// �ߺ��� ������� �ʰ� ������ ���� => ����
// ������ �ִ� ���� ����
public class CreatePassword_1759 {
    static int L, C;
    static char[] arr, value;
    static boolean[] check;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        value = new char[C];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++)
            value[i] = st.nextToken().charAt(0);
        Arrays.sort(value);
        arr = new char[L];
        check = new boolean[C];
        dfs(0, 0, 0, 0);
    }

    private static void dfs(int k, int ix, int a, int b) { // a�� �� ���ڿ��� ���� ����, b�� ���� ������ ����
        if(k == L) {
            if(a > 0 && b > 1) {
                for(int i = 0; i < L; i++)
                    System.out.print(arr[i]);
                System.out.println();
            }
            return;
        }
        for(int i = ix; i < C; i++) {
            if(!check[i]) {
                check[i] = true;
                arr[k] = value[i];
                if(isVowels(value[i])) dfs(k + 1, i, a + 1, b); // ���ڰ� �����̹Ƿ� 1�� ���ϰ� ���
                else dfs(k + 1, i, a, b + 1);
                check[i] = false;
            }
        }
    }

    private static boolean isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
