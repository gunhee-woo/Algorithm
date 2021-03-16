package Programmers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

public class RankSearch_2021_kakao_3 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = new String[6];
        String[] query = new String[6];
        for(int i = 0; i < 6; i++) {
            info[i] = br.readLine();
        }
        for(int i = 0; i < 6; i++) {
            query[i] = br.readLine();
        }
        int[] sol = solution(info, query);
        for(int i = 0; i < sol.length; i++) {
            System.out.print(sol[i] + " ");
        }
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        String[] lang = {"java", "python", "cpp", "-"};
        String[] end = {"frontend", "backend", "-"};
        String[] carrier = {"junior", "senior", "-"};
        String[] food = {"pizza", "chicken", "-"};
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        for(int a = 0; a < lang.length; a++) {
            for(int b = 0; b < end.length; b++) {
                for(int c = 0; c < carrier.length; c++) {
                    for(int d = 0; d < food.length; d++) {
                        map.put(lang[a] + end[b] + carrier[c] + food[d], new ArrayList<>());
                    }
                }
            }
        }
        for(int i = 0; i < info.length; i++) {
            String[] str = info[i].split(" ");
            map.get(str[0] + str[1] + str[2] + str[3]).add(Integer.parseInt(str[4]));
            map.get(str[0] + str[1] + str[2] + "-").add(Integer.parseInt(str[4]));
            map.get(str[0] + str[1] + "-" + str[3]).add(Integer.parseInt(str[4]));
            map.get(str[0] + "-" + str[2] + str[3]).add(Integer.parseInt(str[4]));
            map.get("-" + str[1] + str[2] + str[3]).add(Integer.parseInt(str[4]));
            map.get(str[0] + str[1] + "-" + "-").add(Integer.parseInt(str[4]));
            map.get(str[0] + "-" + str[2] + "-").add(Integer.parseInt(str[4]));
            map.get("-" + str[1] + str[2] + "-").add(Integer.parseInt(str[4]));
            map.get(str[0] + "-" + "-" + str[3]).add(Integer.parseInt(str[4]));
            map.get("-" + str[1] + "-" + str[3]).add(Integer.parseInt(str[4]));
            map.get("-" + "-" + str[2] + str[3]).add(Integer.parseInt(str[4]));
            map.get(str[0] + "-" + "-" + "-").add(Integer.parseInt(str[4]));
            map.get("-" + str[1] + "-" + "-").add(Integer.parseInt(str[4]));
            map.get("-" + "-" + str[2] + "-").add(Integer.parseInt(str[4]));
            map.get("-" + "-" + "-" + str[3]).add(Integer.parseInt(str[4]));
            map.get("-" + "-" + "-" + "-").add(Integer.parseInt(str[4]));
        }

        for(Map.Entry<String, ArrayList<Integer>> m : map.entrySet()) {
            Collections.sort(m.getValue());
        }

        for(int i = 0; i < query.length; i++) {
            String[] str = query[i].split(" and ");
            String[] last = str[3].split(" ");
            String fd = last[0];
            int score = Integer.parseInt(last[1]);
            System.out.println("score : " + score);
            ArrayList<Integer> arr = map.get(str[0] + str[1] + str[2] + fd);
            int ix = Collections.binarySearch(arr, score);
            if(ix >= 0) {
                for(int a = ix - 1; a >= 0; a--) {

                }
            } else {

            }
        }
        return answer;
    }
}
