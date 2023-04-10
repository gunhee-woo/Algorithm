package baekJoon.topologySort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// 위상정렬  + 우선순위 큐
// 1. N개의 문제는 모두 풀어야 한다.
// 2. 먼저 푸는 것이 좋은 문제가 있는 문제는, 먼저 푸는 것이 좋은 문제를 반드시 먼저 풀어야 한다.
// => 위상정렬
// 3 .가능하면 쉬운 문제부터 풀어야 한다.(오름차순) => 우선순위 큐를 사용하여 자동으로 정렬
public class Workbook_1766 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] list = new List[N + 1];
        for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        int[] inDeg = new int[N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            inDeg[b]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= N; i++) {
            if(inDeg[i] == 0) pq.add(i);
        }
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            result.add(cur);
            for(int i = 0; i < list[cur].size(); i++) {
                int next =  list[cur].get(i);
                inDeg[next]--;
                if(inDeg[next] == 0) pq.add(next);
            }
        }
//        if(result.size() != N) System.out.print("사이클이 존재");
        for(int i : result) System.out.print(i + " ");
    }
}
