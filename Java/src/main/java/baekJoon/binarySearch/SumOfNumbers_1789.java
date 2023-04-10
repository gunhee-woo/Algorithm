package baekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

public class SumOfNumbers_1789 {
    static long N;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
//        long result = 0, i = 1;
//        int cnt = 0;
//        while(true) {
//            if(result > N) {
//                System.out.print(cnt - 1);
//                break;
//            }
//            result += i++;
//            cnt++;
//        }
        long left = 1, right = 93000; // sqrt(4294967295 * 2)
        while(left <= right) {
            long mid = (left + right) / 2;
            if(check(mid)) right = mid - 1;
            else left = mid + 1;
        }
        System.out.print(right);
    }

    public static boolean check(long n) {
        return n * (n + 1) / 2 > N;
    }
}
