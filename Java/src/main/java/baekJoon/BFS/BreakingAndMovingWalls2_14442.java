package baekJoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class BreakingAndMovingWalls2_14442 {
    static int N, M, K;
    static int[][] map;
    static boolean[][][] check;
    static int[] ax = {-1, 1, 0, 0};
    static int[] ay = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        check = new boolean[N + 1][M + 1][K + 1];
        map = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            for(int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1, K, 1));
        check[1][1][K] = true;
        int answer = 987654321;
        while(!q.isEmpty()) {
            Point cp = q.peek();
            if(cp.x == N && cp.y == M) {
                answer = Math.min(answer, cp.cnt);
            }
            q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cp.x + ax[i];
                int ny = cp.y + ay[i];
                if(nx <= 0 || nx > N || ny <= 0 || ny > M) continue;
                if(!check[nx][ny][cp.bw]) {
                    if(map[nx][ny] == 1) {
                        if(cp.bw > 0 && !check[nx][ny][cp.bw - 1]) { // 다음으로 이동할 좌표의 벽 상태에 따라 방문한적이 있는지 체크
                            check[nx][ny][cp.bw - 1] = true;
                            q.add(new Point(nx, ny, cp.bw - 1, cp.cnt + 1));
                        }

                    } else {
                        check[nx][ny][cp.bw] = true;
                        q.add(new Point(nx, ny, cp.bw, cp.cnt + 1));
                    }
                }
            }
        }
        if(answer == 987654321) System.out.print(-1);
        else System.out.print(answer);
    }

    public static class Point {
        int x; int y; int bw; int cnt;
        public Point(int x, int y, int bw, int cnt) {
            this.x = x;
            this.y = y;
            this.bw = bw;
            this.cnt = cnt;
        }
    }
}
