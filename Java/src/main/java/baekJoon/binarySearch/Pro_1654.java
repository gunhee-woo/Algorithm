package baekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class Pro_1654 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[K];
        for(int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long start = 1; // 랜선의 길이는 자연수이므로
        long end = arr[K - 1];
        long answer = 0;
        while(start <= end) {
            long mid = (start + end) / 2;
            int cnt = 0;
            for(int i = 0; i < arr.length; i++) {
                cnt += (arr[i] / mid);
            }
            if(cnt >= N) {
                answer = Math.max(answer, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.print(answer);
    }
}
