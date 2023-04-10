package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

// ��Ʈ��ŷ ����
// ������ ���� �ð����⵵�� ������ �� �Ȱ��µ� N�� ũ��� �ſ� �۾� ��Ʈ��ŷ���� Ǯ �� ���� �� ���ٸ�
// ���� ���� �� �ð��� �����ɸ����� ���̽��� ���� ������ �ð��ʰ��� ������ üũ
// �ð��� �ָ��ϸ� �ִ��� ����ȭ�� ��
// ���� �ð��� ������ ������ �ݵ帮 Release ���� ������ �ؾ� ��
// Release ���� ����� ������ �������� �ʾ� �ڵ带 ����ȭ�� �ӵ��� ũ��鿡�� ����

// *** ���� �� �ึ�� �ϳ����� ���� �� ���� ***
public class N_Queen_9663 {
    static int N;
    static boolean[] check1; // ���� ���� �ִ��� üũ
    static boolean[] check2; // ���� �ϴܺ��� ���� ��ܱ����� �밢���� ���� �ִ��� üũ
    static boolean[] check3; // ���� ��ܺ��� ���� �ϴܱ����� �밢���� ���� �ִ��� üũ
    static int cnt;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        check1 = new boolean[N];
        check2 = new boolean[N * 2 - 1];
        check3 = new boolean[N * 2 - 1];
        dfs(0);
        System.out.print(cnt);
    }

    // ���� �� ��(k)�� ������ �ִ����� ��͸� ���� üũ
    private static void dfs(int k) { // K�� ��, k��° �࿡ ���� �������̴�
        if(k == N) { // ���� �غκб��� �����ߴٸ� ���� ���� ���µ� �����ߴٴ� �� => cnt++
            cnt++;
            return;
        }
        for(int i = 0; i < N; i++) { // i�� ��
            if(!check1[i] && !check2[k + i] && !check3[k - i + N - 1]) { // ���� ���� �� �ִ��� üũ
                check1[i] = true;
                check2[k + i] = true;
                check3[k - i + N - 1] = true;
                dfs(k + 1); // ���� ������ �Ѿ
                check1[i] = false;
                check2[k + i] = false;
                check3[k - i + N - 1] = false;
            }
        }
    }
}
