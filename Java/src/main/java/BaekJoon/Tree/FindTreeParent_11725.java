package BaekJoon.Tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

public class FindTreeParent_11725 {
    static int N;
    static List<Integer>[] list;
    static int[] answer;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new List[N + 1];
        answer = new int[N + 1];
        Arrays.fill(answer, 0);
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()) {
            int cur = q.peek();
            q.poll();
            for(int i = 0; i < list[cur].size(); i++) {
                int ix = list[cur].get(i);
                if(answer[ix] == 0) {
                    answer[ix] = cur;
                    q.add(ix);
                }
            }
        }
        for(int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }
}
