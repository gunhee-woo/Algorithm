package baekJoon.minimumSpanningTree.Kruskal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// 크루스칼 알고리즘 응용 문제
// 1. 두 개의 마을로 분리해야 함
// 2. 각 마을에는 집이 하나 이상 존재해야 함
// 3. 분리된 마을 안에서도 두 집 사이의 경로가 항상 존재하게 하면서 길을 더 없앨 수 있다
// 4. 위의 조건을 만족하도록 길을 모두 없애고 나머지 길의 유지비의 합을 최소로 하고 싶다
// => 최소 스패닝 트리를 두개 만드는데 최소비용으로 만들어야 함
// => 이말은 즉, 최대 가중치로 연결된 집을 하나 분리하면 된다
// => 따라서 최소 스패닝 트리를 만들며 마지막으로 연결되는 길을 없애면 된다
// => 이미 가중치로 오름차순 정렬되어 있으므로 가능함
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
