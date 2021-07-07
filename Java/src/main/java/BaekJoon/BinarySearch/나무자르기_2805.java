package BaekJoon.BinarySearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// 이분탐색 응용문제
// 기준을 나무의 길이로 정해야 함
// 주의할점 : 나무의 높이가 최대 1,000,000,000 이므로 int 형 범위를 넘어서기에 long 형으로 해야함
public class 나무자르기_2805 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(arr);
        long start = 0;
        long end = arr[N - 1];
        long answer = 0;
        while(start <= end) {
            long mid = (start + end) / 2; // 기준, 절단기의 높이
            long sum = 0;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] > mid) // 음수가 나올 수 있으므로
                    sum += arr[i] - mid;
            }
            if(sum >= M) { // 적어도 M미터의 나무를 갖고가야 한다는 조건이 있으므로
                answer = Math.max(answer, mid);
                start = mid + 1; // 가져가야 하는 나무의 개수를 줄여도 됨, 높이를 최대로 하는 값을 찾아야 하므로 => 절단기 높이를 높임
            } else { // 가져가야 하는 나무의 개수를 늘려야 함 => 절단기 높이를 낮춤
                end = mid - 1;
            }
        }
        System.out.print(answer);
    }
}
