package BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

import static Util.Constants.INPUT;

// 우선순위 큐 문제 값이 작은것이 우선순위가 되는 경우를 최소 힙이라고 부름
public class MinHeap_1927 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x > 0) {
                pq.add(x);
            } else if(x == 0) {
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            }
        }
    }
}
