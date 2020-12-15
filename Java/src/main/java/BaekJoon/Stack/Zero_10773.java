package BaekJoon.Stack;

import java.io.*;
import java.util.*;

import static Util.Constants.INPUT;

// ½Ç¹ö 4
public class Zero_10773 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int n = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        int result = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(Integer.parseInt(str) != 0) {
               stack.push(str);
            } else {
                stack.pop();
            }
        }
        while(!stack.empty()) {
            result += Integer.parseInt(stack.peek());
            stack.pop();
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
