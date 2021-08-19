package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class RockPaperScissorsOfInssa_16986 {
    static int N, K;
    static int[][] info;
    static List<Integer> perls, pungs;
    static int[] order;
    static final int chim = 1, perl = 2, pung = 3;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        info = new int[N + 1][N + 1];
        perls = new ArrayList<>();
        pungs = new ArrayList<>();
        order = new int[N + 1];
        for(int i = 1; i <= N; i++) order[i] = i;
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(it -> perls.add(it));
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(it -> pungs.add(it));
        for(int i = 1; i <= N; i++) {

        }
    }

    private static void dfs(int k) {

    }
}
