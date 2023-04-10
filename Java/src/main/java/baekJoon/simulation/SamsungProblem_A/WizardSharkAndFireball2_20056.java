package baekJoon.simulation.SamsungProblem_A;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

public class WizardSharkAndFireball2_20056 {
    static int N, M, K;
    static List<FireBall>[][] map;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new List[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[r][c].add(new FireBall(m, s, d));
        }
        while(K-- > 0) {
            move();
            operate();
        }
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(!map[i][j].isEmpty()) {
                    for(FireBall fireBall : map[i][j]) {
                        answer += fireBall.m;
                    }
                }
            }
        }
        System.out.print(answer);
    }

    private static void move() {
        List<FireBall>[][] cmap = new List[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                cmap[i][j] = new ArrayList<>();
            }
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(!map[i][j].isEmpty()) {
                    for(FireBall f : map[i][j]) {
                        int nx = i + (dx[f.d] * (f.s % N));
                        int ny = j + (dy[f.d] * (f.s % N));
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
                        FireBall fireBall = new FireBall(f.m, f.s, f.d);
                        cmap[nx][ny].add(fireBall);
                    }
                }
            }
        }
        map = cmap;
    }

    private static void operate() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(map[i][j].size() > 1) {
                    int sm = 0; int ss = 0; int sz = map[i][j].size(); int sd1 = 0; int sd2 = 0;
                    for(FireBall f : map[i][j]) {
                        sm += f.m;
                        ss += f.s;
                        if(f.d % 2 == 0) sd2++;
                        else sd1++;
                    }
                    map[i][j].clear();
                    if(sm / 5 != 0) {
                        if(sd2 == 0 || sd1 == 0) {
                            for(int k = 0; k < 4; k++) {
                                map[i][j].add(new FireBall(sm / 5, ss / sz , k * 2));
                            }
                        } else {
                            for(int k = 0; k < 4; k++) {
                                map[i][j].add(new FireBall(sm / 5, ss / sz , k * 2 + 1));
                            }
                        }
                    }
                }
            }
        }
    }

    private static class FireBall {
        int m; int s; int d;
        FireBall(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}
