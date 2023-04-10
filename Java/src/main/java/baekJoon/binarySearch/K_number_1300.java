package baekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

// 브루트포스로 풀면 시간초과 발생
// B[k] => k보다 작은 숫자의 개수를 구하자
// 1. A[i][j]에서 i행에 속한 숫자들은 모두 i의 배수이다
// 2. min(mid/i, N)이 i번째 행에서 mid보다 작은(임의의 k보다 작은) 숫자들의 개수
// 3. min을 쓰는 이유는 mid가 N을 넘어갈 수 있으므로
// 4. 1부터 N까지 모든 i행에 대해 m/i를 수행하며 카운트
// 5. O(logK)의 시간 복잡도
public class K_number_1300 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int left = 1, right = K, answer = 0;
        while(left <= right) {
            long cnt = 0;
            int mid = (left + right) / 2;
            for(int i = 1; i <= N; i++) cnt += Math.min(mid / i, N); // 각 행에 대해서 mid보다 작은 숫자들의 개수를 셈
            if(cnt < K) left = mid + 1;
            else {
                answer = mid;
                right = mid - 1;
            }
        }
        System.out.print(answer);
    }
}
