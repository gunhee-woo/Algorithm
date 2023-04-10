package baekJoon.minimumSpanningTree.Kruskal;

// 크루스칼 알고리즘
// 가장 적은 비용으로 모든 노드를 연결하기 위해 사용 => 최소 비용 신장 트리를 만드는 알고리즘
// 모든 노드를 최대한 적은 비용으로 연결만 시키면 되므로
// 간선 정보를 오름차순 정렬 후 비용이 적은 간선부터 차근차근 그래프에 포함시킨다!!
// 크루스칼 알고리즘의 시간복잡도는 간선들을 정렬하는 시간에 좌우된다.

// 간선 e개를 퀵 정렬과 같은 효율적인 알고리즘으로 정렬한다면 시간복잡도는 O(elog2e)
// 반면에 프림 알고리즘의 시간복잡도는 O(n^2)
// 따라서 그래프내에 적은 숫자의 간선을 가지는 희소 그래프의 경우 크루스칼 알고리즘이 적합하고
// 간선이 많이 존재하는 밀집 그래프의 경우 프림 알고리즘이 적합하다

// 1. 정렬 순서에 맞게 그래프에 포함시킨다
// 2. 포함시키기 전 사이클 테이블을 확인한다
// 3. 사이클을 포함하는 경우 그래프에 포함시키지 않는다
// 최소신장트리에서는 사이클이 발생하면 안됨
// => 사이클 발생여부는 Union-Find 알고리즘을 적용하면 됨

import java.util.ArrayList;
import java.util.Collections;

public class basic {
    public static void main(String[] args) {
        int v = 7; // 정점의 수
        int e = 11; // 간선의 수

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

        Collections.sort(arr); // 비용을 기준으로 오름차순 정렬

        for(int i = 0; i < arr.size(); i++) {
            System.out.println("a : " + arr.get(i).node[0] + ", b : " + arr.get(i).node[1] + ", distance : " + arr.get(i).distance);
        }

        int[] parent = new int[v + 1]; // 부모 정점 저장 배열
        int sum = 0; // 총 소모 비용 => 최소신장트리의 결과
        for(int i = 1; i <= v; i++) { // 부모 정점 자기자신으로 초기화
            parent[i] = i;
        }

        for(int i = 0; i < arr.size(); i++) {
            // 객체에 있는 두 정점에서 사이클이 존재하는지 확인
            if(!findParent(parent, arr.get(i).node[0], arr.get(i).node[1])) { // 사이클이 발생하지 않는다면
                sum += arr.get(i).distance;
                unionParent(parent, arr.get(i).node[0], arr.get(i).node[1]);
            }
        }
        System.out.println(sum);
    }

    private static int getParent(int[] parent, int x) {
        if(parent[x] == x) return x; // 자기 자신이 부모인 경우
        return parent[x] = getParent(parent, parent[x]);
    }

    private static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a < b) parent[b] = a; // 일반적으로 작은값으로 부모 노드를 합침
        else parent[a] = b;
//        if(a != b) parent[b] = a;
    }

    // 같은 부모 노드를 가지는지 확인 Find
    private static boolean findParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        return a == b; // true 면 같은 부모를 가짐
    }


    private static class Edge implements Comparable<Edge> {
        int[] node = new int[2];
        int distance;

        public Edge(int a, int b, int distance) { // 두 정점과 간선의 비용을 저장
            this.node[0] = a;
            this.node[1] = b;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance; // 비용(거리)를 기준으로 오름차순 정렬
        }
    }
}
