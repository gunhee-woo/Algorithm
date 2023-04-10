package baekJoon.simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class ThrowStone_3025 {
    static int R, C, N;
    static char[][] map;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R + 1][C + 1];
        for(int i = 1; i <= R; i++) {
            String str = br.readLine();
           for(int j = 1; j <= C; j++) {
               map[i][j] = str.charAt(j - 1);
           }
        }
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());
            dfs(1, k);
//            print();
//            System.out.println();
        }
        print();
    }

    public static void print() {
        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int x, int y) {
        if(x == R) {
            map[x][y] = 'O';
            return;
        }
        int nx = x + 1;
        if(map[nx][y] == 'X') {
            map[x][y] = 'O';
            return;
        }
        if(map[nx][y] == 'O') { // 아래에 돌이 있을 경우
            if(y - 1 > 0 && map[x][y - 1] == '.' && map[nx][y - 1] == '.') { // 왼쪽이 비어있고 왼쪽아래도 비어있고
                dfs(x, y - 1); // 왼쪽으로 미끄러짐
            } else {
                if(y + 1 <= C && map[x][y + 1] == '.' && map[nx][y + 1] == '.') { // 오른쪽이 비어있고 오른쪽아래도 비어있고
                    dfs(x, y + 1); // 오른쪽으로 미끄러짐
                } else {
                    map[x][y] = 'O';
                }
            }
        } else { // 계속 아래로 내려감
            dfs(nx, y);
        }
    }
}
