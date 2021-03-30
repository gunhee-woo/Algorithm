package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

public class easy_2048_12100 {
    static int N;
    static int max = 0;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        dfs(0, arr);
        System.out.print(max);
    }

    static void dfs(int k, int[][] arr) {
        if(k == 5) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    max = Math.max(max, arr[i][j]);
                }
            }
            return;
        }
        dfs(k + 1, north(arr));
        dfs(k + 1, south(arr));
        dfs(k + 1, west(arr));
        dfs(k + 1, east(arr));
    }

    static int[][] north(int[][] a) {
        int[][] an = copy(a);
        for(int i = 0; i < N; i++) {
            Queue<Integer> q = new LinkedList<>();
            for(int j = 0; j < N; j++) {
                if(an[j][i] != 0) q.add(an[j][i]);
            }
            int pre = -1;
            List<Integer> list = new ArrayList<>();
            while(!q.isEmpty()) {
                if(pre == -1) {
                    pre = q.peek();
                    q.poll();
                    if(q.isEmpty()) list.add(pre);
                    continue;
                }
                if(pre == q.peek()) {
                    list.add(pre + q.peek());
                    q.poll();
                    pre = -1;
                } else {
                    list.add(pre);
                    pre = q.peek();
                    q.poll();
                    if(q.isEmpty()) list.add(pre);
                }
            }
            for(int j = 0; j < N; j++) {
                if(j >= list.size()) an[j][i] = 0;
                else an[j][i] = list.get(j);
            }
        }
        return an;
    }

    static int[][] south(int[][] a) {
        int[][] an = copy(a);
        for(int i = 0; i < N; i++) {
            Queue<Integer> q = new LinkedList<>();
            for(int j = N - 1; j >= 0; j--) {
                if(an[j][i] != 0) q.add(an[j][i]);
            }
            int pre = -1;
            List<Integer> list = new ArrayList<>();
            while(!q.isEmpty()) {
                if(pre == -1) {
                    pre = q.peek();
                    q.poll();
                    if(q.isEmpty()) list.add(pre);
                    continue;
                }
                if(pre == q.peek()) {
                    list.add(pre + q.peek());
                    q.poll();
                    pre = -1;
                } else {
                    list.add(pre);
                    pre = q.peek();
                    q.poll();
                    if(q.isEmpty()) list.add(pre);
                }
            }
            int ix = 0;
            for(int j = N - 1; j >= 0; j--) {
                if(ix >= list.size()) an[j][i] = 0;
                else an[j][i] = list.get(ix++);
            }
        }
        return an;
    }

    static int[][] west(int[][] a) {
        int[][] an = copy(a);
        for(int i = 0; i < N; i++) {
            Queue<Integer> q = new LinkedList<>();
            for(int j = 0; j < N; j++) {
                if(an[i][j] != 0) q.add(an[i][j]);
            }
            int pre = -1;
            List<Integer> list = new ArrayList<>();
            while(!q.isEmpty()) {
                if(pre == -1) {
                    pre = q.peek();
                    q.poll();
                    if(q.isEmpty()) list.add(pre);
                    continue;
                }
                if(pre == q.peek()) {
                    list.add(pre + q.peek());
                    q.poll();
                    pre = -1;
                } else {
                    list.add(pre);
                    pre = q.peek();
                    q.poll();
                    if(q.isEmpty()) list.add(pre);
                }
            }
            for(int j = 0; j < N; j++) {
                if(j >= list.size()) an[i][j] = 0;
                else an[i][j] = list.get(j);
            }
        }
        return an;
    }

    static int[][] east(int[][] a) {
        int[][] an = copy(a);
        for(int i = 0; i < N; i++) {
            Queue<Integer> q = new LinkedList<>();
            for(int j = N - 1; j >= 0; j--) {
                if(an[i][j] != 0) q.add(an[i][j]);
            }
            int pre = -1;
            List<Integer> list = new ArrayList<>();
            while(!q.isEmpty()) {
                if(pre == -1) {
                    pre = q.peek();
                    q.poll();
                    if(q.isEmpty()) list.add(pre);
                    continue;
                }
                if(pre == q.peek()) {
                    list.add(pre + q.peek());
                    q.poll();
                    pre = -1;
                } else {
                    list.add(pre);
                    pre = q.peek();
                    q.poll();
                    if(q.isEmpty()) list.add(pre);
                }
            }
            int ix = 0;
            for(int j = N - 1; j >= 0; j--) {
                if(ix >= list.size()) an[i][j] = 0;
                else an[i][j] = list.get(ix++);
            }
        }
        return an;
    }

    static int[][] copy(int[][] a) {
        int[][] copy = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                copy[i][j] = a[i][j];
            }
        }
        return copy;
    }

    static void print(int[][] an) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(an[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
