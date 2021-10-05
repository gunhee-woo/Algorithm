package BaekJoon.Bitmask;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// 비트마스크 + 백트래킹
// 알파벳 26개 상태 체크를 비트마스크로 표현
public class Teaching_1062 {
    static int N, K;
    static int[] d;
    static String[] strings;
    static int result = 0;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        strings = new String[N];
        for(int i = 0; i < N; i++) {
            strings[i] = br.readLine();
        }
        d = new int[1 << 26];
        if(K < 5) print(0);
        else {
            int stat = 0;
            stat |= (1 << ('a' - 'a'));
            stat |= (1 << ('c' - 'a'));
            stat |= (1 << ('i' - 'a'));
            stat |= (1 << ('n' - 'a'));
            stat |= (1 << ('t' - 'a'));
            dfs(K - 5, 0, stat);
            print(result);
        }
    }

    public static void dfs(int k, int ix, int stat) {
        if(k == 0) {
            int cnt = 0;
            for(int i = 0; i < strings.length; i++) {
                boolean check = true;
                for(int j = 0; j < strings[i].length(); j++) {
                    if((stat & (1 << strings[i].charAt(j) - 'a')) == 0) {
                        check = false;
                        break;
                    }
                }
                if(check) cnt++;
            }
            result = Math.max(result, cnt);
            return;
        }
        for(int i = ix; i < 26; i++) {
            if((stat & (1 << i)) == 0) {
                stat |= (1 << i);
                dfs(k - 1, i, stat);
                stat &= ~(1 << i);
            }
        }
    }

    public static void print(Object o) {
        System.out.print(o);
    }
}
