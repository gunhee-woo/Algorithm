package baekJoon.Tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class tree_1068 {
    static int N;
    static ArrayList<Integer>[] arr;
    static boolean[] check;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = (ArrayList<Integer>[]) new ArrayList[N];
        for(int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int root = 0;
        for(int i = 0; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());
            if(v == -1) {
                root = i;
                continue;
            }
            arr[v].add(i);
            arr[i].add(v);
        }
        int remove = Integer.parseInt(br.readLine());
        check = new boolean[N];
        check[remove] = true;
        int count = 0;
        if(!check[root]) {
            Queue<Integer> q = new LinkedList<>();
            q.add(root);
            check[root] = true;
            while(!q.isEmpty()) {
                int cv = q.peek();
                q.poll();
                int child = 0;
                for(int i = 0; i < arr[cv].size(); i++) {
                    int next = arr[cv].get(i);
                    if(!check[next]) {
                        q.add(next);
                        check[next] = true;
                        child++;
                    }
                }
                if(child == 0) count++;
            }
        }
        System.out.print(count);
    }

    static void print() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < arr[i].size(); j++) {
                System.out.print(arr[i].get(j) + " ");
            }
            System.out.println();
        }
    }
}
