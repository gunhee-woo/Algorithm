package BaekJoon.Simulation.SamsungProblem_A;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class JuvenileShark_19236 {
    static int[][] map;
    static int[] ax = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] ay = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static Fish sk;
    static Map<Integer, Fish> mp;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[4][4];
        mp  = new HashMap<>();
        for(int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                mp.put(a, new Fish(i, j, b));
            }
        }
        sk = new Fish(0, 0, mp.get(map[0][0]).dir);
        mp.put(map[0][0], new Fish(0, 0, 0));
        map[0][0] = 0;
        while(true) {
            moveFish();
            int nx = sk.x + ax[sk.dir];
            int ny = sk.y + ay[sk.dir];
            if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || map[nx][ny] == 0) continue;


        }
//        print();
    }

    private static void dfs(int sum) {

    }

    private static void moveFish() {
        for(int i = 1; i < 16; i++) {
            Fish cf = mp.get(i);
            if(map[cf.x][cf.y] == 0) continue;
            int nx = cf.x + ax[cf.dir];
            int ny = cf.y + ay[cf.dir];
            int nd = cf.dir;
            while(nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || (nx == sk.x && ny == sk.y)) { // 이동할 수 없으면 45도 각도로 회전
                nd++;
                if(nd == 9) nd = 1;
                if(nd == cf.dir) { // 이동 못함
                    return;
                }
                nx = cf.x + ax[nd];
                ny = cf.y + ay[nd];
            }
            mp.put(map[cf.x][cf.y], new Fish(nx, ny, cf.dir)); // Map 안에 있는 현재 번호의 x, y값 업데이트
            mp.put(map[nx][ny], new Fish(cf.x, cf.y, mp.get(map[nx][ny]).dir));
            int temp = map[cf.x][cf.y]; // 지도상의 번호 위치 스위칭
            map[cf.x][cf.y] = map[nx][ny];
            map[nx][ny] = temp;
            print();
            System.out.println(i + "---");
        }
    }

    private static void print() {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static class Fish {
        int x; int y; int dir;

        public Fish(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
