package baekJoon.simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

public class Mineral_2933 {
    static int R, C, N;
    static String[][] map;
    static int[] ax = {-1, 1, 0, 0};
    static int[] ay = {0, 0, -1, 1};
    static List<Integer> list;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new String[R][C];
        for(int i = 0; i < R; i++) {
            String[] str = br.readLine().split("");
            for(int j = 0; j < C; j++) {
                map[i][j] = str[j];
            }
        }
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        for(int ix = 0; ix < list.size(); ix++) {
            int h = R - list.get(ix);
            if(ix % 2 == 0) { // 왼쪽부터
                for(int i = 0; i < C; i++) {
                    if(map[h][i].equals("x")) {
                        map[h][i] = ".";
                        for(int j = 0; j < 4; j++) {
                            int nx = h + ax[j];
                            int ny = i + ay[j];
                            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                            if(map[nx][ny].equals("x")) {
                                if(!bfs(nx, ny)) { //  땅에 도달하지 못함 => 즉, 분리된 클러스터 이므로 땅으로 떨어져야 함
                                    fallCluster(nx, ny);
                                }
                            }
                        }
                        break;
                    }
                }
            } else { // 오른쪽부터
                for(int i = C - 1; i >= 0; i--) {
                    if(map[h][i].equals("x")) {
                        map[h][i] = ".";
                        for(int j = 0; j < 4; j++) {
                            int nx = h + ax[j];
                            int ny = i + ay[j];
                            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                            if(map[nx][ny].equals("x")) {
                                if(!bfs(nx, ny)) { //  땅에 도달하지 못함 => 즉, 분리된 클러스터 이므로 땅으로 떨어져야 함
                                    fallCluster(nx, ny);
                                }
                            }
                        }
                        break;
                    }
                }
            }
            print();
        }
    }

    private static void fallCluster(int x, int y) {
        List<Point> points = new ArrayList<>();
        boolean[][] check = new boolean[R][C];
        for(int i = 0; i < R; i++) {
            Arrays.fill(check[i], false);
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        check[x][y] = true;
        while(!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.peek().y;
            points.add(new Point(cx, cy));
            q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cx + ax[i];
                int ny = cy + ay[i];
                if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if(map[nx][ny].equals("x") && !check[nx][ny]) {
                    check[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
        }
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.y == o2.y) {
                    return o2.x - o1.x;
                } else return o1.y - o2.y;
            }
        });
        int dy = -1;
        int dist = 101;
        for(int i = 0; i < points.size(); i++) {
            int nx = points.get(i).x;
            int ny = points.get(i).y;
            System.out.println(nx + " " + ny + " " + dy);
            if(dy != ny) {
                dy = ny;
                int cnt = 0;
                while(true) {
                    System.out.println(cnt + " " + nx);
                    if(nx >= R) {
                        dist = Math.min(dist, cnt);
                        break;
                    }
                    if(map[nx][ny].equals("x")) {
                        dist = Math.min(dist, cnt);
                        break;
                    }
                    nx++;
                    cnt++;
                }
            }
        }
        System.out.println(dist);
        System.out.println();
    }

    private static boolean bfs(int x, int y) {
        boolean[][] check = new boolean[R][C];
        for(int i = 0; i < R; i++) {
            Arrays.fill(check[i], false);
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        check[x][y] = true;
        while(!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.peek().y;
            q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cx + ax[i];
                int ny = cy + ay[i];
                if(nx < 0 || ny < 0 || ny >= C) continue;
                if(nx >= R) { // 땅에 도달함
                    return true;
                }
                if(map[nx][ny].equals("x") && !check[nx][ny]) {
                    check[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
        }
        return false;
    }

    private static void fallDown(Point p) {
        int nx = p.x;
        int ny = p.y;
        map[nx][ny] = ".";
        while(true) {
            if(nx >= R) {
                map[nx - 1][ny] = "x";
                break;
            }
            if(map[nx][ny].equals("x")) {
                map[nx - 1][ny] = "x";
                break;
            }
            nx++;
        }
    }

    private static class Point {
        int x; int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void print() {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
