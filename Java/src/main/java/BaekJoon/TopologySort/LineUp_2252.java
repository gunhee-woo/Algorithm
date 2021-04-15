package BaekJoon.TopologySort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

public class LineUp_2252 {
    static int N, M;
    static int MAX = 32001;
    static List<Integer>[] list; // �������
    static List<Integer> result; // ���������� ����� ��� ��
    static int[] inDeg; // �� �������� ������ ������ ���� ���� �迭
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
        for(int i = 0; i <= N; i++) { // ������� �ʱ�ȭ
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            inDeg[b]++; // ������ ������ ������ ������ ��
        }
        for(int i = 1; i <= N; i++) {
            if(inDeg[i] == 0) q.add(i); // �������� ������ ������ ������ 0�� ������ ť�� ����
        }
        while(!q.isEmpty()) { // ť���� ������ ������ �̹� �������� �տ� ��ġ�����Ƿ� �Ű澲�� �ʾƵ� �� == ���� �������� �� �̻� �ٸ� �������� ������ ������ ����
            int cur = q.poll();
            result.add(cur);
            for(int i = 0; i < list[cur].size(); i++) {
                int next = list[cur].get(i);
                inDeg[next]--;
                if(inDeg[next] == 0) q.add(next);
            }
        }
//        if(result.size() != N) { // ���������� ����� ũ��� ������ ������ �ٸ��ٸ� ����Ŭ�� �����ϴ� ��
//            System.out.print("Cycle Exists");
//        }
        for(int r : result) System.out.print(r + " ");
    }
}
