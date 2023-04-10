package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static Util.Constants.INPUT;

// Long 타입이므로 987654321을 넘는 수가 나타날 수 있음
// 따라서 리스트에 담아 정렬하여 Max, Min 을 얻어냄
// 하지만 이 문제에서는 0부터 순차적으로 증가하기 때문에 굳이 정렬을 할 필요가 없이 맨 앞이 가장 작고 맨 뒤가 가장 큰 수
public class InequalitySign_2529 {
    static int K;
    static String[] strings;
    static int[] arr;
    static boolean[] check;
    static ArrayList<String> list;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        strings = br.readLine().split(" ");
        arr = new int[K + 1];
        check = new boolean[10];
        list = new ArrayList<>();
        dfs(0);
        System.out.println(list.get(list.size() - 1));
        System.out.print(list.get(0));
    }

    static void dfs(int k) {
        if(k == K + 1) {
            String str = "";
            for(int i = 0; i < K + 1; i++) {
                str += arr[i];
            }
            list.add(str);
            return;
        }
        for(int i = 0; i < 10; i++) {
            if(k == 0) {
                check[i] = true;
                arr[k] = i;
                dfs(k + 1);
                check[i] = false;
            } else {
                if(!check[i] && comp(k, i)) {
                    check[i] = true;
                    arr[k] = i;
                    dfs(k + 1);
                    check[i] = false;
                }
            }
        }
    }

    static boolean comp(int k, int i) {
        if(strings[k - 1].equals("<")) {
            return arr[k - 1] < i;
        } else {
            return arr[k - 1] > i;
        }
    }
}
