package Programmers.BinarySearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import static Util.Constants.INPUT;

// stones 2, 4, 5, 3, 2, 1, 4, 2, 5, 1
// k 3
public class CrossingTheSteppingStone_2019_kakao_intern_4 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] stones = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(br.readLine());
        System.out.print(solution(stones, k));
    }

    public static int solution(int[] stones, int k) {
        int start = 1;
        int end = 200000000;
        int mid = 0; // ¡�˴ٸ��� �ǳ� �ο�
        int answer = 0;
        while(start <= end) {
            mid = (start + end) / 2;
            if(isJumpOk(stones, k, mid)) { // �߰������� �ǳ� �� �ִٴ� ���� �߰� ������ ���� ���� ��� �ǳ� �� ����
                start = mid + 1;
                answer = Math.max(answer, mid);
            } else { //  �߰������� �ǳ� �� ���ٴ� ���� �߰����� ū ���� ��� �ǳ� �� ����
                end = mid - 1;
            }
        }
        return answer;
    }

    public static boolean isJumpOk(int[] stones, int k, int mid) {
        int cnt = 0;
        for(int stone : stones) {
            if(stone < mid) {
                cnt++;
            } else {
                cnt = 0;
            }
            if(cnt == k) return false;
        }
        return true;
    }

//    public int solution(int[] stones, int k) {
//        int answer = 200000001;
//        // int ix = k - 1;
//        int s = 0; int e = 0;
//        int max = 0;
//        while(true) {
//            if(e - s == k) {
//                answer = Math.min(answer, max);
//                s++;
//            } else if(e >= stones.length) {
//                break;
//            } else {
//                max = Math.max(max, stones[e]);
//                e++;
//            }
//        }
//        // �ð��ʰ� �ڵ� ���� for��
//        // for(int i = 0; i < stones.length - (k - 1); i++) {
//        //     int max = 0;
//        //     for(int j = i; j <= ix; j++) {
//        //         if(max < stones[j]) {
//        //             max = stones[j];
//        //         }
//        //     }
//        //     ix++;
//        //     answer = Math.min(answer, max);
//        // }
//        return answer;
//    }
}
