package baekJoon.shortestPath.BellManFord;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// 벨만포드 알고리즘
// 다익스트라 알고리즘과 같이 특정한 시작점에서 다른 모든 정점으로의 최단경로를 구하는 알고리즘
// 차이점은 간선의 Cost가 음수일 때도 사용할 수 있다는 것!! ex) 타임머신을 타고 과거를 역행하는 것과 같은 예
// 최단경로를 구하기 위해 이중 for문을 사용하여 모든 경우를 탐색
// 가능한 최단 경로의 간선 개수는 많아봐야 V - 1개
// 따라서 루프를 V - 1번 돌리며 k번째 루프에서 시작점으로부터 각 정점으로 k개의 간선을 거쳐서 도달할 수 있는 최단경로를 갱신해준다
// 만약 그래프에 음의 싸이클이 존재한다면 그 이후에 루프를 돌 경우 최단거리가 갱신되는 일이 발생함
// 따라서 음의 싸이클의 존재 여부를 판단하기 위해 맨 마지막에 확인차 루프를 한 번 더 돌려 최단거리가 갱신되는지 확인
// 만약 갱신이 된다면 음의 싸이클이 존재한다는 것

// V - 1번 인접한 모든 간선들을 검사하는 과정을 거치므로 시간복잡도는 O(VE)
// 그래프의 간선이 많으면 보통 정점의 개수가 제곱 개 정도 존재하므로
// 벨만포드 알고리즘의 WorstCase 시간복잡도는 E = V^2 => O(V^3)
// 따라서 다익스트라 알고리즘(O(ElogE))에 비해 시간복잡도가 크지만 음수 간선이 존재할 때 사용할 수 있다는 점과
// 음수 사이클 존재 여부를 판별할 수 있다는점에서 유용하다

public class timeMachine_11657 {
    static long INF = Long.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Node>[] lists = new List[501];
        long [] d = new long[N + 1];
        Arrays.fill(d, INF);
        for(int i = 1; i <= N; i++) lists[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lists[a].add(new Node(b, c));
        }
        d[1] = 0;
        boolean minusCycle = false; // 음의 싸이클이 존재하는지 판단하기 위한 Flag
        // 경로의 길이는 N - 1이고 N이 된다면 음수 싸이클이 생김
        for(int i = 1; i <= N; i++) {
//        for(int i = 1; i <= N - 1; i++) { // 정점 N - 1 만큼 루프를 돌려 최단거리 갱신
            for(int j = 1; j <= N; j++) {
                for(Node node : lists[j]) {
                    int next = node.end;
                    int nextTime = node.time;
                    // 방문되지 않은 지점은 스킵
                    if(d[j] != INF && d[next] > d[j] + nextTime) {
                        d[next] = d[j] + nextTime;
                        if(i == N) minusCycle = true; // 마지막 N번째 루프에서 최단거리가 갱신이됨 => 음수 싸이클이 존재한다
                    }
                }
            }
        }
        if(minusCycle) System.out.print(-1);
        else {
            for(int i = 1; i <= N; i++) {
                if(d[i] != INF) System.out.println(d[i]);
                else System.out.println(-1);
            }
        }
    }

    public static class Node {
        int end;
        int time;
        public Node(int end, int time) {
            this.end = end;
            this.time = time;
        }
    }
}
