package AlgorithmStudy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 위상정렬
 * 순서가 정해져 있는 작업을 차례로 수행해야 할 때 그 순서를 결정해주기 위해 사용하는 알고리즘
 * 위상정렬은 사이클이 발생하지 않을 경우에만 수행 가능함
 * 위상정렬은 시작점이 존재해야 함 => 사이클 그래프는 시작점을 찾을 수가 없음
 * 위상정렬을 수행하는 알고리즘은 스택 or 큐를 이용하는 방식이 있음
 * 1. 진입차수가 0인 정점을 큐에 삽입
 * 2. 큐에서 원소를 꺼내 연결된 모든 간선을 제거
 * 3. 간선 제거 이후에 진입차수가 0이된 정점을 큐에 삽입
 * 4. 큐가 빌때까지 2~3번 과정 반복
 * 모든 원소를 방문하기 전에 큐가 빈다면 사이클이 존재하는 것
 * 모든 원소를 방문했다면 큐에서 꺼낸 순서가 위상 정렬의 결과
 * https://m.blog.naver.com/ndb796/221236874984
 */
public class TopologySort {
    static int MAX = 10;
    static int n; // 정점 갯수
    static int e; // 간선 갯수
    static int[] inDegree; //
    static List<List<Integer>> arr = new ArrayList<List<Integer>>(); // 인접리스트
    public static void main(String[] args) {
        n = 7;
        e = 9;
        inDegree = new int[n + 1];
        for(int i = 0; i < n + 1; i++) {
            arr.add(new ArrayList<>());
        }
        // 간선 목록 v1 -> v2
        int[] v1 = {1, 1, 2, 4, 3, 3, 5, 2, 5};
        int[] v2 = {2, 3, 5, 6, 4, 7, 6, 4, 4};

        /**
         * 1. v1 -> v2 인접리스트 생성
         * 2. v2 를 가리키는 노드 갯수 indegree 증가
         */

        for(int i = 0; i < e; i++) {
            int c1 = v1[i];
            int c2 = v2[i];
            arr.get(c1).add(c2);
            inDegree[c2]++;
        }

        topologicalSort(inDegree, arr);
    }

    private static void topologicalSort(int[] inDegree, List<List<Integer>> arr) {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        // 큐에 inDegree 가 0 인 노드 담기
        for (int i = 1; i < n + 1; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        /**
         * 1. 큐에서 값을 꺼내며 해당 노드가 가리키는 노드의 indegree 를 1 감소
         * 2. 만약 indegree가 0 이 된다면 큐에 넣기
         * 3. 큐가 빌때까지 반복
         */
        while (!q.isEmpty()) {
            int node = q.poll();
            result.offer(node);

            for (Integer i : arr.get(node)) {
                inDegree[i]--;

                if (inDegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        System.out.println(result);
    }
}
