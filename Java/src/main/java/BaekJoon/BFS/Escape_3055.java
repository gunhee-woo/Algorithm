package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

// BFS => 어떤 점에 도달하는 시간을 재야함
public class Escape_3055 {
    static int MAX = 51;
    static int R, C;
    static char[][] map;
    static int[][] wMap; // 물이 찬 시간을 재기위한 자료구조
    static boolean[][] check;
    static int[] ax = {-1, 1, 0, 0};
    static int[] ay = {0, 0, -1, 1};
    static int answer = 987654321;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[MAX][MAX];
        wMap = new int[MAX][MAX];
        check = new boolean[MAX][MAX];
        Queue<point> gq = new LinkedList<>();
        Queue<point> wq = new LinkedList<>();
        for(int i = 0; i < R; i++) {
            Arrays.fill(wMap[i], 987654321);
        }
        for(int i = 0; i < R; i++) {
            String line = br.readLine();
            for(int j = 0; j < C; j++) {
                char c = line.charAt(j);
                map[i][j] = c;
                if(c == 'S') {
                    gq.add(new point(i, j, 0));
                    check[i][j] = true;
                }
                if(c == '*') {
                    wq.add(new point(i, j));
                    wMap[i][j] = 0;
                }
            }
        }

        while(!wq.isEmpty()) {
            int cx = wq.peek().x;
            int cy = wq.peek().y;
            wq.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cx + ax[i];
                int ny = cy + ay[i];
                if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == 'X' || map[nx][ny] == 'D') continue;
                if(wMap[nx][ny] > wMap[cx][cy] + 1) {
                    wMap[nx][ny] = wMap[cx][cy] + 1;
                    wq.add(new point(nx, ny));
                }
            }
        }

        while(!gq.isEmpty()) {
            int cx = gq.peek().x;
            int cy = gq.peek().y;
            int cc = gq.peek().cnt;
            if(map[cx][cy] == 'D') {
                answer = Math.min(answer, cc);
                break;
            }
            gq.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cx + ax[i];
                int ny = cy + ay[i];
                int nc = cc + 1;
                if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == 'X' || map[nx][ny] == '*') continue;
                if(!check[nx][ny] && wMap[nx][ny] > nc) {
                    check[nx][ny] = true;
                    gq.add(new point(nx, ny, nc));
                }
            }
        }
        if(answer == 987654321) System.out.print("KAKTUS");
        else System.out.print(answer);
    }

    static void print() {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                System.out.print(wMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static class point {
        int x; int y; int cnt;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
