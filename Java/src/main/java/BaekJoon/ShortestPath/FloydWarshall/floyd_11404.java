package BaekJoon.ShortestPath.FloydWarshall;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import static Util.Constants.INPUT;

// 플로이드 와샬 알고리즘
// 모든 정점에서 모든 정점으로의 최단경로를 구할때 사용, 거쳐가는 정점을 기준으로 함
// 기준점 k를 두고 i에서 j까지 가는 거리와 i에서 k까지 갔다가 k에서 j까지 가는 거리를 비교하여 최소값을 최단거리로 저장
// 다익스트라 알고리즘은 가장 적은 비용을 하나씩 선택한다면 플로이드 와샬은 거쳐가는 정점을 기준으로 수행
// 기본적으로 다이나믹 프로그래밍을 사용
// 정점의 개수 V만큼 반복문이 3중으로 수행하므로 시간복잡도는 O(V^3), 그리고 간선들의 정보를 V * V 크기 인접행렬에 담았으므로 공간복잡도는 O(V^2)
public class floyd_11404 {
    static int INF = 1000000000;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] d = new int[N + 1][N + 1]; // 비용을 저장하는 배열
        for(int i = 1; i <= N; i++) {
            Arrays.fill(d[i], INF); // 무한대로 초기화
            d[i][i] = 0; // A에서 A로 가는 비용은 당연히 0
        }

        for(int i = 0; i < M; i++) {
            int[] str = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            d[str[0]][str[1]] = Math.min(d[str[0]][str[1]], str[2]); // 같은 경로의 입력이 주어질 수 있으므로
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(d[i][j] >= INF) sb.append("0 "); // 끝까지 접근할 수 없는 도시가 존재할 때 0으로 출력하도록 함
                else sb.append(d[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
