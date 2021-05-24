package BaekJoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

public class HosukInStringHell_20166 {
    static int[] ax = {0, -1, 1, 0, 0, -1, -1, 1, 1};
    static int[] ay = {0, 0, 0, -1, 1, -1, 1, 1, -1};
    static int N, M, K;
    static char[][] map;
    static Map<String, Integer> mp;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N + 1][M + 1];
        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            for(int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }
        mp = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < K; i++) {
            String str = br.readLine();
            mp.put(str, 0);
            list.add(str);
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                dfs(i, j, String.valueOf(map[i][j]));
            }
        }
        for(String str : list) {
            System.out.println(mp.get(str));
        }
    }

    public static void dfs(int x, int y, String str) {
        if(str.length() == K) {
            if(mp.containsKey(str)) {
                mp.put(str, mp.get(str) + 1);
            }
            return;
        }
        for(int i = 1; i <= 8; i++) {
            int nx = x + ax[i];
            int ny = y + ay[i];
            if(nx <= 0) nx = N;
            if(nx > N) nx = 1;
            if(ny <= 0) ny = M;
            if(ny > M) ny = 1;
            dfs(nx, ny, str + map[nx][ny]);
        }
    }
}
