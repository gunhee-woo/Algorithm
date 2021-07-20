package BaekJoon.MinimumSpanningTree.UnionFind_disjoint_set;

// Union-Find (Disjoint-Set) �˰��� == ������ ã�� (���μ� ����) �˰���
// �������� ��尡 �����Ҷ� �� ���� ��带 �����ؼ� ���� �� ��尡 ���� ���� �׷����� ���ϴ��� �Ǻ��ϴ� �˰���
// ���� �ٸ� �� ���� ��尡 ����Ǿ��� �� �̷��� ���Ἲ�� ���α׷������� ǥ���ϴ� ��
// ���� ��带 �����Ͽ� �θ� ��ĥ���� �Ϲ������� �� ���� ������ ��ħ => 1�� 2�� ����Ǿ����� 2�� �θ�� 1�̵� => Union
// �ٽ� ��� 2�� 3�� ����Ǿ����� 1�� 3�� ����Ǿ����ĸ� �ľ��ϴ� ������� ��͸� ���
// �׷��� ��������� ��� 1,2,3�� �θ� ���� 1�� �Ǹ� �� ������ ��� ���� �׷����� ���Ѵٰ� �� �� ����
// Find �˰����� �� ���� ����� �θ� Ȯ���Ͽ� ���� ���� ���տ� ���ϰ� �ִ����� Ȯ��

public class basic {
    public static void main(String[] args) {
        int[] parent = new int[11];
        for(int i = 1; i <= 10; i++) { // �� ������ �θ� ��� �ڱ� �ڽ����� �ʱ�ȭ
            parent[i] = i;
        }
        unionParent(parent, 1, 2);
        unionParent(parent, 2, 3);
        unionParent(parent, 3, 4);
        unionParent(parent, 5, 6);
        unionParent(parent, 6, 7);
        unionParent(parent, 7, 8);
        System.out.println("��� 1�� 5�� ����Ǿ� �ֳ�? " + (findParent(parent, 1, 5) ? "Yes" : "No"));
        unionParent(parent, 1, 5);
        System.out.println("��� 1�� 6�� ����Ǿ� �ֳ�? " + (findParent(parent, 1, 8) ? "Yes" : "No"));
    }

    private static int getParent(int[] parent, int x) {
        if(parent[x] == x) return x; // �ڱ� �ڽ��� �θ��� ���
        return parent[x] = getParent(parent, parent[x]);
    }

    // �� �θ� ��带 ��ģ�� Union
    private static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a < b) parent[b] = a; // ���������� �θ� ��带 ��ħ
        else parent[a] = b;
    }

    // ���� �θ� ��带 �������� Ȯ�� Find
    private static boolean findParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        return a == b; // true �� ���� �θ� ����
    }
}
