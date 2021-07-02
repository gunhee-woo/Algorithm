package BaekJoon.Simulation.SamsungProblem_A;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class WizardSharkAndFireball_20056 {
    static int N, M, K;
    static Point[][] map, cmap;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static Queue<Point> q;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new Point[55][55];
        cmap = new Point[55][55];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                map[i][j] = new Point(i, j);
                cmap[i][j] = new Point(i, j);
            }
        }
        q = new LinkedList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            FireBall fireBall = new FireBall(r, c, m, s, d);
            map[r][c].list.add(fireBall);
            q.add(map[r][c]);
        }
        while(K-- > 0) {
            move();
            operate();
            initQueue();
        }
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(!map[i][j].list.isEmpty()) {
                    for(FireBall fireBall : map[i][j].list) {
                        answer += fireBall.m;
                    }
                }
            }
        }
        System.out.print(answer);
    }

    private static void move() {
        while(!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.peek().y;
            List<FireBall> cList = q.peek().list;
            q.poll();
            for(FireBall f : cList) {
                int nx = cx + (dx[f.d] * (f.s % N));
                int ny = cy + (dy[f.d] * (f.s % N));
                if(nx <= 0) {
                    nx += N;
                }
                if(nx > N) {
                    nx -= N;
                }
                if(ny <= 0) {
                    ny += N;
                }
                if(ny > N) {
                    ny -= N;
                }
                FireBall fireBall = new FireBall(nx, ny, f.m, f.s, f.d);
                cmap[nx][ny].list.add(fireBall);
            }
            map[cx][cy] = new Point(cx, cy);
        }
    }

    private static void operate() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(cmap[i][j].list.isEmpty()) continue;
                if(cmap[i][j].list.size() > 1) {
                    int sm = 0; int ss = 0; int sz = cmap[i][j].list.size(); int sd1 = 0; int sd2 = 0;
                    for(FireBall f : cmap[i][j].list) {
                        sm += f.m;
                        ss += f.s;
                        if(f.d % 2 == 0) sd2++;
                        else sd1++;
                    }
                    cmap[i][j] = new Point(i, j);
                    if(sm / 5 != 0) {
                        if(sd2 == 0 || sd1 == 0) {
                            for(int k = 0; k < 4; k++) {
                                map[i][j].list.add(new FireBall(i, j, sm / 5, ss / sz , k * 2));
                            }
                        } else {
                            for(int k = 0; k < 4; k++) {
                                map[i][j].list.add(new FireBall(i, j, sm / 5, ss / sz , k * 2 + 1));
                            }
                        }
                    }
                } else {
                    map[i][j].list.addAll(cmap[i][j].list);
                    cmap[i][j] = new Point(i, j);
                }
            }
        }
    }

    private static void initQueue() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(!map[i][j].list.isEmpty()) {
                    q.add(map[i][j]);
                }
            }
        }
    }

    private static class Point {
        int x; int y; List<FireBall> list;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
            list = new ArrayList<>();
        }
    }

    private static class FireBall {
        int r; int c; int m; int s; int d;
        FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}
