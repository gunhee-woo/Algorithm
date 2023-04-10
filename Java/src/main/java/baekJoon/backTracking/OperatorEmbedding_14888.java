package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class OperatorEmbedding_14888 {
    static int N;
    static int[] arr, op;
    static int min = 2000000000, max = -2000000000;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        op = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
//        dfs1(1, arr[0]);
        dfs2(op[0], op[1], op[2], op[3], 1, arr[0]);
        System.out.println(max);
        System.out.print(min);
    }

    static void dfs2(int plus, int minus, int multiple, int divide, int k, int sum) {
        if(k == N) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }
        if(plus > 0) dfs2(plus - 1, minus, multiple, divide, k + 1, sum + arr[k]);
        if(minus > 0) dfs2(plus, minus - 1, multiple, divide, k + 1, sum - arr[k]);
        if(multiple > 0) dfs2(plus, minus, multiple - 1, divide, k + 1, sum * arr[k]);
        if(divide > 0) dfs2(plus, minus, multiple, divide - 1, k + 1, sum / arr[k]);
    }

    static void dfs1(int k, int sum) {
        if(k == N) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }
        for(int i = 0; i < 4; i++) {
            if(op[i] != 0) {
                if(i == 0) {
                    sum += arr[k];
                    op[i]--;
                    dfs1(k + 1, sum);
                    sum -= arr[k];
                    op[i]++;
                } else if(i == 1) {
                    sum -= arr[k];
                    op[i]--;
                    dfs1(k + 1, sum);
                    sum += arr[k];
                    op[i]++;
                } else if(i == 2) {
                    sum *= arr[k];
                    op[i]--;
                    dfs1(k + 1, sum);
                    sum /= arr[k];
                    op[i]++;
                } else {
                    int remainder = (sum % arr[k]);
                    if(sum < 0) {
                        int tmp = -sum / arr[k];
                        sum = -tmp;
                    } else {
                        sum /= arr[k];
                    }
                    op[i]--;
                    dfs1(k + 1, sum);
                    sum *= arr[k];
                    if(sum < 0) sum -= remainder;
                    else sum += remainder;
                    op[i]++;
                }
            }
        }
    }
}
