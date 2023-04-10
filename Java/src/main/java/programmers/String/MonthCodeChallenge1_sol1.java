package programmers.String;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

public class MonthCodeChallenge1_sol1 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = solution(br.readLine());
        System.out.print(arr[0] + " " + arr[1]);
    }

    public static int[] solution(String s) {
        int[] answer = new int[2];
        int cnt1 = 0, cnt2 = 0;
        String str = s;
        while(true) {
            if(str.equals("1")) break;
            String temp = "";
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '0') cnt2++;
                else temp += str.charAt(i);
            }
            str = solve(temp.length());
            cnt1++;
        }
        answer[0] = cnt1;
        answer[1] = cnt2;
        return answer;
    }

    public static String solve(int len) {
        String str = "";
        while(len != 1) {
            str = (len % 2) + str;
            len = len / 2;
        }
        str = len + str;
        return str;
    }
}
