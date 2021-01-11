package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

import static Util.Constants.INPUT;

public class ValueOfParentheses_2504 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String str = br.readLine();
        Stack<Character> characterStack = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();
        int result = 1, sum = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(') {
                characterStack.push(c);
                integerStack.push(2);
            } else if(c == '[') {
                characterStack.push(c);
                integerStack.push(3);
            } else if(c == ')') {
                if(characterStack.empty() || str.charAt(i - 1) == '[') {
                    System.out.println(0);
                    return;
                }
                characterStack.pop();
                if(characterStack.empty()) {

                    sum = 0;
                } else {

                    sum += integerStack.pop();
                }
            } else if(c == ']') {
                if(characterStack.empty() || str.charAt(i - 1) == '(') {
                    System.out.println(0);
                    return;
                }
                characterStack.pop();
            }

        }

        br.close();
    }
}
