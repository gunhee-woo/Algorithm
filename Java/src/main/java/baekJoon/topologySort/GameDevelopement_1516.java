package baekJoon.topologySort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

// 위상정렬  +  DP
public class GameDevelopement_1516 {
    static int MAX = 501;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] list = new List[MAX];
        int[] inDeg = new int[N + 1];
        int[] time = new int[N + 1];
        for(int i = 1; i < MAX; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while(true) {
                int a = Integer.parseInt(st.nextToken());
                if(a == -1) break;
                list[a].add(i);
                inDeg[i]++;
            }
        }
        int[] d = new int[N + 1];
        Arrays.fill(d, 0);
        Queue<Integer> q = new LinkedList<>();
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
                if(inDeg[next] == 0) q.add(next);
            }
        }
        for(int i = 1; i <= N; i++) {
            System.out.println(d[i]);
        }
    }
}
