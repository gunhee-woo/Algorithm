package baekJoon.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class RemoteController_1107 {
    static int N, M;
    static boolean[] check;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        check = new boolean[10];
        if(M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                check[Integer.parseInt(st.nextToken())] = true;
            }
        }
        int min = Math.abs(N - 100);
        for(int i = 0; i < 1000000; i++) { // 브루트 포스 알고리즘
            int len = solve(i);
            if(len > 0) {
                min = Math.min(min, len + Math.abs(N - i));
            }
        }
        System.out.print(min);
    }

    static int solve(int k) {
        if(k == 0) {
            if(check[0]) return 0;
            else return 1;
        }
        int len = 0;
        while(k > 0) {
            if(check[k % 10]) return 0;
            k /= 10;
            len += 1;
        }
        return len;
    }
}
