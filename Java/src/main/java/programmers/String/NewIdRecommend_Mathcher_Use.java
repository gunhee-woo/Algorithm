package programmers.String;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

public class NewIdRecommend_Mathcher_Use {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br.readLine());
    }

    public static String solution(String id) {
        String answer = id.toLowerCase(); // 1단계
        answer = answer.replaceAll("[^-_.a-z0-9]",""); // 2단계 -,_,.,소문자,숫자를 제외한 모든 문자를 제거
        System.out.println(answer);
        answer = answer.replaceAll("[.]{2,}", "."); // 3단계 .이 2개이상 연속으로 나오면 .하나로 치환
        System.out.println(answer);
        answer = answer.replaceAll("^[.]|[.]$", ""); // 4단계 문자열 시작과 끝에 .이 있으면 제거
        System.out.println(answer);
        if(answer.isEmpty()) answer += "a";
        System.out.println(answer);
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }
        System.out.println(answer);
        if(answer.length() <= 2) {
            while(!(answer.length() == 3))
                answer += answer.charAt(answer.length() - 1);
        }
        System.out.println(answer);
        return answer;
    }
}
