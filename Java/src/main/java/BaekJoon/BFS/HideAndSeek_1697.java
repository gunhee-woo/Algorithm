package BaekJoon.BFS;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static Util.Constants.INPUT;

// 수빈이와 동생의 위치가 0에서 100000 사이라고만 문제에서 명시되어 있음
// 수빈이가 이동 시 100000 밖으로 나갔다가 다시 안으로 오는 경우의 수도 존재
// 하지만 빠른 경로를 찾고 있는 상황에서 200000을 넘어가는 상황은 발생하지 않음
// 또한 애초에 100000을 탈출하는 것 자체가 손해임
// 100000을 탈출하는 것은 X2를 한 후 -1을 여러번하는 경우인데
// 그렇게 할 바에야 먼저 -1을 하고 X2를 하는 방법이 더 낫기 때문

/** BFS 유형 4 - 1차원에서의 BFS */
public class HideAndSeek_1697 {
    static int MAX = 100001;
    static int[] ax = {-1,1,2};
    static boolean[] check;
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
            int cc = q.element().count;
            if(cx == K) {
                System.out.println(cc);
                return;
            }
            q.poll();
            for(int i = 0; i < 3; i++) {
                int nx = cx;
                if(i == 2) nx *= ax[i];
                else nx += ax[i];
                if(nx < 0 || nx > MAX - 1) continue;
                if(!check[nx]) {
                    check[nx] = true;
                    q.add(new pair(nx, cc + 1));
                }
            }
        }
    }

    static class pair {
        public int x, count;
        pair(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }
}
