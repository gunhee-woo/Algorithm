package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static Util.Constants.INPUT;

// Long Ÿ���̹Ƿ� 987654321�� �Ѵ� ���� ��Ÿ�� �� ����
// ���� ����Ʈ�� ��� �����Ͽ� Max, Min �� ��
// ������ �� ���������� 0���� ���������� �����ϱ� ������ ���� ������ �� �ʿ䰡 ���� �� ���� ���� �۰� �� �ڰ� ���� ū ��
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
