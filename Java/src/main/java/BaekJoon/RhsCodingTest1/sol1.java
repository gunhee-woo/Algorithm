package BaekJoon.RhsCodingTest1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

public class sol1 {
    static int min = 987654321, max = 0;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        dfs(N, 0);
        System.out.print(min + " " + max);
    }

    static void dfs(String n, int c) {
        c += countOddNum(n);
        if(n.length() >= 3) {
            for(int i = 1; i < n.length() - 1; i++) {
                for(int j = i + 1; j < n.length(); j++) {
                    String s1 = n.substring(0, i);
                    String s2 = n.substring(i, j);
                    String s3 = n.substring(j, n.length());
                    int r = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
//                    print(r + " " + c);
                    dfs(String.valueOf(r), c);
                }
            }
        }
        if(n.length() == 2) {
            int r = Integer.parseInt(n.substring(0, 1)) + Integer.parseInt(n.substring(1, 2));
//            print(r + " " + c);
            dfs(String.valueOf(r), c);
        }
        if(n.length() == 1) {
//            print(n + " " + c);
            min = Math.min(min, c);
            max = Math.max(max, c);
        }
    }

    static int countOddNum(String s) {
        int c = 0;
        for(int i = 0; i < s.length(); i++) {
            if(((s.charAt(i) - '0') % 2) != 0) {
                c++;
            }
        }
        return c;
    }

    static void print(Object o) {
        System.out.println(o);
    }
}
