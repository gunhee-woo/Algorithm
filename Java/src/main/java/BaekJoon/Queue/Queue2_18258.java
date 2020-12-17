package BaekJoon.Queue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class Queue2_18258 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                q.add(x);
            } else if(order.equals("front")) {
                if(q.isEmpty()) System.out.println(-1);
                else System.out.println(q.peek());
            } else if(order.equals("back")) {

            }
        }
    }
}
