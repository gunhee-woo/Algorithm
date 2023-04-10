package baekJoon.twoPointer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// 투 포인터 알고리즘
// 10,000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다. 이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이
// 모든 수가 자연수이므로 투 포인터 성립가능
public class Subtotal_1806 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = 987654321, sum = 0, s = 0, e = 0;
        while(true) {
            if(sum >= S) { // 합이 S를 넘어가면 포인터를 앞으로 당겨서 합을 줄임
                result = Math.min(result, e - s);
                sum -= arr[s++];
            } else if(e == N) { // 끝에 도달하면 break
                if(result == 987654321) result = 0;
                break;
            }
            else sum += arr[e++];
        }
        System.out.print(result);
    }
}
