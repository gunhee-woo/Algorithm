package baekJoon.Stack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

import static Util.Constants.INPUT;

/**
 * *************************************************************************************
 * ù ��° �ٿ� ������ ���� N�� �Էµȴ�.(1 �� N �� 80,000)
 * �� ��° �� ���� N+1��° �ٱ��� �� ������ ���̰� hi �Էµȴ�. (1 �� hi �� 1,000,000,000)
 * => ������ ���� �� ����� int �ڷ������� ���� ��� �ʰ��� �Ͼ�� ��
 * ����, �ڷ����� long ���� �ٲپ� �ذ��ؾ� ��
 */

// ���ÿ� ����� ���� ������ ������ ������ �� �ִ� �������� �ǹ��ϸ� ������ ������� ������ ���� �ǹ���
// ���� �������� �������� ������ �۴ٸ� ���� �������� ������ ������ �� �� �ִٴ� ���̹Ƿ� ī��Ʈ�� ��
// ���� ���� ���� ���� ���� ������ ������ ���� ���� ������ ����� ������� ����

// ��� 5
public class DecoratingARoofGarden_6198 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long result = 0;
        stack.push(Integer.parseInt(br.readLine()));
        for(int i = 1; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            while(!stack.empty() && stack.peek() <= value) {
                stack.pop();
            }
            result += stack.size();
            stack.push(value);
        }
        System.out.println(result);
        br.close();
    }
}
