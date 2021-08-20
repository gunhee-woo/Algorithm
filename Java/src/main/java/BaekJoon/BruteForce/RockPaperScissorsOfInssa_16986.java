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
    static List<Integer> pearls, pungs;
    static final int CHIM = 1, PEARL = 2, PUNG = 3;
    static int[] wins, chims;
    static boolean[] check;
    static boolean finish, answer;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        info = new int[N + 1][N + 1];
        pearls = new ArrayList<>();
        pungs = new ArrayList<>();
        wins = new int[4];
        chims = new int[N + 1];
        check = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.stream(info).forEach(it -> System.out.println(Arrays.toString(it)));
        pearls.add(0);
        pungs.add(0);
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(it -> pearls.add(it));
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(it -> pungs.add(it));
        dfs(1);
        if(answer) System.out.print(1);
        else System.out.print(0);
    }

    private static void dfs(int k) {
        if(answer) return;
        if(k == N + 1) {
            for(int i = 1; i <= N; i++) System.out.print(chims[i] + " ");
            System.out.println();
            answer = play(CHIM, PEARL, 1, 1, 1);
            return;
        }
        for(int i = 1; i <= N; i++) {
            if(answer) return;
            if(!check[i]) {
                check[i] = true;
                chims[k] = i;
                dfs(k + 1);
                check[i] = false;
            }
        }
    }

    private static boolean play(int p1, int p2, int chim_cnt, int pearl_cnt, int pung_cnt) {
        System.out.println("chimcnt : " + chim_cnt + ", pearlcnt : " + pearl_cnt + ", pungcnt : " + pung_cnt);
        System.out.println("chim : " + wins[CHIM] + ", pearl : " + wins[PEARL] + ", pung : " + wins[PUNG]);
        if(wins[CHIM] >= K) {
            finish = true;
            return true;
        }
        if(wins[PEARL] >= K || wins[PUNG] >= K || chim_cnt > N) return false;

        int next = 0;
        if((p1 == CHIM && p2 == PEARL) || (p1 == PEARL && p2 == CHIM)) next = PUNG;
        else if((p1 == CHIM && p2 == PUNG) || (p1 == PUNG && p2 == CHIM)) next = PEARL;
        else if((p1 == PEARL && p2 == PUNG) || (p1 == PUNG && p2 == PEARL)) next = CHIM;
        System.out.println("p1 : " + p1 + ", p2 : " + p2 + ", next : " + next);

        if(next == PUNG) { // 침펄대결
            int result = info[chims[chim_cnt]][pearls.get(pearl_cnt)];
            System.out.println("chims[chim_cnt] : " + chims[chim_cnt] + ", pearls.get(pearl_cnt) : " + pearls.get(pearl_cnt) + ", result : " + result);
            if(result == 0) { // 펄이 침을 이김
                wins[PEARL]++;
                play(PEARL, next, chim_cnt + 1, pearl_cnt + 1, pung_cnt);
                if(finish) return true;
                wins[PEARL]--;
            } else { // 침이 펄을 이김
                wins[CHIM]++;
                play(CHIM, next, chim_cnt + 1, pearl_cnt + 1, pung_cnt);
                if(finish) return true;
                wins[CHIM]--;
            }
        } else if(next == PEARL) { // 침풍대결
            int result = info[chims[chim_cnt]][pungs.get(pung_cnt)];
            System.out.println("chims[chim_cnt] : " + chims[chim_cnt] + ", pungs.get(pung_cnt) : " + pungs.get(pung_cnt) + ", result : " + result);
            if(result == 0) { // 풍이 침을 이김
                wins[PUNG]++;
                play(PUNG, next, chim_cnt + 1, pearl_cnt, pung_cnt + 1);
                if(finish) return true;
                wins[PUNG]--;
            } else { // 침이 풍을 이김
                wins[CHIM]++;
                play(CHIM, next, chim_cnt + 1, pearl_cnt, pung_cnt + 1);
                if(finish) return true;
                wins[CHIM]--;
            }
        } else if(p1 == PEARL && p2 == PUNG) { // 펄풍대결
            int result = info[pearls.get(pearl_cnt)][pungs.get(pung_cnt)];
            System.out.println("pearls.get(pearl_cnt) : " + pearls.get(pearl_cnt) + ", pungs.get(pung_cnt) : " + pungs.get(pung_cnt) + ", result : " + result);
            if(result == 0) { // 풍이 펄을 이김
                wins[PUNG]++;
                play(PUNG, next, chim_cnt, pearl_cnt + 1, pung_cnt + 1);
                if(finish) return true;
                wins[PUNG]--;
            } else {
                wins[PEARL]++;
                play(PEARL, next, chim_cnt, pearl_cnt + 1, pung_cnt + 1);
                if(finish) return true;
                wins[PEARL]--;
            }
        }
        return false;
    }
}
