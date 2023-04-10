package baekJoon.Tree.LCA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

public class LCA_11437 {
    static List<Integer>[] lists;
    static int[] parent, depth;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        lists = new List[N + 1];
        for(int i = 1; i <= N; i++) lists[i] = new ArrayList<>();
        parent = new int[N + 1];
        depth = new int[N + 1];
        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }
//        dfs(1, 0);
        bfs();
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(lca(a, b));
        }
    }

    private static int lca(int a, int b) {
        if(depth[a] < depth[b]) {
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

    private static void dfs(int node, int pNode) {
        parent[node] = pNode;
        depth[node] = depth[pNode] + 1;
        for(int i = 0; i < lists[node].size(); i++) {
            int child = lists[node].get(i);
            if(child == pNode) continue;
            dfs(child, node);
        }
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));
        while(!q.isEmpty()) {
            int cur = q.peek().node;
            int cd = q.peek().depth;
            q.poll();
            for(int i = 0; i < lists[cur].size(); i++) {
                int child = lists[cur].get(i);
                int nd = cd + 1;
                if(cur == child || child == 1) continue;
                if(parent[child] == 0) {
                    depth[child] = nd;
                    parent[child] = cur;
                    q.add(new Node(child, nd));
                }
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
