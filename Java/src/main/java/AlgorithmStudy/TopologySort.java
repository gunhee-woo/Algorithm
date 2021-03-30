package AlgorithmStudy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ��������
 * ������ ������ �ִ� �۾��� ���ʷ� �����ؾ� �� �� �� ������ �������ֱ� ���� ����ϴ� �˰���
 * ���������� ����Ŭ�� �߻����� ���� ��쿡�� ���� ������
 * ���������� �������� �����ؾ� �� => ����Ŭ �׷����� �������� ã�� ���� ����
 * ���������� �����ϴ� �˰����� ���� or ť�� �̿��ϴ� ����� ����
 * 1. ���������� 0�� ������ ť�� ����
 * 2. ť���� ���Ҹ� ���� ����� ��� ������ ����
 * 3. ���� ���� ���Ŀ� ���������� 0�̵� ������ ť�� ����
 * 4. ť�� �������� 2~3�� ���� �ݺ�
 * ��� ���Ҹ� �湮�ϱ� ���� ť�� ��ٸ� ����Ŭ�� �����ϴ� ��
 * ��� ���Ҹ� �湮�ߴٸ� ť���� ���� ������ ���� ������ ���
 * https://m.blog.naver.com/ndb796/221236874984
 */
public class TopologySort {
    static int MAX = 10;
    static int n; // ���� ����
    static int e; // ���� ����
    static int[] inDegree; //
    static List<List<Integer>> arr = new ArrayList<List<Integer>>(); // ��������Ʈ
    public static void main(String[] args) {
        n = 7;
        e = 9;
        inDegree = new int[n + 1];
        for(int i = 0; i < n + 1; i++) {
            arr.add(new ArrayList<>());
        }
        // ���� ��� v1 -> v2
        int[] v1 = {1, 1, 2, 4, 3, 3, 5, 2, 5};
        int[] v2 = {2, 3, 5, 6, 4, 7, 6, 4, 4};

        /**
         * 1. v1 -> v2 ��������Ʈ ����
         * 2. v2 �� ����Ű�� ��� ���� indegree ����
         */

        for(int i = 0; i < e; i++) {
            int c1 = v1[i];
            int c2 = v2[i];
            arr.get(c1).add(c2);
            inDegree[c2]++;
        }

        topologicalSort(inDegree, arr);
    }

    private static void topologicalSort(int[] inDegree, List<List<Integer>> arr) {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        // ť�� inDegree �� 0 �� ��� ���
        for (int i = 1; i < n + 1; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        /**
         * 1. ť���� ���� ������ �ش� ��尡 ����Ű�� ����� indegree �� 1 ����
         * 2. ���� indegree�� 0 �� �ȴٸ� ť�� �ֱ�
         * 3. ť�� �������� �ݺ�
         */
        while (!q.isEmpty()) {
            int node = q.poll();
            result.offer(node);

            for (Integer i : arr.get(node)) {
                inDegree[i]--;

                if (inDegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        System.out.println(result);
    }
}
