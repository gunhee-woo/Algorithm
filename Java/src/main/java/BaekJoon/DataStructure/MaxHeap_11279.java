package BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

import static Util.Constants.INPUT;

// 우선순위 큐 문제 값이 높은것이 우선순위가 되는 경우를 최대 힙이라고 부름
// 문제에 입력되는 자연수가 2의 31승보다 작다 => int 형을 사용할 수 있다는 뜻, int 형의 최대값은 2의 31승 - 1 (약 21억) 이므로
public class MaxHeap_11279 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
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
