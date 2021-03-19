package BaekJoon.String;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

public class Substring_16916 {
    static int ans = 0;
    static int[] getPi(String pattern) {
        int[] pi = new int[pattern.length()];
        int j = 0;
        for(int i = 1; i < pattern.length(); i++) {
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if(pattern.charAt(i) == pattern.charAt(j))
                pi[i] = ++j;
        }
        return pi;
    }

    static void KMP(String origin, String ptn) {
        int[] pi = getPi(ptn);
        int j=0;
        for(int i = 0; i < origin.length(); i++) {
            while(j > 0 && origin.charAt(i) != ptn.charAt(j)) {
                j = pi[j-1];
            }
            if(origin.charAt(i) == ptn.charAt(j)) {
                if(j == ptn.length() - 1) {
                    ans = 1;
                    break;
                }
                else
                    j++;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine();
        String pattern = br.readLine();
        KMP(origin, pattern);
        System.out.println(ans);
    }

    // 투포인터 => 시간초과
//    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream(INPUT));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String S = br.readLine();
//        String P = br.readLine();
//        int s = 0, k = P.length(), e = k;
//        while(true) {
//            if(e == S.length() + 1) {
//                System.out.print(0);
//                return;
//            }
//            if(S.substring(s, e).equals(P)) {
//                System.out.print(1);
//                return;
//            }
//            s++;
//            e++;
//        }
//    }

    // 부분문자열 백트래킹 => 이 문제는 연속된 문자열일 경우만 찾으므로 안됨
//    static boolean[] check;
//    static char[] ch;
//    static String S, P;
//    static boolean b = false;
//    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream(INPUT));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        S = br.readLine();
//        P = br.readLine();
//        check = new boolean[S.length()];
//        ch = new char[P.length()];
//        dfs(0, 0);
//        if(b) System.out.print(1);
//        else System.out.print(0);
//    }

//    static void dfs(int k, int ix) {
//        if(b) return;
//        if(k == P.length()) {
//            String str = String.valueOf(ch);
//            if(str.equals(P)) b = true;
//            return;
//        }
//        for(int i = ix; i < S.length(); i++) {
//            if(!check[i]) {
//                check[i] = true;
//                ch[k] = S.charAt(i);
//                dfs(k + 1, i);
//                if(b) break;
//                check[i] = false;
//            }
//        }
//    }
}
