package BaekJoon.Stack; // 제출하기 전 지울 것!!

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack_10828 { // 제출하기 전 Main으로 클래스 명 변경할 것
    // 제출하기 전 주석처리
    static final String INPUT = "c:/Users/Gun/Algorithm/Algorithm/Java/src/main/java/text.txt";
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(INPUT)); // 제출하기 전 주석처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        final int n = Integer.parseInt(br.readLine()); // 여기까지가 기본 입력값

        Stack<String> stk = new Stack<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.toLowerCase().equals("push")) { // 웬만한 경우 toLowerCase, toUpperCase를 사용하여 비교할 것
                stk.push(st.nextToken());
            } else if(order.toLowerCase().equals("top")) {
                if(stk.empty()) sb.append("-1\n");
                else sb.append(stk.peek()).append("\n");
            } else if(order.toLowerCase().equals("size")) {
                sb.append(String.valueOf(stk.size())).append("\n");
            } else if(order.toLowerCase().equals("empty")) {
                if(stk.empty()) sb.append("1\n");
                else sb.append("0\n");
            } else if(order.toLowerCase().equals("pop")) {
                if(stk.empty()) sb.append("-1\n");
                else sb.append(stk.pop()).append("\n");
            }
        }
        bw.write(sb.toString().trim()); // trim 을 사용하여 마지막 빈 줄을 없애줌
        bw.flush();
        bw.close();
        br.close(); // !!!!! 중요 버퍼리더, 라이터 close 함수로 마지막에 꼭 닫아줄 것 !!!!!
    }
}
