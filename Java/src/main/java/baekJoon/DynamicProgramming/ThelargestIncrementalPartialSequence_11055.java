package baekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import static Util.Constants.INPUT;

// 가장 큰 증가하는 부분 수열
public class ThelargestIncrementalPartialSequence_11055 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] d = new int[N];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i = 0; i < N; i++) {
            d[i] = arr[i];
            for(int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && d[j] + arr[i] > d[i])
                    d[i] = d[j] + arr[i];
            }
        }
    }
}
