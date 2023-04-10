package baekJoon.bruteForce;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class DateCalculation_1476 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int e = 1, s = 1, m = 1;
        int count = 1;
        while(true) {
            if(e == 16) e = 1;
            if(s == 29) s = 1;
            if(m == 20) m = 1;
            if(e == E && s == S && m == M) {
                System.out.print(count);
                break;
            }
            e++;
            s++;
            m++;
            count++;
        }
    }
}
