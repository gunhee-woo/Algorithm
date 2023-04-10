package baekJoon.bruteForce;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

public class NumContinueWrite_1748 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long result = 0;
        int m = 100000000;
        while(m >= 10) {
            if(m > n) {
                m /= 10;
                continue;
            }
            int k = n - m + 1;
            int len = String.valueOf(n).length();
            result += (k * len);
            n -= k;
            m /= 10;
        }
        result += n;
        System.out.print(result);
    }
}
