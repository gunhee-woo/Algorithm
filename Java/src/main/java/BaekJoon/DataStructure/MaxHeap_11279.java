package BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

import static Util.Constants.INPUT;

// �켱���� ť ���� ���� �������� �켱������ �Ǵ� ��츦 �ִ� ���̶�� �θ�
// ������ �ԷµǴ� �ڿ����� 2�� 31�º��� �۴� => int ���� ����� �� �ִٴ� ��, int ���� �ִ밪�� 2�� 31�� - 1 (�� 21��) �̹Ƿ�
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
