package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// �ߺ����� (������ �ְ�, �ߺ� O)
// 1���� N���� �ڿ��� �߿��� M���� �� ����
// ���� ���� ���� �� ��� �ȴ�.
public class n��m3_15651 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        arr = new int[M];
        dfs(0);
        System.out.print(sb.toString());
    }

    public static void dfs(int k) {
        if(k == M) {
            for(int i = 0; i < M; i++)
                sb.append(arr[i] + 1).append(" ");
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++) {
            arr[k] = i;
            dfs(k + 1);
        }
    }
}
