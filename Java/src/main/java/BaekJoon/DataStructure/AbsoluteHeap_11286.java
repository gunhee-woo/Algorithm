package BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

import static Util.Constants.INPUT;

public class AbsoluteHeap_11286 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Val> pq = new PriorityQueue<>(N, new Comparator<Val>() {
            @Override
            public int compare(Val o1, Val o2) {
                if(o1.absValue == o2.absValue) return o1.value - o2.value;
                return o1.absValue - o2.absValue;
            }
        });
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll().value);
            } else pq.add(new Val(Math.abs(x), x));
        }
    }

    static class Val {
        int absValue;
        int value;
        public Val(int absValue, int value) {
            this.absValue = absValue;
            this.value = value;
        }
    }
}
