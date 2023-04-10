package baekJoon.dataStructure;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

import static Util.Constants.INPUT;

/**
 * ArrayList�� ��� ������ �߰� ���� �� �ӽù迭�� �̿��Ͽ� �����ϴ� �۾��� ������
 * ��, �о�� ������ ������ �����ϱ� ������ ���ɿ� ������ ���� �� ����
 * ������ �� �����Ϳ� ���� �ε����� ������ �־� �˻��� �ſ� ����
 *
 * �ݸ� LinkedList�� ���� �ڷ��� ��ġ������ ������ �������� �ε����� ������ ���� ����
 * �������� �߰� ������ ��ġ������ �������� �����ϱ� ���� ���� ������ �߰� ������ ������
 * ������ ������ �˻� �� ó�� �ڷ���� ���������� �����ϱ� ������ ���ɿ� ������ ����
 * http://seeit.kr/36
 */

// �� ���������� ������ �߰� ���� ���길 �����ϱ� ������ LinkedList ����� ������
public class rotateQueue_1021 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");
        final int N = Integer.parseInt(line1[0]);
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= N; i++) list.add(i);
        int result = 0;
        for (String s : line2) {
            int k = Integer.parseInt(s);
            while (true) {
                int pos = list.indexOf(k);
                int left = pos; // head ���� �Ÿ��� ���� ����� �ε����� ����
                int right = list.size() - pos - 1; // tail ���� �Ÿ�
                if (left == 0) {
                    list.remove(pos);
                    break;
                }
                if (left <= right) { // �������� Ž��
                    list.addLast(list.removeFirst());
                    ++result;
                } else { // ���������� Ž��
                    list.addFirst(list.removeLast());
                    ++result;
                }
            }
        }
        System.out.println(result);
        br.close();
    }
}
