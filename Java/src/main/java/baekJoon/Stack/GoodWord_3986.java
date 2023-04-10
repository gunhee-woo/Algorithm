package baekJoon.Stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class GoodWord_3986 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int n = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < str.length(); j++) {
                if(stack.empty()) stack.push(str.charAt(j));
                else {
                    if(stack.peek().equals(str.charAt(j))) {
                        stack.pop();
                    } else {
                        stack.push(str.charAt(j));
                    }
                }
            }
            if(stack.empty()) count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
