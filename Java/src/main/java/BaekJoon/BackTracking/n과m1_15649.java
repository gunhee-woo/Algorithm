package BaekJoon.BackTracking;

import java.io.FileInputStream;
import java.util.Scanner;

import static Util.Constants.INPUT;

// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
public class n과m1_15649 {
    static int N, M;
    static int[] arr; // 수열을 담는 자료구조 => 크기를 N에 맞춤
    static boolean[] check; // 해당 수를 이전에 사용했는지 체크 => 크기를 M에 맞춤 => 문제에 중복없이라는 조건이 있으므로
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        check = new boolean[N]; // true면 해당 숫자를 사용했다 false면 사용하지 않았다
        dfs(0);
    }

    // k는 arr의 길이, 현재 arr을 넣어야하는 위치 인덱스
    public static void dfs(int k) {
        if(k == M) { // arr이 꽉찼다면
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++)
                sb.append(arr[i] + 1).append(" "); // 0부터 m-1까지가 아니라  1부터 m까지 이므로 1을 더함
            System.out.println(sb.toString());
            return;
        }
        for(int i = 0; i < N; i++) { // 1부터 N까지의 수에 대해
            if(!check[i]) { // i가 아직 사용하지 않았다면
                arr[k] = i;
                check[i] = true;
                dfs(k + 1); // 다음 수를 정하러 들어감
                check[i] = false; // k번째 수를 i로 정한 모든 경우에 대해 확인했으니 i를 사용하지 않았다고 명시
            }
        }
    }
}
