package BaekJoon.MinimumSpanningTree.Prim;

// 프림 알고리즘
// 방향성이 없는 그래프(양방향 그래프)가 주어질 때 최소 스패닝 트리를 찾는 알고리즘
// 1. 임의의 정점을 선택하여 T라는 그래프(최소신장트리)에 포함시킨다
// 2. T에 있는 노드와 T에 없는 노드 사이의 간선 중 가중치가 최소인 간선을 찾는다
// 3. 찾은 간선이 연결하는 두 노드 중, T에 없는 노드를 T에 포함시킨다
// 4. 모든 노드가 T에 포함될 때까지 1,2를 반복한다

// 프림 알고리즘은 두 가지 방법이 존재
// 1. 배열을 사용하여 T와 각 노드를 연결하는 최소 간선 가중치를 찾는 방법 시간복잡도는 O(V^2)
// 2. 최소 힙(우선순위 큐)를 사용하여 최소의 간선 가중치를 찾는 방법 시간복잡도는 O(ElogE) == O(ElogV)
// V는 정점의 개수 E는 간선의 개수

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class basic {
    static int N = 7;
    static int INF = Integer.MAX_VALUE;
    static List<Node>[] list;
    static List<Integer> prim1NodeList, prim2NodeList;
    public static void main(String[] args) throws Exception {
        N = 6;
        prim1NodeList = new ArrayList<>();
        prim2NodeList = new ArrayList<>();
        list = new List[N + 1];
        for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        list[1].add(new Node(2, 5));
        list[1].add(new Node(3, 4));
        list[2].add(new Node(1, 5));
        list[2].add(new Node(3, 2));
        list[2].add(new Node(4, 7));
        list[3].add(new Node(1, 4));
        list[3].add(new Node(2, 2));
        list[3].add(new Node(4, 6));
        list[3].add(new Node(5, 11));
        list[4].add(new Node(2, 7));
        list[4].add(new Node(3, 6));
        list[4].add(new Node(5, 3));
        list[4].add(new Node(6, 8));
        list[5].add(new Node(3, 11));
        list[5].add(new Node(4, 3));
        list[5].add(new Node(6, 8));
        list[6].add(new Node(4, 8));
        list[6].add(new Node(5, 6));
        System.out.println("Prim1 : " + Prim1());
        for(int i : prim1NodeList) System.out.print(i + " ");
        System.out.println();
        System.out.println("Prim2 : " + Prim2());
        for(int i : prim2NodeList) System.out.print(i + " ");
    }

    // 1. 배열을 사용하여 T와 각 노드를 연결하는 최소 간선 가중치를 찾는 방법 시간복잡도는 O(V^2)
    private static long Prim1() {
        // dist[i]는 T에 들어간 노드와 i 노드 사이의 간선 가중치 중 최소값
        int[] dist = new int[N + 1];
        // selected[i]는 i노드가 T에 들어가 있는지 체크
        boolean[] selected = new boolean[N + 1];
        for(int i = 1; i <= N; i++) { // 초기화
            dist[i] = INF;
            selected[i] = false;
        }
        long sum = 0; // 최소 신장트리를 구성하는 가중치의 최소값
        dist[1] = 0; // 시작점을 1번 노드로 선택 => 임의의 점부터 시작할 수 있음
        for(int i = 1; i <= N; i++) {
            int now = -1, min_dist = INF; // now는 다음에 연결할 노드를 저장, mid_dist는 다음에 연결할 가장 작은 가중치를 잦아서 저장
            for(int j = 1; j <= N; j++) {
                if (!selected[j] && min_dist > dist[j]) {
                    min_dist = dist[j];
                    now = j;
                }
            }
            if(now < 0) return INF; // 연결 그래프가 아님
            sum += min_dist;
            selected[now] = true;
            for(Node node : list[now]) {
                dist[node.end] = Math.min(dist[node.end], node.weight);
            }
            prim1NodeList.add(now);
        }
        return sum;
    }

    // 2. 최소 힙(우선순위 큐)를 사용하여 최소의 간선 가중치를 찾는 방법 시간복잡도는 O(ElogE) == O(ElogV)
    private static long Prim2() {
        // T 에 포함된 노드에서 출발하는 간선들을 넣은 최소 힙, 우선순위는 가중치, 목적지 순
        PriorityQueue<Node> dist = new PriorityQueue<>();
        // selected[i]는 i노드가 T에 들어가 있는지 체크
        boolean[] selected = new boolean[N + 1];
        for(int i = 1; i <= N; i++) selected[i] = false;
        long sum = 0;
        dist.add(new Node(1, 0));
        for(int i = 1; i <= N; i++) {
            int now = -1, min_dist = INF;
            while(!dist.isEmpty()) {
                now = dist.peek().end;
                if(!selected[now]) { // 다음 노드가 아직 T에 들어있지 않다면 힙에 추가 => 최소 힙이므로 top에 있는것이 최소의 가중치를 가짐
                    min_dist = dist.peek().weight;
                    break;
                }
                dist.poll();
            }
            if(min_dist == INF) return INF; //  연결 그래프가 아님
            sum += min_dist;
            selected[now] = true;
            dist.addAll(list[now]);
            prim2NodeList.add(now);
        }
        return sum;
    }

    private static class Node implements Comparable<Node> {
        int end; int weight;
        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}


