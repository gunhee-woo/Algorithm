package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

// 전형적인 브루트 포스를 백트래킹으로 푸는 문제
// 주어진 M개 까지의 치킨집을 백트래킹으로 뽑아서 최소 거리를 계산
public class ChickenDelivery_15686 {
    static int N, M;
    static int[][] map;
    static int answer = 987654321;
    static List<point> home, chicken;
    static boolean[] check;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) home.add(new point(i, j));
                if(map[i][j] == 2) chicken.add(new point(i, j));
            }
        }
        for(int i = 1; i <= M; i++) {
            arr = new int[i];
            check = new boolean[chicken.size()];
            dfs(0, 0, i);
        }
        System.out.print(answer);
    }

    static void dfs(int k, int ix, int n) {
        if(k == n) {
            cal(arr);
            return;
        }
        for(int i = ix; i < chicken.size(); i++) {
            if(!check[i]) {
                check[i] = true;
                arr[k] = i;
                dfs(k + 1, i, n);
                check[i] = false;
            }
        }
    }

    static void cal(int[] arr) {
        List<Integer> ckDist = new ArrayList<>();
        for(int i = 0; i < home.size(); i++) {
            int minDist = 987654321;
            for(int j = 0; j < arr.length; j++) {
                point ck = chicken.get(arr[j]);
                int dist = Math.abs(ck.x - home.get(i).x) + Math.abs(ck.y - home.get(i).y);
                minDist = Math.min(minDist, dist);
            }
            ckDist.add(minDist);
        }
        int result = ckDist.stream().reduce(Integer::sum).get();
        answer = Math.min(answer, result);
    }

    private static class point {
        int x;
        int y;
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
