package baekJoon.Stack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

import static Util.Constants.INPUT;

public class balancedWorld_4949 {
    public static void main(String[] args) throws  Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            Stack<Character> st = new Stack<>();
            boolean check = false;
            String line = br.readLine();
            if(line.charAt(0) == '.') break;
            for(int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if(c == '.') break;
                if(c == '(' || c == '[') st.push(c);
                else if(c == ')') {
                    if(st.empty() || st.peek() != '(') {
                        check = true;
                        break;
                    }
                    else {
                        st.pop();
                    }
                } else if(c == ']') {
                    if(st.empty() || st.peek() != '[') {
                        check = true;
                        break;
                    } else {
                        st.pop();
                    }
                }
            }
            if(check || !st.empty()) System.out.println("no");
            else System.out.println("yes");
        }
        br.close();
    }
}
