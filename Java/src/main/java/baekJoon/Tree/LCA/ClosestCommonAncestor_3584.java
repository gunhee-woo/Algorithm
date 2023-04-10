package baekJoon.Tree.LCA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

// 최소 공통 조상 (LCA) 알고리즘
// 트리 구조에서 임의의 두 정점이 갖는 가장 깊은 조상(가장 가까운 조상)을 찾는 알고리즘
// 이 문제는 가장 기본적으로 선형 탐색으로 구하는 방법을 사용 => 시간 복잡도 O(depth)
// 두 정점의 부모 노드에 대한 정보와 깊이에 대한 정보를 구함
// 만약 두 정점의 깊이가 다르다면 같도록 맞추고 그 상태에서 최소 공통 조상을 찾음
public class ClosestCommonAncestor_3584 {
    static List<Integer>[] lists;
    static int[] depth, parent;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            lists = new List[N + 1];
            parent = new int[N + 1];
            depth = new int[N + 1];
            for(int i = 1; i <= N; i++) lists[i] = new ArrayList<>();
            int ans1 = 0, ans2 = 0;
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(i == N - 1) {
                    ans1 = a; ans2 = b;
                }
                else {
                    lists[a].add(b);
                    parent[b] = a;
                }
            }
            int root = 0;
            for(int i = 1; i <= N; i++) {
                if(parent[i] == 0) {
                    root = i;
                    break;
                }
            }
            bfs(root);
            System.out.println(lca(ans1, ans2));
        }
    }

    private static int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        while(depth[a] != depth[b]) {
            a = parent[a];
        }
        while(a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    private static void bfs(int root) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0));
        while(!q.isEmpty()) {
            int cur = q.peek().node;
            int cd = q.peek().depth;
            q.poll();
            for(int i = 0; i < lists[cur].size(); i++) {
                int next = lists[cur].get(i);
                int nd = cd + 1;
                depth[next] = nd;
                q.add(new Node(next, nd));
            }
        }
    }

    private static class Node {
        int node; int depth;
        public Node(int node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
