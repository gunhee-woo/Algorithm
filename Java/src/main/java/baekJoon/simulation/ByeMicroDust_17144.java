package baekJoon.simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

public class ByeMicroDust_17144 {
    static int R, C, T;
    static int[][] map;
    static int[][] cmap;
    static Point p1, p2;
    static int MAX = 55;
    static Queue<Point> q;
    // 위 아래 오른쪽 왼쪽
    static int[] ax = {-1, 1, 0, 0};
    static int[] ay = {0, 0, 1, -1};
    static int[] ccw = {2, 0, 3, 1};
    static int[] cw = {2, 1, 3, 0};
    static int answer;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[MAX][MAX];
        cmap = new int[MAX][MAX];
        q = new LinkedList<>();
        for(int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(cmap[i], 0);
            for(int j = 1; j <= C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1) {
                    cmap[i][j] = -1;
                    if(p1 == null) p1 = new Point(i, j); // 공기청정기 위쪽
                    else p2 = new Point(i, j);
                } else if(map[i][j] != 0) {
                    q.add(new Point(i, j));
                    answer += map[i][j];
                }
            }
        }
        while(T-- > 0) {
            move();
            cleanerUpWork(p1.x, p1.y);
            cleanerDownWork(p2.x, p2.y);
            initQueue();
        }
        System.out.print(answer);
    }

    private static void cleanerWork(int x, int y, int[] dir) {
        map[x][y + 1] = 0;
        for(int i = 0; i < 4; i++) {
            while(true) {
                int nx = x + ax[dir[i]];
                int ny = y + ay[dir[i]];
                if(nx <= 0 || ny <= 0 || nx > R || ny > C) break;
                if(nx == x && ny == y) break;

            }
        }
    }

    private static void initQueue() {
        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                if(map[i][j] != -1 && map[i][j] != 0) {
                    q.add(new Point(i, j));
                }
            }
        }
    }

    private static void cleanerUpWork(int x, int y) {
        // right
        int prev = map[x][y + 1];
        map[x][y + 1] = 0;
        for(int i = y + 2; i <= C; i++) {
            int temp = map[x][i];
            map[x][i] = prev;
            prev = temp;
        }
        // up
        for(int i = x - 1; i > 0; i--) {
            int temp = map[i][C];
            map[i][C] = prev;
            prev = temp;
        }
        // left
        for(int i = C - 1; i > 0; i--) {
            int temp = map[1][i];
            map[1][i] = prev;
            prev = temp;
        }
        // down
        for(int i = 1; i < x; i++) {
            int temp = map[i][y];
            map[i][y] = prev;
            prev = temp;
        }
        answer -= prev;
    }

    private static void cleanerDownWork(int x, int y) {
        int prev = map[x][y + 1];
        map[x][y + 1] = 0;
        // right
        for(int i = y + 2; i <= C; i++) {
            int temp = map[x][i];
            map[x][i] = prev;
            prev = temp;
        }
        // down
        for(int i = x + 1; i <= R; i++) {
            int temp = map[i][C];
            map[i][C] = prev;
            prev = temp;
        }
        // left
        for(int i = C - 1; i > 0; i--) {
            int temp = map[R][i];
            map[R][i] = prev;
            prev = temp;
        }
        // up
        for(int i = R - 1; i > x; i--) {
            int temp = map[i][y];
            map[i][y] = prev;
            prev = temp;
        }
        answer -= prev;
    }

    private static void move() {
        while(!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.peek().y;
            q.poll();
            int cnt = 0;
            for(int i = 0; i < 4; i++) {
                int nx = cx + ax[i];
                int ny = cy + ay[i];
                if(nx <= 0 || ny <= 0 || nx > R || ny > C || map[nx][ny] == -1) continue;
                cmap[nx][ny] += (map[cx][cy] / 5);
                cnt++;
            }
            map[cx][cy] -= ((map[cx][cy] / 5) * cnt);
        }
        merge();
    }

    private static void merge() {
        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                if(map[i][j] != -1) {
                    map[i][j] += cmap[i][j];
                    cmap[i][j] = 0;
                }
            }
        }
    }

    private static void print1() {
        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void print2() {
        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                System.out.print(cmap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static class Point {
        int x; int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
