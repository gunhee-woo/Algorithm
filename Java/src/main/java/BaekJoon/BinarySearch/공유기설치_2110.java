package BaekJoon.BinarySearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// 좌표의 최대 수가 1000000000 이므로 단순한 탐색을 실행할 경우 시간초과
// 거리를 기준으로 이분탐색 실행
// 최소거리는 1, 최대거리는 arr[n - 1] - arr[0]
// 가운데 값을 기준으로 공유기를 C대 이상 설치할 수 있는지 체크
public class 공유기설치_2110 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int start = 1;
        int end = arr[N - 1] - arr[0];
        int answer = 0;
        while(start <= end) {
            int mid = (start + end) / 2; // => 기준
            if(check(arr, mid, C)) { // 공유기를 C개 이상 설치할 수 있으면
                answer = Math.max(answer, mid);
                start = mid + 1; // 공유기를 줄여야 된다 => 기준을 높임
            } else { // 공유기를 더 설치해야 된다 => 기준을 낮춤
                end = mid - 1;
            }
        }
        System.out.print(answer);
    }

    private static boolean check(int[] arr, int mid, int c) { // 가운데 값을 기준으로 공유기 C개 이상 설치 체크
        int start = arr[0]; // 시작점
        int cnt = 1;
        for(int i = 1; i < arr.length; i++) {
            int d = arr[i] - start;
            if(mid <= d) { // 기준거리 이상이다 -> 공유기를 설치 할 수 있다
                cnt++;
                start = arr[i];
            }
        }
        return cnt >= c;
    }
}
