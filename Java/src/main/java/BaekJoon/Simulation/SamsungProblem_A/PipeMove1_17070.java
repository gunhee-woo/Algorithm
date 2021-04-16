package BaekJoon.Simulation.SamsungProblem_A;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class PipeMove1_17070 {
    static int MAX = 17;
    static int N;
    static int[][] arr;

    static int[] ax = {0, 1};
    static int[] ay = {1, 1};
    static pipe[] ap = {new pipe(0, 1, 0), new pipe(1, 1, 2)};

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[MAX][MAX];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<pipe> q = new LinkedList<>();
        q.add(new pipe(1, 2, 0));
        while(!q.isEmpty()) {
            pipe cp = q.peek();
            q.poll();
            if(cp.dir == 0) {
                for(int i = 0; i < 2; i++) {
                    pipe np = cp.add(ap[i]);
                }

            } else if(cp.dir == 1) {

            } else {

            }
        }

        print();
    }

    static void print() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class pipe {
        int x;
        int y;
        int dir;
        pipe(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        pipe add(pipe p) {
            return new pipe(this.x + p.x, this.y + p.y, this.dir);
        }
    }
}
