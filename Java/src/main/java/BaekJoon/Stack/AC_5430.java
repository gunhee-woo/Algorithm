package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static Util.Constants.INPUT;

public class AC_5430 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String fun = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrString = br.readLine();
            arrString = arrString.substring(1, arrString.length() - 1);
            String[] arr = arrString.split(",");
            Deque<String> dq = new ArrayDeque<>(Arrays.asList(arr));
            boolean front = true, error = false;
            for(int i = 0; i < fun.length(); i++) {
                char c = fun.charAt(i);
                if(c == 'R') front = !front;
                else if(c == 'D') {
                    if(dq.isEmpty() || dq.element().equals("")) {
                        error = true;
                        break;
                    }
                    if(front) dq.removeFirst();
                    else dq.removeLast();
                }
            }
            if(error) {
                sb.append("error").append("\n");
                continue;
            }
            if(!front) dq.stream().sorted(Collections.reverseOrder());
            sb.append("[");
            while(!dq.isEmpty()) {
                if(dq.size() == 1) sb.append(dq.element()).append("]").append("\n");
                else sb.append(dq.element()).append(",");
                dq.removeFirst();
            }
        }
        System.out.print(sb.toString());
        br.close();
    }
}
