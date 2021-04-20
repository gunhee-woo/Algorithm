package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

public class Escape_3055 {
    static int MAX = 51;
    static int R, C;
    static char[][] map;
    static boolean[][] check;
    static point bb, go;
    static int[] ax = {-1, 1, 0, 0};
    static int[] ay = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[MAX][MAX];
        check = new boolean[MAX][MAX];
        Queue<point> gq = new LinkedList<>();
        Queue<point> wq = new LinkedList<>();
        for(int i = 0; i < R; i++) {
            String line = br.readLine();
            for(int j = 0; j < C; j++) {
                char c = line.charAt(j);
                map[i][j] = c;
                if(c == 'D') {
                    bb = new point(i, j);
                }
                if(c == 'S') {
                    go = new point(i, j);
                    check[i][j] = true;
                    gq.add(go);
                }
                if(c == '*') {
                    wq.add(new point(i, j));
                    check[i][j] = true;
                }
            }
        }
        int answer = 0;
        List<point> waters = new ArrayList<>();
        while(!gq.isEmpty()) {
            int cx = gq.peek().x;
            int cy = gq.peek().y;
            gq.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cx + ax[i];
                int ny = cy + ay[i];
                if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if(map[nx][ny] == 'D') {
                    System.out.print(answer);
                    System.exit(0);
                }
                if(!check[nx][ny] && map[nx][ny] == '.') {
                    if(!isNextWater(nx, ny)) {
                        check[nx][ny] = true;
                        gq.add(new point(nx, ny));
                    }
                }
            }
            wq.addAll(waters);
            waters.clear();
            while(!wq.isEmpty()) {
                cx = wq.peek().x;
                cy = wq.peek().y;
                wq.poll();
                for(int j = 0; j < 4; j++) {
                    int nx = cx + ax[j];
                    int ny = cy + ay[j];
                    if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == 'X' || map[nx][ny] == 'D') continue;
                    if(map[nx][ny] == 'S') {
                        System.out.print("KAKTUS");
                        System.exit(0);
                    }
                    check[nx][ny] = true;
                    map[nx][ny] = '*';
                    waters.add(new point(nx, ny));
                }
            }
            answer++;
        }
    }

    private static boolean isNextWater(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nx = x + ax[i];
            int ny = y + ay[i];
            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if(map[nx][ny] == '*') return true;
        }
        return false;
    }


    private static class point {
        int x; int y; int cnt;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
