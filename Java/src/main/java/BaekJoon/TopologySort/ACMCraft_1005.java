package BaekJoon.TopologySort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

// 위상정렬 + DP
public class ACMCraft_1005 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] time = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }
            List<Integer>[] list = new List[1001];
            int[] inDeg = new int[N + 1];
            for(int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                inDeg[b]++;
            }
            Queue<Integer> q = new LinkedList<>();
            int[] d = new int[N + 1];
            Arrays.fill(d, 0);
            for(int i = 1; i <= N; i++) {
                if(inDeg[i] == 0) {
                    q.add(i);
                    d[i] = time[i];
                }
            }
            while(!q.isEmpty()) {
                int cur = q.poll();
                for(int i = 0; i < list[cur].size(); i++) {
                    int next = list[cur].get(i);
                    inDeg[next]--;
                    d[next] = Math.max(d[next], d[cur] + time[next]);
                    if(inDeg[next] == 0) {
                        q.add(next);
                    }
                }
            }
            int w = Integer.parseInt(br.readLine());
            System.out.println(d[w]);
        }
    }
}
