package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// 순열
public class BeatingEggsWithEggs_16987 {
    static int N;
    static egg[] arr;
    static int count = 0;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new egg[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        dfs(0);
        System.out.print(count);
    }

    // k는 손에 쥐고 있는 계란 인덱스
    private static void dfs(int k) {
        if(k >= N) {
            int cnt = 0;
            for(int i = 0; i < N; i++)  {
                if(arr[i].s <= 0) cnt++;
            }
            count = Math.max(count, cnt);
            return;
        }
        if(arr[k].s <= 0) dfs(k + 1); // k번째 계란이 깨짐
        else {
            boolean b = false;
            for(int i = 0; i < N; i++) {
                if(i != k && arr[i].s > 0) { // k가 아니고 아직 부딪혀보지 않은 계란이 존재
                    arr[k].s = arr[k].s - arr[i].w;
                    arr[i].s = arr[i].s - arr[k].w;
                    b = true;
                    dfs(k + 1);
                    arr[k].s = arr[k].s + arr[i].w;
                    arr[i].s = arr[i].s + arr[k].w;
                }
            }
            if(!b) dfs(N); // 전체 계란이 깨졌으므로 N을 넘겨서 연산을 마침
        }
    }

    static class egg {
        int s;
        int w;
        egg(int s, int w) {
            this.s = s;
            this.w = w;
        }
    }
}
