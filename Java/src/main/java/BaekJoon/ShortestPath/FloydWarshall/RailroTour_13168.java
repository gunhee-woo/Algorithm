package BaekJoon.ShortestPath.FloydWarshall;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

// N이 100 밖에 안되는 작은 수이므로 플로이드 와샬 알고리즘 적용가능

public class RailroTour_13168 {
    static Set<String> railro1 = new HashSet<>(Arrays.asList("ITX-Saemaeul", "ITX-Cheongchun", "Mugunghwa"));
    static Set<String> railro2 = new HashSet<>(Arrays.asList("V-Train", "S-Train"));
    static double INF = 1000000001.0;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        double R = Double.parseDouble(st.nextToken()); // 내일로 가격
        st = new StringTokenizer(br.readLine());
        Map<String, Integer> city = new HashMap<>();
        for(int i = 0; i < N; i++) {
            city.put(st.nextToken(), i);
        }
        int M = Integer.parseInt(br.readLine());
        String[] tour = new String[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) tour[i] = st.nextToken();
        double[][] railRo = new double[N][N];
        double[][] normal = new double[N][N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(railRo[i], INF);
            railRo[i][i] = 0.0;
            Arrays.fill(normal[i], INF);
            normal[i][i] = 0.0;
        }
        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            String transPort = st.nextToken();
            int s = city.get(st.nextToken());
            int e = city.get(st.nextToken());
            double cost = Double.parseDouble(st.nextToken());
            if(!railro1.contains(transPort)) {
                if(railro2.contains(transPort)) {
                    railRo[s][e] = Math.min(railRo[s][e], cost / 2.0);
                    railRo[e][s] = Math.min(railRo[e][s], cost / 2.0);
                }
                else {
                    railRo[s][e] = Math.min(railRo[s][e], cost);
                    railRo[e][s] = Math.min(railRo[e][s], cost);
                }
            } else {
                railRo[s][e] = Math.min(railRo[s][e], 0.0);
                railRo[e][s] = Math.min(railRo[e][s], 0.0);
            }
            normal[s][e] = Math.min(normal[s][e], cost);
            normal[e][s] = Math.min(normal[e][s], cost);
        }
        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(normal[i][k] != INF && normal[k][j] != INF) {
                        normal[i][j] = Math.min(normal[i][j], normal[i][k] + normal[k][j]);
                    }
                    if(railRo[i][k] != INF && railRo[k][j] != INF) {
                        railRo[i][j] = Math.min(railRo[i][j], railRo[i][k] + railRo[k][j]);
                    }
                }
            }
        }
        double ans1 = 0, ans2 = 0;
        int i = 0;
        for(int j = 1; j < M; j++) {
            int s = city.get(tour[i++]);
            int e = city.get(tour[j]);
            ans1 += normal[s][e];
            ans2 += railRo[s][e];
        }
        ans2 += R;
        if(ans1 > ans2) System.out.print("Yes");
        else System.out.print("No");
    }
}
