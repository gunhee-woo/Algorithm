package baekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

public class IntegerSquareRoot_2417 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long start = 0, end = (long) Math.sqrt(N);
        long mid = 0;
        while(start <= end) {
            mid = (start + end) / 2;
            if(mid >= Math.sqrt(N)) end = mid - 1;
            else start = mid + 1;
        }
        if(mid * mid == N) System.out.print(mid);
        else System.out.print(mid + 1);
    }
}
