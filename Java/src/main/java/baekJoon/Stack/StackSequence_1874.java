package baekJoon.Stack;

import java.io.*;
import java.util.Stack;

import static Util.Constants.INPUT;

// ½Ç¹ö 3
public class StackSequence_1874 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int j = 0;
        for(int i = 1; i <= N; i++) {
            stack.push(i);
            sb.append("+\n");
            while(!stack.empty() && stack.peek() == arr[j]) {
                stack.pop();
                sb.append("-\n");
                j++;
            }
        }
        if(!stack.empty()) System.out.print("NO");
        else System.out.print(sb.toString());
        br.close();
    }
}
