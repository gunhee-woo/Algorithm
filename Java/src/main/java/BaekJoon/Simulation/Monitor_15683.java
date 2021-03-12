package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// 시간초과 코드
public class Monitor_15683 {
    static int MAX = 9;
    static int N, M;
    static int[][] map;
    static int[][] cmap;
    static List<cctv> list;
    static int count = 987654321;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[MAX][MAX];
        list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0; j < M; j++) {
                map[i][j] = a[j];
                if(map[i][j] != 0 && map[i][j] != 6) list.add(new cctv(i, j, map[i][j], -1));
                if(map[i][j] == 0) count++;
            }
        }
        dfs(0);
        System.out.print(count);
    }

    static void dfs(int k) {
        if(k == list.size()) {
            search();
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(cmap[i][j] == 0) cnt++;
                }
            }
            count = Math.min(count, cnt);
            return;
        }
        list.get(k).dir = 0; // up
        dfs(k + 1);

        list.get(k).dir = 1; // down
        dfs(k + 1);

        list.get(k).dir = 2; // left
        dfs(k + 1);

        list.get(k).dir = 3; // right
        dfs(k + 1);
    }

    static void search() {
        cmap = map;
        for(int i = 0; i < list.size(); i++) {
            cctv ctv = list.get(i);
            if(ctv.num == 1) {
                if(ctv.dir == 0) up(ctv.x, ctv.y);
                else if(ctv.dir == 1) down(ctv.x, ctv.y);
                else if(ctv.dir == 2) left(ctv.x, ctv.y);
                else if(ctv.dir == 3) right(ctv.x, ctv.y);
            } else if(ctv.num == 2) {
                if(ctv.dir == 0 || ctv.dir == 1) { up(ctv.x, ctv.y); down(ctv.x, ctv.y);}
                else if(ctv.dir == 2 || ctv.dir == 3) { left(ctv.x, ctv.y); right(ctv.x, ctv.y);}
            } else if(ctv.num == 3) {
                if(ctv.dir == 0) { up(ctv.x, ctv.y); right(ctv.x, ctv.y);}
                else if(ctv.dir == 1) { right(ctv.x, ctv.y); down(ctv.x, ctv.y);}
                else if(ctv.dir == 2) { down(ctv.x, ctv.y); left(ctv.x, ctv.y);}
                else if(ctv.dir == 3) { left(ctv.x, ctv.y); up(ctv.x, ctv.y);}
            } else if(ctv.num == 4) {
                if(ctv.dir == 0) { up(ctv.x, ctv.y); right(ctv.x, ctv.y); left(ctv.x, ctv.y);}
                else if(ctv.dir == 1) { right(ctv.x, ctv.y); down(ctv.x, ctv.y); up(ctv.x, ctv.y);}
                else if(ctv.dir == 2) { down(ctv.x, ctv.y); left(ctv.x, ctv.y); right(ctv.x, ctv.y);}
                else if(ctv.dir == 3) { left(ctv.x, ctv.y); up(ctv.x, ctv.y); down(ctv.x, ctv.y); }
            } else if(ctv.num == 5) {
                left(ctv.x, ctv.y); right(ctv.x, ctv.y); up(ctv.x, ctv.y); down(ctv.x, ctv.y);
            }
        }
    }

//    static void dfs(int k) {
//        if(k == list.size()) {
//            int cnt = 0;
//            for(int i = 0; i < N; i++) {
//                for(int j = 0; j < M; j++) {
//                    if(cmap[i][j] == 0) cnt++;
//                }
//            }
//            count = Math.min(count, cnt);
//            return;
//        }
//        int ax = list.get(k).x;
//        int ay = list.get(k).y;
//        if(map[ax][ay] == 1) {
//            for(int i = 0; i < 4; i++) {
//                if(i == 0) up(ax, ay);
//                if(i == 1) down(ax, ay);
//                if(i == 2) left(ax, ay);
//                if(i == 3) right(ax, ay);
//                dfs(k + 1);
//            }
//        } else if(map[ax][ay] == 2) {
//            for(int i = 0; i < 2; i++) {
//                if(i == 0) { left(ax, ay); right(ax, ay);}
//                if(i == 1) { up(ax, ay); down(ax, ay); }
//                dfs(k + 1);
//            }
//        } else if(map[ax][ay] == 3) {
//            for(int i = 0; i < 4; i++) {
//                if(i == 0) { up(ax, ay); right(ax, ay); }
//                if(i == 1) { right(ax, ay); down(ax, ay); }
//                if(i == 2) { left(ax, ay); down(ax, ay); }
//                if(i == 3) { up(ax, ay); left(ax, ay); }
//                dfs(k + 1);
//            }
//        } else if(map[ax][ay] == 4) {
//            for(int i = 0; i < 4; i++) {
//                if(i == 0) { left(ax, ay); up(ax, ay); right(ax, ay); }
//                if(i == 1) { up(ax, ay); right(ax, ay); down(ax, ay); }
//                if(i == 2) { right(ax, ay); left(ax, ay); down(ax, ay); }
//                if(i == 3) { up(ax, ay); left(ax, ay); down(ax, ay); }
//                dfs(k + 1);
//            }
//        } else if(map[ax][ay] == 5) {
//            left(ax, ay); up(ax, ay); right(ax, ay); down(ax, ay);
//            dfs(k + 1);
//        }
//    }

    static void up(int x, int y) {
        for(int i = x - 1; i >= 0; i--) {
            if(cmap[i][y] == 6) break;
            if(cmap[i][y] == 0) {
                cmap[i][y] = 7;
            }
        }
    }

    static void down(int x, int y) {
        for(int i = x + 1; i < N; i++) {
            if(cmap[i][y] == 6) break;
            if(cmap[i][y] == 0) {
                cmap[i][y] = 7;
            }
        }
    }

    static void left(int x, int y) {
        for(int i = y - 1; i >= 0; i--) {
            if(cmap[x][i] == 6) break;
            if(cmap[x][i] == 0) {
                cmap[x][i] = 7;
            }
        }
    }

    static void right(int x, int y) {
        for(int i = y + 1; i < M; i++) {
            if(cmap[x][i] == 6) break;
            if(cmap[x][i] == 0) {
                cmap[x][i] = 7;
            }
        }
    }

    static class cctv {
        int x;
        int y;
        int num;
        int dir;
        cctv(int x, int y, int num, int dir) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
        }
    }
}
