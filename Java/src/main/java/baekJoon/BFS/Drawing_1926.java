package baekJoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class Drawing_1926 {
    static int MAX = 501;
    static int[] ax = {-1,1,0,0};
    static int[] ay = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        final int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[MAX][MAX];
        boolean[][] check = new boolean[MAX][MAX];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                check[i][j] = false;
            }
        }
        int count = 0, max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 1 && !check[i][j]) {
                    count++;
                    Queue<Pair> q = new LinkedList<>();
                    int area = 1;
                    check[i][j] = true;
                    q.add(new Pair(i, j));
                    while(!q.isEmpty()) {
                        int cx = q.peek().x;
                        int cy = q.peek().y;
                        q.poll();
                        for(int k = 0; k < 4; k++) {
                            int nx = cx + ax[k];
                            int ny = cy + ay[k];
                            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if(arr[nx][ny] == 1 && !check[nx][ny]) {
                                check[nx][ny] = true;
                                area++;
                                q.add(new Pair(nx, ny));
                            }
                        }
                    }
                    max = Math.max(max, area);
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
        br.close();
    }
}

class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
