package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class EnergyCollect_16198 {
    static int N;
    static int[] arr;
    static boolean[] check;
    static int max = 0;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        check = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, arr, check);
        System.out.print(max);
    }

    static void dfs(int sum, int[] a, boolean[] chk) {
        if(a.length == 2) {
            max = Math.max(max, sum);
            return;
        }
        for(int i = 1; i < a.length - 1; i++) {
            if(!chk[i]) {
                chk[i] = true; // 에너지 구슬 제거
                int[] temp = new int[a.length - 1];
                boolean[] tmpCheck = new boolean[chk.length - 1];
                int ix = 0;
                for (int j = 0; j < a.length; j++) {
                    if (!chk[j]) {
                        tmpCheck[ix] = chk[j];
                        temp[ix++] = a[j];
                    }
                }
                dfs(sum + (a[i - 1] * a[i + 1]), temp, tmpCheck);
                chk[i] = false;
            }
        }
    }
}
