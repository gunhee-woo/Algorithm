package baekJoon.simulation.SamsungProblem_A;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

public class KingOfFishing_17143 {
    static int R, C, M;
    static Shark[][] map;
    static int[] ax = {-1, 1, 0, 0}; // 위 아래 오른쪽 왼쪽
    static int[] ay = {0, 0, 1, -1};
    static Queue<Shark> q;
    static int answer;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Shark[R + 1][C + 1];
        q = new LinkedList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            map[r][c] = new Shark(s, d - 1, z);
        }
        for(int fisher = 1; fisher <= C; fisher++) {
            if(fisher != 1) initMap();
            setMap();
            fishing(fisher);
            move();
        }
        print(answer);
    }

    private static void initMap() {
        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                map[i][j] = null;
            }
        }
    }

    private static void setMap() {
        while(!q.isEmpty()) {
            int sx = q.peek().x;
            int sy = q.peek().y;
            int size = q.peek().z;
            if(map[sx][sy] != null) {
                if(map[sx][sy].z < size) {
                    map[sx][sy] = q.poll();
                } else
                    q.poll();
            } else {
                map[sx][sy] = q.poll();
            }
        }
    }

    private static void move() {
        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                if(map[i][j] != null) {
                    moveShark(i, j);
                }
            }
        }
    }

    private static void moveShark(int x, int y) {
        int speed = map[x][y].s;
        int dir = map[x][y].d;
        int size = map[x][y].z;
        int sx = x; int sy = y;
        map[sx][sy] = null;
        for(int i = 0; i < speed; i++) {
            sx += ax[dir];
            sy += ay[dir];
            if(isTurnDir(sx, sy, dir)) {
                dir = changeDir(dir);
            }
        }
        q.add(new Shark(sx, sy, speed, dir, size));
    }

    private static void fishing(int fisher) {
        for(int i = 1; i <= R; i++) {
            if(map[i][fisher] != null) {
                answer += map[i][fisher].z;
                map[i][fisher] = null;
                return;
            }
        }
    }

    private static boolean isTurnDir(int x, int y, int dir) {
        return (x <= 1 && dir == 0) || (y <= 1 && dir == 3) || (x >= R && dir == 1) || (y >= C && dir == 2);
    }

    private static int changeDir(int dir) {
        if(dir == 0) return 1;
        else if(dir == 1) return 0;
        else if(dir == 2) return 3;
        else return 2;
    }

    private static void printMap() {
        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                if(map[i][j] != null) {
                    print(i + "," + j + " " + map[i][j].s + " " + map[i][j].d + " " + map[i][j].z + "\n");
                }
            }
        }
    }

    private static void print(Object o) {
        System.out.print(o);
    }

    static class Shark {
        int x; int y;
        int s;
        int d;
        int z;
        public Shark(int s, int d, int z) {
            this.s = s;
            this.d = d;
            this.z = z;
        }
        public Shark(int x, int y, int s, int d, int z) {
            this.x = x;
            this.y = y;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
