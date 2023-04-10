package baekJoon.minimumSpanningTree.Kruskal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// ũ�罺Į �˰��� ���� ����
// 1. �� ���� ������ �и��ؾ� ��
// 2. �� �������� ���� �ϳ� �̻� �����ؾ� ��
// 3. �и��� ���� �ȿ����� �� �� ������ ��ΰ� �׻� �����ϰ� �ϸ鼭 ���� �� ���� �� �ִ�
// 4. ���� ������ �����ϵ��� ���� ��� ���ְ� ������ ���� �������� ���� �ּҷ� �ϰ� �ʹ�
// => �ּ� ���д� Ʈ���� �ΰ� ����µ� �ּҺ������ ������ ��
// => �̸��� ��, �ִ� ����ġ�� ����� ���� �ϳ� �и��ϸ� �ȴ�
// => ���� �ּ� ���д� Ʈ���� ����� ���������� ����Ǵ� ���� ���ָ� �ȴ�
// => �̹� ����ġ�� �������� ���ĵǾ� �����Ƿ� ������
public class CityDivisionPlan_1647 {
    static int[] parent;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Edge> list = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Edge(a, b, c));
        }
        Collections.sort(list);

        parent = new int[N + 1];
        for(int i = 1; i <= N; i++) parent[i] = i;
        List<Integer> sum = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            int a = list.get(i).node[0];
            int b = list.get(i).node[1];
            if(!findParent(a, b)) {
                sum.add(list.get(i).distance);
                unionParent(a, b);
            }
        }
        int answer = 0;
        for(int i = 0; i < sum.size() - 1; i++) answer += sum.get(i);
        System.out.print(answer);
    }

    private static int getParent(int x) {
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent[x]);
    }

    private static void unionParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if(a != b) parent[b] = a;
    }

    private static boolean findParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        return a == b;
    }

    private static class Edge implements Comparable<Edge> {
        int[] node = new int[2];
        int distance;

        public Edge(int a, int b, int c) {
            this.node[0] = a;
            this.node[1] = b;
            this.distance = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }
}
