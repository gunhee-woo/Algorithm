package baekJoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class Fire_4179 {
    static int MAX = 1001;
    static int[] ax = {-1,1,0,0};
    static int[] ay = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int R = Integer.parseInt(st.nextToken());
        final int C = Integer.parseInt(st.nextToken());
        String[] strings = new String[MAX];
        int[][] arr1 = new int [MAX][MAX];
        int[][] arr2 = new int [MAX][MAX];
        Queue<pair> fq = new LinkedList<>();
        Queue<pair> jq = new LinkedList<>();
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            strings[i] = str;
            for(int j = 0; j < C; j++) {
                char c = str.charAt(j);
                arr1[i][j] = -1;
                arr2[i][j] = -1;
                if(c == 'F') {
                    fq.add(new pair(i, j));
                    arr1[i][j] = 0;
                }
                if(c == 'J') {
                    jq.add(new pair(i, j));
                    arr2[i][j] = 0;
                }
            }
        }
        while(!fq.isEmpty()) {
            int cx = fq.peek().x;
            int cy = fq.peek().y;
            int num = arr1[cx][cy];
            fq.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cx + ax[i];
                int ny = cy + ay[i];
                if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if(arr1[nx][ny] >= 0 || strings[nx].charAt(ny) == '#') continue;
                arr1[nx][ny] = num + 1;
                fq.add(new pair(nx, ny));
            }
        }
        while(!jq.isEmpty()) {
            int cx = jq.peek().x;
            int cy = jq.peek().y;
            int num = arr2[cx][cy];
            jq.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cx + ax[i];
                int ny = cy + ay[i];
                if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    System.out.println(num + 1);
                    return;
                }
                if(arr2[nx][ny] >= 0 || strings[nx].charAt(ny) == '#') continue;
                if(arr1[nx][ny] != -1 && arr1[nx][ny] <= num + 1) continue;
                arr2[nx][ny] = num + 1;
                jq.add(new pair(nx, ny));
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    static class pair {
        int x, y;
        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
