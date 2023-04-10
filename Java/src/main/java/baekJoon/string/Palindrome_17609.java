package baekJoon.string;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

// 문자열 + 투포인터
public class Palindrome_17609 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String str = br.readLine();
            int s = 0, e = str.length() - 1;
            while(true) {
                if(s > e) {
                    System.out.println(0);
                    break;
                }
                if(str.charAt(s) != str.charAt(e)) {
                    if(check(s + 1, e, str) || check(s, e - 1, str)) {
                        System.out.println(1);
                    } else {
                        System.out.println(2);
                    }
                    break;
                }
                s++;
                e--;
            }
        }
    }

    static boolean check(int s, int e, String str) {
        while(true) {
            if(s > e) return true;
            if(str.charAt(s) != str.charAt(e)) return false;
            s++;
            e--;
        }
    }

}
