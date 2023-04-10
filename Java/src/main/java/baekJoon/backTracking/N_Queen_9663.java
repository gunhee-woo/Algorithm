package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

// 백트래킹 문제
// 문제를 보고 시간복잡도가 가늠이 잘 안가는데 N의 크기는 매우 작아 백트래킹으로 풀 수 있을 것 같다면
// 직접 구현 후 시간이 오래걸릴만한 케이스를 직접 돌려봐 시간초과가 나는지 체크
// 시간이 애매하면 최대한 최적화할 것
// 또한 시간을 측정할 때에는 반드리 Release 모드로 실행을 해야 함
// Release 모드는 디버깅 정보를 삽입하지 않아 코드를 최적화함 속도나 크기면에서 유리

// *** 퀸은 각 행마다 하나씩만 놓을 수 있음 ***
public class N_Queen_9663 {
    static int N;
    static boolean[] check1; // 열에 퀸이 있는지 체크
    static boolean[] check2; // 좌측 하단부터 우측 상단까지의 대각선에 퀸이 있는지 체크
    static boolean[] check3; // 좌측 상단부터 우측 하단까지의 대각선에 퀸이 있는지 체크
    static int cnt;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        check1 = new boolean[N];
        check2 = new boolean[N * 2 - 1];
        check3 = new boolean[N * 2 - 1];
        dfs(0);
        System.out.print(cnt);
    }

    // 퀸이 각 행(k)에 놓여져 있는지를 재귀를 통해 체크
    private static void dfs(int k) { // K는 행, k번째 행에 퀸을 놓을것이다
        if(k == N) { // 가장 밑부분까지 도착했다면 퀸을 전부 놓는데 성공했다는 것 => cnt++
            cnt++;
            return;
        }
        for(int i = 0; i < N; i++) { // i는 열
            if(!check1[i] && !check2[k + i] && !check3[k - i + N - 1]) { // 퀸을 놓을 수 있는지 체크
                check1[i] = true;
                check2[k + i] = true;
                check3[k - i + N - 1] = true;
                dfs(k + 1); // 다음 행으로 넘어감
                check1[i] = false;
                check2[k + i] = false;
                check3[k - i + N - 1] = false;
            }
        }
    }
}
