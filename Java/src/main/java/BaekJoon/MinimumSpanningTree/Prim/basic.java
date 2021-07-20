package BaekJoon.MinimumSpanningTree.Prim;

// ���� �˰���
// ���⼺�� ���� �׷���(����� �׷���)�� �־��� �� �ּ� ���д� Ʈ���� ã�� �˰���
// 1. ������ ������ �����Ͽ� T��� �׷���(�ּҽ���Ʈ��)�� ���Խ�Ų��
// 2. T�� �ִ� ���� T�� ���� ��� ������ ���� �� ����ġ�� �ּ��� ������ ã�´�
// 3. ã�� ������ �����ϴ� �� ��� ��, T�� ���� ��带 T�� ���Խ�Ų��
// 4. ��� ��尡 T�� ���Ե� ������ 1,2�� �ݺ��Ѵ�

// ���� �˰����� �� ���� ����� ����
// 1. �迭�� ����Ͽ� T�� �� ��带 �����ϴ� �ּ� ���� ����ġ�� ã�� ��� �ð����⵵�� O(V^2)
// 2. �ּ� ��(�켱���� ť)�� ����Ͽ� �ּ��� ���� ����ġ�� ã�� ��� �ð����⵵�� O(ElogE) == O(ElogV)
// V�� ������ ���� E�� ������ ����

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

    // 1. �迭�� ����Ͽ� T�� �� ��带 �����ϴ� �ּ� ���� ����ġ�� ã�� ��� �ð����⵵�� O(V^2)
    private static long Prim1() {
        // dist[i]�� T�� �� ���� i ��� ������ ���� ����ġ �� �ּҰ�
        int[] dist = new int[N + 1];
        // selected[i]�� i��尡 T�� �� �ִ��� üũ
        boolean[] selected = new boolean[N + 1];
        for(int i = 1; i <= N; i++) { // �ʱ�ȭ
            dist[i] = INF;
            selected[i] = false;
        }
        long sum = 0; // �ּ� ����Ʈ���� �����ϴ� ����ġ�� �ּҰ�
        dist[1] = 0; // �������� 1�� ���� ���� => ������ ������ ������ �� ����
        for(int i = 1; i <= N; i++) {
            int now = -1, min_dist = INF; // now�� ������ ������ ��带 ����, mid_dist�� ������ ������ ���� ���� ����ġ�� ��Ƽ� ����
            for(int j = 1; j <= N; j++) {
                if (!selected[j] && min_dist > dist[j]) {
                    min_dist = dist[j];
                    now = j;
                }
            }
            if(now < 0) return INF; // ���� �׷����� �ƴ�
            sum += min_dist;
            selected[now] = true;
            for(Node node : list[now]) {
                dist[node.end] = Math.min(dist[node.end], node.weight);
            }
            prim1NodeList.add(now);
        }
        return sum;
    }

    // 2. �ּ� ��(�켱���� ť)�� ����Ͽ� �ּ��� ���� ����ġ�� ã�� ��� �ð����⵵�� O(ElogE) == O(ElogV)
    private static long Prim2() {
        // T �� ���Ե� ��忡�� ����ϴ� �������� ���� �ּ� ��, �켱������ ����ġ, ������ ��
        PriorityQueue<Node> dist = new PriorityQueue<>();
        // selected[i]�� i��尡 T�� �� �ִ��� üũ
        boolean[] selected = new boolean[N + 1];
        for(int i = 1; i <= N; i++) selected[i] = false;
        long sum = 0;
        dist.add(new Node(1, 0));
        for(int i = 1; i <= N; i++) {
            int now = -1, min_dist = INF;
            while(!dist.isEmpty()) {
                now = dist.peek().end;
                if(!selected[now]) { // ���� ��尡 ���� T�� ������� �ʴٸ� ���� �߰� => �ּ� ���̹Ƿ� top�� �ִ°��� �ּ��� ����ġ�� ����
                    min_dist = dist.peek().weight;
                    break;
                }
                dist.poll();
            }
            if(min_dist == INF) return INF; //  ���� �׷����� �ƴ�
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


