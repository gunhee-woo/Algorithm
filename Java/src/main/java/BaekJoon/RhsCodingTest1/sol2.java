package BaekJoon.RhsCodingTest1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class sol2 {
    static int MAX = 101;
    static int N, M, R, count;
    static int[][] arr;
    static boolean[][] check;
    static int[] dix = {0, 0, 1, -1}; // 동서남북
    static int[] diy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[MAX][MAX];
        check = new boolean[MAX][MAX];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int k = 0; k < R; k++) {
            int ax, ay, dx, dy;
            String dir = "";
            st = new StringTokenizer(br.readLine());
            ax = Integer.parseInt(st.nextToken());
            ay = Integer.parseInt(st.nextToken());
            dir = st.nextToken();
            st = new StringTokenizer(br.readLine());
            dx = Integer.parseInt(st.nextToken());
            dy = Integer.parseInt(st.nextToken());
            attack(ax, ay, direction(dir));
            defence(dx, dy);
        }
        System.out.println(count);
        print();
    }

    static int direction(String s) {
        if(s.equals("E")) return 0;
        else if(s.equals("W")) return 1;
        else if(s.equals("S")) return 2;
        else return 3;
    }

    static void attack(int x, int y, int d) {
        if(check[x][y]) return;
        check[x][y] = true;
        count++;
        int val = arr[x][y] - 1;
        while(val > 0) {
            int nx = x + dix[d];
            int ny = y + diy[d];
            if(nx <= 0 || nx > N || ny <= 0 || ny > M) return;
            if(check[nx][ny]) { // 이미 쓰러져있다
                val--;
                x = nx;
                y = ny;
            } else { // 아직 안 쓰러져있으니까 쓰러뜨려야 함
                val--;
                check[nx][ny] = true;
                count++;
                x = nx;
                y = ny;
                val = Math.max(arr[nx][ny] - 1, val);
            }
        }
    }

//    static void attack(int x, int y, String dir) {
//        if(check[x][y]) return;
//        check[x][y] = true;
//        count++;
//        int val = arr[x][y] - 1;
//        if(dir.equals("E")) {
//            for(int i = y + 1; i <= y + val; i++) {
//                if(i > M) break;
//                attack(x, i, "E");
//            }
//        } else if(dir.equals("W")) {
//            for(int i = y - 1; i >= y - val; i--) {
//                if(i <= 0) break;
//                attack(x, i, "W");
//            }
//        } else if(dir.equals("S")) {
//            for(int i = x + 1; i <= x + val; i++) {
//                if(i > N) break;
//                attack(i, y, "S");
//            }
//        } else {
//            for(int i = x - 1; i >= x - val; i--) {
//                if(i <= 0) break;
//                attack(i, y, "N");
//            }
//        }
//    }

    static void defence(int x, int y) {
        if(!check[x][y]) return;
        check[x][y] = false;
    }

    static void print() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(check[i][j]) System.out.print("F");
                else System.out.print("S");
            }
            System.out.println();
        }
    }
}
