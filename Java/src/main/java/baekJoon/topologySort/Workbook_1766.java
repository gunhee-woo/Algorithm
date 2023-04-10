package baekJoon.topologySort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// ��������  + �켱���� ť
// 1. N���� ������ ��� Ǯ��� �Ѵ�.
// 2. ���� Ǫ�� ���� ���� ������ �ִ� ������, ���� Ǫ�� ���� ���� ������ �ݵ�� ���� Ǯ��� �Ѵ�.
// => ��������
// 3 .�����ϸ� ���� �������� Ǯ��� �Ѵ�.(��������) => �켱���� ť�� ����Ͽ� �ڵ����� ����
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
//        if(result.size() != N) System.out.print("����Ŭ�� ����");
        for(int i : result) System.out.print(i + " ");
    }
}
