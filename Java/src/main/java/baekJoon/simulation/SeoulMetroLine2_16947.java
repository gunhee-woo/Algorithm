package baekJoon.simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

// 자기 자신으로 돌아온다면 사이클 => 양방향 그래프일 경우 나갔다가 바로 돌아오는 경우를 예외처리 해야 함
public class SeoulMetroLine2_16947 {
    static int N;
    static List<Integer>[] list;
    static boolean[] check;
    static boolean[] cycle;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new List[3001];
        check = new boolean[N + 1];
        cycle = new boolean[N + 1];
        for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        for(int i = 1; i <= N; i++) {
            Arrays.fill(check, false);
            dfs(i, i, 0);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            Arrays.fill(check, false);
            if(!cycle[i]) sb.append(bfs(new Pair(i, 1))).append(" ");
            else sb.append("0 ");
        }
        System.out.print(sb.toString());
    }

    private static void dfs(int cur, int start, int cnt) {
        if(cur == start && cnt >= 2) {
            cycle[start] = true;
            return;
        }
        check[cur] = true;
        for(int i = 0; i < list[cur].size(); i++) {
            int next = list[cur].get(i);
            if(!check[next]) {
                dfs(next, start, cnt + 1);
            } else {
                if(next == start && cnt >= 2) {
                    dfs(next, start, cnt + 1);
                }
            }
        }
    }

    private static String bfs(Pair node) {
        Queue<Pair> q = new LinkedList<>();
        q.add(node);
        int answer = 0;
        boolean isFind = false;
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            for(int i = 0; i < list[cur.node].size(); i++) {
                int next = list[cur.node].get(i);
                if(!check[next]) {
                    check[next] = true;
                    if(cycle[next]) {
                        isFind = true;
                        answer = cur.cnt;
                        break;
                    } else {
                        q.add(new Pair(next, cur.cnt + 1));
                    }
                }
            }
            if(isFind) break;
        }
        return String.valueOf(answer);
    }

    private static class Pair {
        int node; int cnt;
        Pair(int node, int cnt) {
            this.node = node;
            this.cnt = cnt;
        }
    }
}
