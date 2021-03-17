package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// 대표적인 투 포인터 알고리즘
// 시간복잡도 O(N)
// 투 포인터 알고리즘은 모든 원소가 자연수이어야 하고 구하고자 하는 수도 자연수이어야 성립 가능
// 두개의 포인터가 앞으로 진행하면서 포인터 사이의 원소를 더하여 구간합을 구함
// s,e라는 두 포인터가 있을 때, e가 뒤로 움직일 때는 새로 넘긴 원소를 sum에 더하고
// s가 뒤로 움직일 떄는 새로 넘긴 원소를 sum에서 빼는 방식
// 만약 구간합( [s, e) )이 구하고자 하는 값 M과 같다면 결과++
public class NumbersOfSum2_2003 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = 0, sum = 0, s = 0, e = 0;
        while(true) {
            if(sum >= M) sum -= arr[s++];
            else if(e == N) break;
            else sum += arr[e++];
            if(sum == M) result++;
        }
        System.out.print(result);
    }
}
