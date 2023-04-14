package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// N���� �ڿ��� �߿��� M���� �� ����
// ��° �ٿ� N���� ���� �־�����. �Է����� �־����� ���� 10,000���� �۰ų� ���� �ڿ����̴�.
// ������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.
public class NandM5_15654 {
    static int N, M;
    static StringBuilder sb;
    static int[] arr, value;
    static boolean[] check;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        arr = new int[M];
        check = new boolean[N];
        value = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        dfs(0);
        System.out.print(sb.toString());
    }

    public static void dfs(int k) {
        if(k == M) {
            for(int i = 0; i < M; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!check[i]) {
                check[i] = true;
                arr[k] = value[i];
                dfs(k + 1);
                check[i] = false;
            }
        }
    }
}
