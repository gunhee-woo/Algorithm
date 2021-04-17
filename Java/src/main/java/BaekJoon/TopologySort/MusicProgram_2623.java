package BaekJoon.TopologySort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

// �������� + �׸���
public class MusicProgram_2623 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] list = new List[N + 1];
        int[] inDeg = new int[N + 1]; // ������ �켱������ ���븦 �����ؾ� �ϴ� ��
        // inDeg[a] = b -> a�� ������ ���뿡 ������ ���� b���� ������ ������ ���븦 �����ؾ� ��
        for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> lt = new ArrayList<>();
            int k = Integer.parseInt(st.nextToken());
            for(int j = 0; j < k; j++) {
                lt.add(Integer.parseInt(st.nextToken()));
            }
            for(int j = 0; j < k; j++) {
                for(int t = j + 1; t < k; t++) {
                    list[lt.get(j)].add(lt.get(t));
                    inDeg[lt.get(t)]++;
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            if(inDeg[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int cur = q.poll();
            result.add(cur);
            for(int i = 0; i < list[cur].size(); i++) {
                int next = list[cur].get(i);
                inDeg[next]--;
                if(inDeg[next] == 0) q.add(next);
            }
        }
        if(result.size() != N) System.out.print(0);
        else {
            for(int i : result) System.out.println(i);
        }
    }
}
