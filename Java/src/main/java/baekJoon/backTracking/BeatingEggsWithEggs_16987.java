package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// ����
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

    // k�� �տ� ��� �ִ� ��� �ε���
    private static void dfs(int k) {
        if(k >= N) {
            int cnt = 0;
            for(int i = 0; i < N; i++)  {
                if(arr[i].s <= 0) cnt++;
            }
            count = Math.max(count, cnt);
            return;
        }
        if(arr[k].s <= 0) dfs(k + 1); // k��° ����� ����
        else {
            boolean b = false;
            for(int i = 0; i < N; i++) {
                if(i != k && arr[i].s > 0) { // k�� �ƴϰ� ���� �ε������� ���� ����� ����
                    arr[k].s = arr[k].s - arr[i].w;
                    arr[i].s = arr[i].s - arr[k].w;
                    b = true;
                    dfs(k + 1);
                    arr[k].s = arr[k].s + arr[i].w;
                    arr[i].s = arr[i].s + arr[k].w;
                }
            }
            if(!b) dfs(N); // ��ü ����� �������Ƿ� N�� �Ѱܼ� ������ ��ħ
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
