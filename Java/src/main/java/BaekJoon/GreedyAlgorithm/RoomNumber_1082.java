package BaekJoon.GreedyAlgorithm;

import java.io.*;
import java.util.*;

import static Util.Constants.INPUT;

public class RoomNumber_1082 {
    static int n, money;
    static int[] num;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args)throws Exception{
        System.setIn(new FileInputStream(INPUT));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int ma = 51, mb = 51;
        int ax = 0, bx = 0;
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            num[i] = temp;
            if(i >= 1) {
                if(ma >= num[i]) {
                    ma = num[i];
                    ax = i;
                }
            }
            if(mb >= num[i]) {
                mb = num[i];
                bx = i;
            }
        }
        money = Integer.parseInt(br.readLine());
        if(money < ma) {
            bw.write(0);
            bw.flush();
            bw.close();
        }
        list.add(ma);
        answer.add(ax);
        money -= ma;
        int rm = 0;
        while(true) {
            if((money - mb) < 0) {
                rm = money;
                break;
            }
            list.add(mb);
            answer.add(bx);
            money -= mb;
        }
        int ix = 0;
        int nx = n - 1;
        while(rm != 0) {
            if(ix == list.size() || nx < 0)
                break;
            if(answer.get(ix) == nx) {
                ix++;
                continue;
            }
            if((num[nx] - list.get(ix)) <= rm) {
                rm -= (num[nx] - list.get(ix));
                answer.set(ix, nx);
                list.set(ix, num[nx]);
                ix++;
                nx = n - 1;
            } else {
                nx--;
            }
        }
        StringBuilder str = new StringBuilder();
        for (Integer integer : answer) {
            str.append(integer);
        }
        bw.write(str.toString());
        bw.flush();
        bw.close();
    }
}
