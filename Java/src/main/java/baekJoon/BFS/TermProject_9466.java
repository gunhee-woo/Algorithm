package baekJoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static Util.Constants.INPUT;

// ����Ŭ�� ������ �� ������ ã�� ����

// 1. ������ �л��� �湮�ߴ����� ���� ���� check
// 2. �湮�� ������ �� ��°�� �湮�ߴ��� cnt
// 3. �湮�� �� ���� ù ������ ������ �л��� �������� => ������, Cycle Ȯ���� ����
// -> �湮�� ��ȣ�� ������ �湮�� �л�����, ���� ����Ŭ�� �ش��ϴ��� Ȯ��
// 3�� ������ �����Ѵٸ� ���� �湮�������� Ƚ��(cnt)���� ������ �湮�������� ���� ���־� ����Ŭ ��� ������ ����

public class TermProject_9466 {
    static int MAX = 100001;
    static String[] student;
    static boolean[] check;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            student = br.readLine().split(" ");
            Arrays.fill(check, false);
            Queue<Integer> q = new LinkedList<>();
        }
    }
}
