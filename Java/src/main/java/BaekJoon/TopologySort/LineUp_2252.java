package BaekJoon.TopologySort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

public class LineUp_2252 {
    static int N, M;
    static int MAX = 32001;
    static List<Integer>[] list; // 인접행렬
    static List<Integer> result; // 위상정렬의 결과를 담는 곳
    static int[] inDeg; // 각 정점에게 들어오는 간선의 수를 담은 배열
    static Queue<Integer> q;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new List[MAX];
        result = new ArrayList<>();
        inDeg = new int[N + 1];
        q = new LinkedList<>();
        for(int i = 0; i <= N; i++) { // 인접행렬 초기화
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            inDeg[b]++; // 정점에 들어오는 간선의 갯수를 셈
        }
        for(int i = 1; i <= N; i++) {
            if(inDeg[i] == 0) q.add(i); // 정점으로 들어오는 간선의 갯수가 0인 정점을 큐에 담음
        }
        while(!q.isEmpty()) { // 큐에서 나오는 정점은 이미 정점들의 앞에 위치했으므로 신경쓰지 않아도 됨 == 현재 정점에서 더 이상 다른 정점으로 나가는 간선이 없음
            int cur = q.poll();
            result.add(cur);
            for(int i = 0; i < list[cur].size(); i++) {
                int next = list[cur].get(i);
                inDeg[next]--;
                if(inDeg[next] == 0) q.add(next);
            }
        }
//        if(result.size() != N) { // 위상정렬의 결과의 크기와 정점의 갯수가 다르다면 사이클이 존재하는 것
//            System.out.print("Cycle Exists");
//        }
        for(int r : result) System.out.print(r + " ");
    }
}
