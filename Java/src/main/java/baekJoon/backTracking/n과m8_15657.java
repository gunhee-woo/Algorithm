package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// N���� �ڿ��� �߿��� M���� �� ����
// ���� ���� ���� �� ��� �ȴ�.
// �� ������ �񳻸������̾�� �Ѵ�. ���̰� K�� ���� A�� A1 �� A2 �� ... �� AK-1 �� AK�� �����ϸ�, �񳻸������̶�� �Ѵ�.
public class n��m8_15657 {
    static int N, M;
    static int[] arr, value;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        value = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        sb = new StringBuilder();
        dfs(0, 0);
        System.out.print(sb.toString());
    }

    public static void dfs(int k, int ix) {
        if(k == M) {
            for(int i = 0; i < M; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }
        for(int i = ix; i < N; i++) {
            arr[k] = value[i];
            dfs(k + 1, i);
        }
    }
}
