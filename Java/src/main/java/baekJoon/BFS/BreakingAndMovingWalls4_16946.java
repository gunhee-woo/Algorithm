package baekJoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

public class BreakingAndMovingWalls4_16946 {
    static int N, M;
    static int[][] map, cmap, answer;
    static boolean[][] check;
    static int[] ax = {-1, 1, 0, 0};
    static int[] ay = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cmap = new int[N][M];
        answer = new int[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
                answer[i][j] = str.charAt(j) - '0';
            }
        }
        check = new boolean[N][M];
        int cnt = 1;
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0 && !check[i][j]) {
                    Queue<Point> q = new LinkedList<>();
                    int size = 0;
                    q.add(new Point(i, j));
                    check[i][j] = true;
                    while(!q.isEmpty()) {
                        int cx = q.peek().x;
                        int cy = q.peek().y;
                        cmap[cx][cy] = cnt;
                        size++;
                        q.poll();
                        for(int k = 0; k < 4; k++) {
                            int nx = cx + ax[k];
                            int ny = cy + ay[k];
                            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                            if(!check[nx][ny] && map[nx][ny] == 0) {
                                check[nx][ny] = true;
                                q.add(new Point(nx, ny));
                            }
                        }
                    }
                    arr.add(size);
                    cnt++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1) {
                    boolean[] visit = new boolean[arr.size()];
                    int count = 1;
                    for(int k = 0; k < 4; k++) {
                        int nx = i + ax[k];
                        int ny = j + ay[k];
                        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                        if(map[nx][ny] == 0) {
                            int num = cmap[nx][ny] - 1;
                            if(!visit[num]) {
                                visit[num] = true;
                                count += arr.get(num);
                            }
                        }
                    }
                    sb.append(count % 10);
                }
                else sb.append("0");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
    // 시간초과 코드
//    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream(INPUT));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        map = new int[N][M];
//        answer = new int[N][M];
//        List<Point> list = new ArrayList<>();
//        for(int i = 0; i < N; i++) {
//            String str = br.readLine();
//            for(int j = 0; j < M; j++) {
//                map[i][j] = str.charAt(j) - '0';
//                answer[i][j] = str.charAt(j) - '0';
//                if(map[i][j] == 1) list.add(new Point(i, j));
//            }
//        }
//        for(Point p : list) {
//            int cnt = 0;
//            check = new boolean[N][M];
//            Queue<Point> q = new LinkedList<>();
//            q.add(p);
//            check[p.x][p.y] = true;
//            while(!q.isEmpty()) {
//                cnt++;
//                int cx = q.peek().x;
//                int cy = q.peek().y;
//                q.poll();
//                for(int i = 0; i < 4; i++) {
//                    int nx = cx + ax[i];
//                    int ny = cy + ay[i];
//                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
//                    if(!check[nx][ny] && map[nx][ny] == 0) {
//                        check[nx][ny] = true;
//                        q.add(new Point(nx, ny));
//                    }
//                }
//            }
//            answer[p.x][p.y] = cnt;
//        }
//        print();
//    }

    private static void print() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(answer[i][j] % 10  + " ");
            }
            System.out.println();
        }
    }

    private static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
