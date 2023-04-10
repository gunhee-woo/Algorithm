package baekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import static Util.Constants.INPUT;

// 투포인터 + 이분탐색
// 이분탐색처럼 중간 값을 구하지는 않고 합이 0에 가깝도록 업데이트
// 최대가 20억이므로 int 형으로 커버 할 수 있음
public class 두용액_2470 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int start = 0; int end = N - 1;
        int answer = Integer.MAX_VALUE;
        int[] list = new int[2];
        while(start < end) {
            int sum = arr[start] + arr[end];
            if(answer > Math.abs(sum)) {
                answer = Math.abs(sum);
                list[0] = arr[start];
                list[1] = arr[end];
                if(sum == 0) break;
            }
            if(sum < 0) { // 합이 0보다 작으므로 start 인덱스를 뒤로 옮겨 더 큰 값을 더하도록 함
                start++;
            } else { // 합이 0보다 크므로 end 인덱스를 앞으로 옮겨 더 작은 값을 더하도록 함
                end--;
            }
        }
        System.out.print(list[0] + " " + list[1]);
    }
}
