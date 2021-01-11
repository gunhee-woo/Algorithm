package BaekJoon.BFS;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class Tomato_7569 {
    static int MAX = 101;
    static int ax[] = {-1, 1, 0, 0, 0, 0};
    static int ay[] = {0, 0, -1, 1, 0, 0};
    static int az[] = {0, 0, 0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int M = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());
        final int H = Integer.parseInt(st.nextToken());
        int[][][] arr = new int[MAX][MAX][MAX];
        boolean[][][] check = new boolean[MAX][MAX][MAX];
        Queue<triple> q = new LinkedList<>();
        int ch = 0;
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++) {
                    check[j][k][i] = false;
                    int t = Integer.parseInt(st.nextToken());
                    arr[j][k][i] = t;
                    if(t == 1) {
                        q.add(new triple(j, k, i, 0));
                        check[j][k][i] = true;
                    }
                    if(t == 0) ch++;
                }
            }
        }
        int result = 0;
        while(!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.peek().y;
            int cz = q.peek().z;
            int cc = q.peek().count;
            result = Math.max(result, cc);
            q.poll();
            for(int i = 0; i < 6 ; i++){
                int nx = cx + ax[i];
                int ny = cy + ay[i];
                int nz = cz + az[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) continue;
                if(arr[nx][ny][nz] == 0 && !check[nx][ny][nz]) {
                    check[nx][ny][nz] = true;
                    arr[nx][ny][nz] = 1;
                    ch--;
                    q.add(new triple(nx, ny, nz, cc + 1));
                }
            }
        }
        if(ch != 0) System.out.println(-1);
        else System.out.println(result);
    }

    static class triple {
        int x, y, z, count;
        triple(int x, int y, int z, int count) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }
    }
}
