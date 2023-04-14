package baekJoon.backTracking;

import java.io.FileInputStream;
import java.util.Scanner;

import static Util.Constants.INPUT;

// ���� (������ �ְ� �ߺ� X)
// 1���� N���� �ڿ��� �߿��� �ߺ� ���� M���� �� ����
public class NandM1_15649 {
    static int N, M;
    static int[] arr; // ������ ��� �ڷᱸ�� => ũ�⸦ M�� ����
    static boolean[] check; // �ش� ���� ������ ����ߴ��� üũ => ũ�⸦ N�� ���� => ������ �ߺ����̶�� ������ �����Ƿ�
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        check = new boolean[N]; // true�� �ش� ���ڸ� ����ߴ� false�� ������� �ʾҴ�
        dfs(0);
    }

    // k�� arr�� ����, ���� arr�� �־���ϴ� ��ġ �ε���
    public static void dfs(int k) {
        if(k == M) { // arr�� ��á�ٸ�
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++)
                sb.append(arr[i] + 1).append(" "); // 0���� m-1������ �ƴ϶�  1���� m���� �̹Ƿ� 1�� ����
            System.out.println(sb.toString());
            return;
        }
        for(int i = 0; i < N; i++) { // 1���� N������ ���� ����
            if(!check[i]) { // i�� ���� ������� �ʾҴٸ�
                arr[k] = i;
                check[i] = true;
                dfs(k + 1); // ���� ���� ���Ϸ� ��
                check[i] = false; // k��° ���� i�� ���� ��� ��쿡 ���� Ȯ�������� i�� ������� �ʾҴٰ� ���
            }
        }
    }
}
