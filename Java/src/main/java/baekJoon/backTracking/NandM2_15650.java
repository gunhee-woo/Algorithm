package baekJoon.backTracking;

import java.io.FileInputStream;
import java.util.Scanner;

import static Util.Constants.INPUT;

// 조합 (순서가 없고 중복 X)
// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
// 고른 수열은 오름차순이어야 한다.
public class NandM2_15650 {
    static int N, M;
    static int[] arr; // 출력할 수를 담는 자료구조
    static boolean[] check; // 해당 수를 사용했는지 체크
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        check = new boolean[N];
        dfs(0, 0); // 오름차순 정렬을 하기 위해 현재 수열에 저장된 값의 인덱스를 인자로 받아옴
    }

    public static void dfs(int k, int ix) {
        if(k == M) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++) {
                sb.append(arr[i] + 1).append(" ");
            }
            System.out.println(sb.toString());
            return;
        }
        for(int i = ix; i < N; i++) { // 받아온 인덱스 인자부터 N까지 탐색하도록 하여 오름차순으로 하도록 함
            if(!check[i]) {
                check[i] = true;
                arr[k] = i;
                dfs(k + 1, i);
                check[i] = false;
            }
        }
    }
}
