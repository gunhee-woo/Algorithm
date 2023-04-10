package baekJoon.Tree.LCA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class LCA2_11438 {
    static List<Integer>[] lists;
    static int[][] parent;
    static int[] depth;
    static int MAX = 18; // log(2, 100000)
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        lists = new List[N + 1];
        for(int i = 1; i <= N; i++) lists[i] = new ArrayList<>();
        parent = new int[N + 1][MAX];
        depth = new int[N + 1];
        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }
        for(int i = 1; i <= N; i++) {
            Arrays.fill(parent[i], -1);
        }
        Arrays.fill(depth, -1);
        depth[1] = 0;
        dfs(1);
        for(int j = 0; j < MAX - 1; j++) {
            for(int i = 2; i <= N; i++) {
                if(parent[i][j] != -1) {
                    parent[i][j + 1] = parent[parent[i][j]][j];
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
//            System.out.println(lca(a, b));
        }
    }

    private static int lca(int a, int b) {
        if(depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        while(depth[a] != depth[b]) {
            int dist = depth[a] - depth[b];
            for(int i = 0; i < 20; i++) {
                if(dist <= (2 << i)) {
                    a = parent[a][i];
                    break;
                }
            }
        }
        while(a != b) {
            for(int i = MAX - 1; i >= 0; i--) {
                if(parent[a][i] != -1 && parent[a][i] != parent[b][i]) {
                    a = parent[a][i];
                    b = parent[b][i];
                }
            }
            a = parent[a][0];
        }
        return a + 1;
    }

    private static void dfs(int cur) { // parent[i][0] : 2^0 부모, depth 배열 채움
        for(int next : lists[cur]) {
            if(depth[next] == -1) {
                parent[next][0] = cur;
                depth[next] = depth[cur] + 1;
                dfs(next);
            }
        }
    }
}
