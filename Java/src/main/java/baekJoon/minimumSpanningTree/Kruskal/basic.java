package baekJoon.minimumSpanningTree.Kruskal;

// ũ�罺Į �˰���
// ���� ���� ������� ��� ��带 �����ϱ� ���� ��� => �ּ� ��� ���� Ʈ���� ����� �˰���
// ��� ��带 �ִ��� ���� ������� ���Ḹ ��Ű�� �ǹǷ�
// ���� ������ �������� ���� �� ����� ���� �������� �������� �׷����� ���Խ�Ų��!!
// ũ�罺Į �˰����� �ð����⵵�� �������� �����ϴ� �ð��� �¿�ȴ�.

// ���� e���� �� ���İ� ���� ȿ������ �˰������� �����Ѵٸ� �ð����⵵�� O(elog2e)
// �ݸ鿡 ���� �˰����� �ð����⵵�� O(n^2)
// ���� �׷������� ���� ������ ������ ������ ��� �׷����� ��� ũ�罺Į �˰����� �����ϰ�
// ������ ���� �����ϴ� ���� �׷����� ��� ���� �˰����� �����ϴ�

// 1. ���� ������ �°� �׷����� ���Խ�Ų��
// 2. ���Խ�Ű�� �� ����Ŭ ���̺��� Ȯ���Ѵ�
// 3. ����Ŭ�� �����ϴ� ��� �׷����� ���Խ�Ű�� �ʴ´�
// �ּҽ���Ʈ�������� ����Ŭ�� �߻��ϸ� �ȵ�
// => ����Ŭ �߻����δ� Union-Find �˰����� �����ϸ� ��

import java.util.ArrayList;
import java.util.Collections;

public class basic {
    public static void main(String[] args) {
        int v = 7; // ������ ��
        int e = 11; // ������ ��

        ArrayList<Edge> arr = new ArrayList<>();
        arr.add(new Edge(1,7,12));
        arr.add(new Edge(1,4,28));
        arr.add(new Edge(1,2,67));
        arr.add(new Edge(1,5,17));
        arr.add(new Edge(2,4,24));
        arr.add(new Edge(2,5,62));
        arr.add(new Edge(3,5,20));
        arr.add(new Edge(3,6,37));
        arr.add(new Edge(4,7,13));
        arr.add(new Edge(5,6,45));
        arr.add(new Edge(5,7,73));
        arr.add(new Edge(1,7,12));

        Collections.sort(arr); // ����� �������� �������� ����

        for(int i = 0; i < arr.size(); i++) {
            System.out.println("a : " + arr.get(i).node[0] + ", b : " + arr.get(i).node[1] + ", distance : " + arr.get(i).distance);
        }

        int[] parent = new int[v + 1]; // �θ� ���� ���� �迭
        int sum = 0; // �� �Ҹ� ��� => �ּҽ���Ʈ���� ���
        for(int i = 1; i <= v; i++) { // �θ� ���� �ڱ��ڽ����� �ʱ�ȭ
            parent[i] = i;
        }

        for(int i = 0; i < arr.size(); i++) {
            // ��ü�� �ִ� �� �������� ����Ŭ�� �����ϴ��� Ȯ��
            if(!findParent(parent, arr.get(i).node[0], arr.get(i).node[1])) { // ����Ŭ�� �߻����� �ʴ´ٸ�
                sum += arr.get(i).distance;
                unionParent(parent, arr.get(i).node[0], arr.get(i).node[1]);
            }
        }
        System.out.println(sum);
    }

    private static int getParent(int[] parent, int x) {
        if(parent[x] == x) return x; // �ڱ� �ڽ��� �θ��� ���
        return parent[x] = getParent(parent, parent[x]);
    }

    private static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a < b) parent[b] = a; // �Ϲ������� ���������� �θ� ��带 ��ħ
        else parent[a] = b;
//        if(a != b) parent[b] = a;
    }

    // ���� �θ� ��带 �������� Ȯ�� Find
    private static boolean findParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        return a == b; // true �� ���� �θ� ����
    }


    private static class Edge implements Comparable<Edge> {
        int[] node = new int[2];
        int distance;

        public Edge(int a, int b, int distance) { // �� ������ ������ ����� ����
            this.node[0] = a;
            this.node[1] = b;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance; // ���(�Ÿ�)�� �������� �������� ����
        }
    }
}
