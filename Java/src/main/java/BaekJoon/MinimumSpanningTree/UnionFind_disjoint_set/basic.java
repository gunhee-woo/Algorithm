package BaekJoon.MinimumSpanningTree.UnionFind_disjoint_set;

// Union-Find (Disjoint-Set) 알고리즘 == 합집합 찾기 (서로소 집합) 알고리즘
// 여러개의 노드가 존재할때 두 개의 노드를 선택해서 현재 이 노드가 서로 같은 그래프에 속하는지 판별하는 알고리즘
// 서로 다른 두 개의 노드가 연결되었을 때 이러한 연결성을 프로그래밍으로 표현하는 것
// 노드와 노드를 연결하여 부모를 합칠때는 일반적으로 더 작은 값으로 합침 => 1과 2가 연결되었을때 2의 부모는 1이됨 => Union
// 다시 노드 2와 3이 연결되었을때 1과 3이 연결되었느냐를 파악하는 방법으로 재귀를 사용
// 그렇게 결과적으로 노드 1,2,3의 부모 노드는 1이 되며 이 노드들은 모두 같은 그래프에 속한다고 할 수 있음
// Find 알고리즘은 두 개의 노드의 부모를 확인하여 현재 같은 집합에 속하고 있는지를 확인

public class basic {
    public static void main(String[] args) {
        int[] parent = new int[11];
        for(int i = 1; i <= 10; i++) { // 각 노드들의 부모 노드 자기 자신으로 초기화
            parent[i] = i;
        }
        unionParent(parent, 1, 2);
        unionParent(parent, 2, 3);
        unionParent(parent, 3, 4);
        unionParent(parent, 5, 6);
        unionParent(parent, 6, 7);
        unionParent(parent, 7, 8);
        System.out.println("노드 1과 5는 연결되어 있나? " + (findParent(parent, 1, 5) ? "Yes" : "No"));
        unionParent(parent, 1, 5);
        System.out.println("노드 1과 6는 연결되어 있나? " + (findParent(parent, 1, 8) ? "Yes" : "No"));
    }

    private static int getParent(int[] parent, int x) {
        if(parent[x] == x) return x; // 자기 자신이 부모인 경우
        return parent[x] = getParent(parent, parent[x]);
    }

    // 각 부모 노드를 합친다 Union
    private static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a < b) parent[b] = a; // 작은값으로 부모 노드를 합침
        else parent[a] = b;
    }

    // 같은 부모 노드를 가지는지 확인 Find
    private static boolean findParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        return a == b; // true 면 같은 부모를 가짐
    }
}
