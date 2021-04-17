package Programmers.BackTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

public class menu_renewal_2021_kakao_2 {
    static boolean[] check;
    static HashMap<String, Integer> map;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] orders = br.readLine().split(" ");
        int[] course = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] result = solution(orders, course);
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            for(int j = 0; j < orders.length; j++) {
                check = new boolean[orders[j].length()];
                dfs(0,"", orders[j], course[i]);
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }

    public static void dfs(int k, String str, String order, int size) {
        if(k == size) {
            if(map.containsKey(str)) map.put(str, map.get(str) + 1);
            else map.put(str, 1);
            return;
        }
        for(int i = 0; i < order.length(); i++) {
            if(!check[i]) {
                check[i] = true;
                str += order.charAt(i);
                dfs(k + 1, str, order, size);
                str = str.substring(0, str.length() - 1);
                check[i] = false;
            }
        }
    }
}
