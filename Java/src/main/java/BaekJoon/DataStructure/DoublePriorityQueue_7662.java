package BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

import static Util.Constants.INPUT;

public class DoublePriorityQueue_7662 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            PriorityQueue<Integer> rPq = new PriorityQueue<>(Collections.reverseOrder());
            while(k-- > 0) {
                String[] str = br.readLine().split(" ");
                String cmd = str[0];
                int val = Integer.parseInt(str[1]);
                if(cmd.equals("I")) {
                    pq.add(val);
                    rPq.add(val);
                } else {
                    if(!pq.isEmpty()) {
                        if(val < 0) {
                            int v = pq.poll();
                            rPq.remove(v);
                        } else {
                            int v = rPq.poll();
                            pq.remove(v);
                        }
                    }
                }
            }
            if(!pq.isEmpty()) {
                System.out.println(rPq.peek() + " " + pq.peek());
            } else {
                System.out.println("EMPTY");
            }
        }
    }
}
