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
        String answer = id.toLowerCase(); // 1�ܰ�
        answer = answer.replaceAll("[^-_.a-z0-9]",""); // 2�ܰ� -,_,.,�ҹ���,���ڸ� ������ ��� ���ڸ� ����
        System.out.println(answer);
        answer = answer.replaceAll("[.]{2,}", "."); // 3�ܰ� .�� 2���̻� �������� ������ .�ϳ��� ġȯ
        System.out.println(answer);
        answer = answer.replaceAll("^[.]|[.]$", ""); // 4�ܰ� ���ڿ� ���۰� ���� .�� ������ ����
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
