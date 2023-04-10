package baekJoon.Stack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

// ��� 5

// ������ ����ִ� ��� ���� ž�� ���ʿ��� ž�� �������� ���� => ���� ��ġ ž�� ���ÿ� �ְ� 0�� �������Ʈ�� ����
// ������ ������� ���� ��� ���� ž���� ū ž�� ���� ������ Ž�� ���� ž�� ���ÿ��� pop�� ����
// ū ž�� ������ �Ǹ� ū ž�� �ε����� �������Ʈ�� �����ϰ� ���� ž�� ���ÿ� �־���
// ���� ž�� ���ÿ� �ִ� ������ ������ �����ʿ��� ���� ž���� ��ȣ�� ���� �� �ֱ� ����

public class Top_2493 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>(); // �� ž �ε��� ���� �뵵
        int[] ints = new int[N + 1]; // ž ���� ����
        for(int i = 1; i <= N; i++) {
            int r = Integer.parseInt(st.nextToken());
            map.put(r, i); // �� ž�� ���� �ε��� ���� <����, �ε���>
            ints[i] = r;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(ints[1]);
        sb.append(0 + " "); // �ʱⰪ ���ÿ� ����
        for(int i = 2; i <= N; i++) {
            while(!stack.empty() && stack.peek() < ints[i]) { // ������ ������� ���� ��� Ž��
                stack.pop();
                if(stack.empty()) { // �ʱ⿡ �ٷ� �� ū ž�� �����ʿ��� �� ���
                   break;
                } else {
                    if(stack.peek() > ints[i]) {
                        break;
                    }
                }
            }
            if(stack.empty()) { // ������ ����ִ� ���
                sb.append(0 + " ");
                stack.push(ints[i]);
            } else { // ������ ������� ���� ��� ���� ž ���ÿ� ����
                sb.append(map.get(stack.peek())).append(" ");
                stack.push(ints[i]);
            }

        }
        System.out.print(sb.toString());
        br.close();
    }
}
