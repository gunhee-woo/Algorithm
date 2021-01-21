package BaekJoon.BFS;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static Util.Constants.INPUT;

public class HideAndSeek3_13549 {
    static int MAX = 100001;
    static boolean[] check;
    static int[] ax= {-1, 1, 2};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int K = sc.nextInt();
        check = new boolean[MAX + 1];
        Queue<pair> q = new LinkedList<>();
        check[N] = true;
        q.add(new pair(N, 0));
        while(!q.isEmpty()) {
            int cx = q.element().x;
            int cc = q.element().c;
            if(cx == K) {
                System.out.println(cc);
                return;
            }
            q.poll();
            for(int i = 0; i < 3; i++) {
                int nx = cx;
                if(i == 2) {
                    nx *= ax[i];
                    if(nx < 0 || nx > MAX - 1) continue;
                    if(!check[nx]) {
                        check[nx] = true;
                        q.add(new pair(nx, cc));
                    }
                } else {
                    nx += ax[i];
                    if(nx < 0 || nx > MAX - 1) continue;
                    if(!check[nx]) {
                        check[nx] = true;
                        q.add(new pair(nx, cc + 1));
                    }
                }
            }

        }
    }

    static class pair {
        public int x;
        public int c;
        pair(int x, int c) {
            this.x = x;
            this.c = c;
        }
    }
}
