package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class Subtotal_1806 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = 987654321, sum = 0, s = 0, e = 0;
        while(true) {
            if(sum >= S) {
                result = Math.min(result, e - s);
                sum -= arr[s++];
            } else if(e == N) {
                if(result == 987654321) result = 0;
                break;
            }
            else sum += arr[e++];
        }
        System.out.print(result);
    }
}
