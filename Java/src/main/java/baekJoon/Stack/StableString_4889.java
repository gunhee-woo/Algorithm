package baekJoon.Stack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

import static Util.Constants.INPUT;

public class StableString_4889 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 1;
        while(true) {
            String str = br.readLine();
            if(str.contains("-")) return;
            int oc = 0, count = 0;
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '}') {
                    if(stack.empty()) {
                        stack.push('{');
                        oc++;
                        count++;
                        continue;
                    }
                    stack.pop();
                } else if(str.charAt(j) == '{') {
                    oc++;
                    if(oc > str.length() / 2) { // ���� ��ȣ�� ������ �ʰ��Ǿ��� ��
                        oc--;
                        stack.pop();
                        count++;
                        continue;
                    }
                    stack.push('{');
                }
            }
            System.out.println(i++ + ". " + count);
        }
    }
}
