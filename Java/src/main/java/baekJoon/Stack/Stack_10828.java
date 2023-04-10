package baekJoon.Stack; // �����ϱ� �� ���� ��!!

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// �ǹ� 4
public class Stack_10828 { // �����ϱ� �� Main���� Ŭ���� �� ������ ��
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(INPUT)); // �����ϱ� �� �ּ�ó��
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        final int n = Integer.parseInt(br.readLine()); // ��������� �⺻ �Է°�

        Stack<String> stk = new Stack<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.toLowerCase().equals("push")) { // ������ ��� toLowerCase, toUpperCase�� ����Ͽ� ���� ��
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
        bw.write(sb.toString().trim()); // trim �� ����Ͽ� ������ �� ���� ������
        bw.flush();
        bw.close();
        br.close(); // !!!!! �߿� ���۸���, ������ close �Լ��� �������� �� �ݾ��� �� !!!!!
    }
}
