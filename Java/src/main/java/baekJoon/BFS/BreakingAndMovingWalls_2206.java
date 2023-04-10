package baekJoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class BreakingAndMovingWalls_2206 {
    static int N, M;
    static int MAX = 1005;
    static int[][] map;
    static boolean[][][] check; // 세번째 차원은 벽을 부수고 왔는지 체크 => 방문했더라도 벽을 부순 차이에 따라 경로가 달라지기 때문
    static int answer = 987654321;
    static int[] ax = {-1, 1, 0, 0};
    static int[] ay = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[MAX][MAX];
        check = new boolean[MAX][MAX][2];
        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            for(int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }
        Queue<point> q = new LinkedList<>();
        q.add(new point(1, 1, 1, 1));
        check[1][1][1] = true;
        while(!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.peek().y;
            int cbw = q.peek().bw;
            int cc = q.peek().count;
            System.out.println("cx : " + cx + ", cy : " + cy + ", cbw : " + cbw + ", cc : " + cc);
            if(cx == N && cy == M) {
                answer = Math.min(answer, cc);
            }
            q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cx + ax[i];
                int ny = cy + ay[i];
                if(nx < 1 || nx > N || ny < 1 || ny > M) continue;
                if(!check[nx][ny][cbw]) {
                    if(map[nx][ny] == 1) {
                        if(cbw == 1) {
                            check[nx][ny][cbw - 1] = true;
                            q.add(new point(nx, ny, 0, cc + 1));
                        }
                    } else {
                        check[nx][ny][cbw] = true;
                        q.add(new point(nx, ny, cbw, cc + 1));
                    }
                }
            }
        }
        if(answer == 987654321) System.out.print(-1);
        else System.out.print(answer);
    }

    private static void print() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static class point {
        int x;
        int y;
        int bw; //  1이면 벽을 부술 수 있는 기회가 남아 있다 0이면 더이상 부수지 못한다
        int count;
        public point(int x, int y, int bw, int count) {
            this.x = x;
            this.y = y;
            this.bw = bw;
            this.count = count;
        }
    }
}
