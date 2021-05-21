package BaekJoon.Simulation.SamsungProblem_A;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

public class babyShark_16236 {
    static int N;
    static int[][] map;
    static boolean[][] check;
    static int[] ax = {-1, 0, 0, 1};
    static int[] ay = {0, -1, 1, 0};
    static Shark sk;
    static PriorityQueue<Point> pq;
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.cnt == o2.cnt) {
                    if(o1.x == o2.x) return o1.y - o2.y;
                    else return o1.x - o2.x;
                }
                else return o1.cnt - o2.cnt;
            }
        });
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        check = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) sk = new Shark(i, j,2,0);
                else {
                    if(map[i][j] != 0) pq.add(new Point(i, j, map[i][j]));
                }
            }
        }

        if(pq.size() == 1) {
            answer = move(pq.peek().x, pq.peek().y);
            System.out.print(answer);
        } else {
            while(!pq.isEmpty()) {
                int cx = pq.peek().x;
                int cy = pq.peek().y;
                int size = pq.peek().cnt;
                pq.poll();
                if(size >= sk.size) break;
                int temp = move(cx, cy);
                System.out.println(temp);
                if(temp != 0) {
                    map[cx][cy] = 0;
                    answer += temp;
                    sk.x = cx;
                    sk.y = cy;
                    sk.cnt++;
                    if(sk.size == sk.cnt) {
                        sk.size++;
                        sk.cnt = 0;
                    }
                }
            }
            System.out.print(answer);
        }
    }

    static int move(int x, int y) {
        int answer = 0;
        Queue<Point> q = new LinkedList<>();
        boolean[][] ck = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            ck[i] = check[i].clone();
        }
        q.add(new Point(sk.x, sk.y, 0));
        ck[sk.x][sk.y] = true;
        while(!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.peek().y;
            int cc = q.peek().cnt;
                if(cx == x && cy == y) {
                    answer = cc;
                    break;
            }
            q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cx + ax[i];
                int ny = cy + ay[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(!ck[nx][ny] && map[nx][ny] <= sk.size) {
                    q.add(new Point(nx, ny, cc + 1));
                }
            }
        }
        return answer;
    }

    static class Point {
        int x; int y; int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static class Shark {
        int x; int y; int size; int cnt;

        public Shark(int x, int y, int size, int cnt) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.cnt = cnt;
        }
    }
}
