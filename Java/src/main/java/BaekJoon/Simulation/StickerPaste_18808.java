package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class StickerPaste_18808 {
    static int MAX = 41;
    static int N, M, K, R, C;
    static int[][] map, stk;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[MAX][MAX];
        while(K-- > 0) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            stk = new int[12][12];
            for(int i = 0; i < R; i++) {
                int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for(int j = 0; j < C; j++) {
                    stk[i][j] = s[j];
                }
            }
            for(int k = 0; k < 4; k++) {
                boolean b = false;
                for (int i = 0; i <= N - R; i++) {
                    if (b) break;
                    for (int j = 0; j <= M - C; j++) {
                        if (isPaste(i, j)) {
                            paste(i, j);
                            b = true;
                            break;
                        }
                    }
                }
                if (b) break;
                rotate();
            }
        }
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1) cnt++;
            }
        }
        System.out.print(cnt);
    }

    static void paste(int x, int y) {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(stk[i][j] == 1)
                    map[i + x][j + y] = 1;
            }
        }
    }

    static boolean isPaste(int x, int y) { // 스티커를 붙일 시작점을 인자로 받아 붙일 수 있는지 없는지 판단
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[x + i][y + j] == 1 && stk[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static void rotate() { // 90도 회전하는 함수
        int[][] temp = new int[12][12];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                temp[i][j] = stk[i][j];
            }
        }
        for(int i = 0; i < C; i++) {
            for(int j = 0; j < R; j++) {
                stk[i][j] = temp[(R - 1 - j)][i];
            }
        }
        int t = R;
        R = C;
        C = t;
    }
}