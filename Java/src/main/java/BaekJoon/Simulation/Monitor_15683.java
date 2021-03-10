package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class Monitor_15683 {
    static int MAX = 9;
    static int N, M;
    static int[][] map;
    static List<pair> list;
    static int count = 0; // map에 존재하는 0의 개수
    static int result = 987654321;
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
                if(map[i][j] != 0 && map[i][j] != 6) list.add(new pair(i, j));
                if(map[i][j] == 0) count++;
            }
        }
        dfs(0, 0);
        System.out.print(result);
    }

    static void dfs(int k, int cnt) {
        if(k == list.size()) {
            result = Math.min(result, count - cnt);
            return;
        }

        int[][] map2 = map;

        for(int i = k; i < list.size(); i++) {
            int ax = list.get(i).x;
            int ay = list.get(i).y;
            if(map[ax][ay] == 1) {
                for(int j = 0; j < 4; j++) {
                    if(j == 0) dfs(k + 1, cnt + left(ax, ay));
                    if(j == 1) dfs(k + 1, cnt + right(ax, ay));
                    if(j == 2) dfs(k + 1, cnt + up(ax, ay));
                    if(j == 3) dfs(k + 1, cnt + down(ax, ay));
                }
            } else if(map[ax][ay] == 2) {
                for(int j = 0; j < 2; j++) {
                    if(j == 0) dfs(k + 1, cnt + left(ax, ay) + right(ax, ay));
                    if(j == 1) dfs(k + 1, cnt + up(ax, ay) + down(ax, ay));
                }
            } else if(map[ax][ay] == 3) {
                for(int j = 0; j < 4; j++) {
                    if(j == 0) dfs(k + 1, cnt + up(ax, ay) + right(ax, ay));
                    if(j == 1) dfs(k + 1, cnt + right(ax, ay) + down(ax, ay));
                    if(j == 2) dfs(k + 1, cnt + left(ax, ay) + down(ax, ay));
                    if(j == 3) dfs(k + 1, cnt + up(ax, ay) + left(ax, ay));
                }
            } else if(map[ax][ay] == 4) {
                for(int j = 0; j < 4; j++) {
                    if(j == 0) dfs(k + 1, cnt + up(ax, ay) + right(ax, ay) + left(ax, ay));
                    if(j == 1) dfs(k + 1, cnt + up(ax, ay) + right(ax, ay) + down(ax, ay));
                    if(j == 2) dfs(k + 1, cnt + right(ax, ay) + left(ax, ay) + down(ax, ay));
                    if(j == 3) dfs(k + 1, cnt + down(ax, ay) + up(ax, ay) + left(ax, ay));
                }
            } else if(map[ax][ay] == 5) {
                dfs(k + 1, cnt + up(ax, ay) + right(ax, ay) + left(ax, ay) + down(ax, ay));
            }
        }
    }

    static void mapCopy() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {

            }
        }
    }

    static int left(int x, int y) {
        int cnt = 0;
        for(int i = x - 1; i >= 0; i--) {
            if(map[i][y] == 6) break;
            if(map[i][y] == 0) {
                map[i][y] = 7;
                cnt++;
            }
        }
        return cnt;
    }

    static int right(int x, int y) {
        int cnt = 0;
        for(int i = x + 1; i < M; i++) {
            if(map[i][y] == 6) break;
            if(map[i][y] == 0) {
                map[i][y] = 7;
                cnt++;
            }
        }
        return cnt;
    }

    static int up(int x, int y) {
        int cnt = 0;
        for(int i = y - 1; i >= 0; i--) {
            if(map[x][i] == 6) break;
            if(map[x][i] == 0) {
                map[x][i] = 7;
                cnt++;
            }
        }
        return cnt;
    }

    static int down(int x, int y) {
        int cnt = 0;
        for(int i = y + 1; i < N; i++) {
            if (map[x][i] == 6) break;
            if(map[x][i] == 0) {
                map[x][i] = 7;
                cnt++;
            }
        }
        return cnt;
    }

    static class pair {
        int x;
        int y;
        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
