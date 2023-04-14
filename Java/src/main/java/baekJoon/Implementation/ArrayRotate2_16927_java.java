package baekJoon.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class ArrayRotate2_16927_java {
    static int n, m, r;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int stand = Math.min(n, m);
        int width = m;
        int height = n;
        for(int k = 0; k < stand / 2; k++) {
            int total = height * 2 + (width - 2) * 2;
            int rc = r % total;
            while(rc-- > 0) {
                int pre = map[k][m - 1 - k];
                for(int i = m - 2 - k; i >= k; i--) {
                    int temp = map[k][i];
                    map[k][i] = pre;
                    pre = temp;
                }
                for(int i = k + 1; i < n - k; i++) {
                    int temp = map[i][k];
                    map[i][k] = pre;
                    pre = temp;
                }
                for(int i = 1 + k; i < m - k; i++) {
                    int temp = map[n - 1 - k][i];
                    map[n - 1 - k][i] = pre;
                    pre = temp;
                }
                for(int i = n - 2 - k; i >= k; i--) {
                    int temp = map[i][m - 1 - k];
                    map[i][m - 1 - k] = pre;
                    pre = temp;
                }
            }
            height -= 2;
            width -= 2;
        }
        printMap();
    }

    public static void printMap() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
