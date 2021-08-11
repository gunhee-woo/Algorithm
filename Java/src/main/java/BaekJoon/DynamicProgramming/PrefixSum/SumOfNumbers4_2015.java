package BaekJoon.DynamicProgramming.PrefixSum;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// �־����� ���� ������ ������ �����̹Ƿ� �� ������ �˰����� ����� �� ����
// ���� N�� �ִ밪�� 20���̹Ƿ� �ִ�� ���� �� �ִ� �κ����� ������ 200�� => �迭�� ����� �� ����
// i���� j������ �κ��� K�� O(1)�� �ð����⵵�� ���ϴ� �� => sum[j] - sum[i - 1] = K
public class SumOfNumbers4_2015 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        int[] sum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>(); // key : �κ���, value : �κ����� ����
        map.put(0, 1);
        long answer = 0;
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
            answer += map.getOrDefault(sum[i] - K, 0);
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        System.out.print(answer);
    }
}
