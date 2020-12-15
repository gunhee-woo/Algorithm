package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// °ñµå 5
public class Top_2493 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.parseInt(st.nextToken()));
        sb.append(0 + " ");
        for(int i = 2; i <= N; i++) {
            while(!stack.empty()) {
                if(stack.peek() < Integer.parseInt(st.nextToken())) {

                } else {

                }
            }
        }

        br.close();
    }
}
