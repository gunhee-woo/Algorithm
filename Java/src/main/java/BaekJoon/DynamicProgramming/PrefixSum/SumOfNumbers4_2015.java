package BaekJoon.DynamicProgramming.PrefixSum;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// 주어지는 수가 음수를 포함한 정수이므로 투 포인터 알고리즘을 사용할 수 없음
// 또한 N의 최대값이 20만이므로 최대로 나올 수 있는 부분합의 개수는 200억 => 배열을 사용할 수 없음
// i부터 j까지의 부분합 K를 O(1)의 시간복잡도로 구하는 법 => sum[j] - sum[i - 1] = K
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
        Map<Integer, Integer> map = new HashMap<>(); // key : 부분합, value : 부분합의 갯수
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
