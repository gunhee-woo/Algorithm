package baekJoon.dataStructure;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static Util.Constants.INPUT;

public class Card2_2164 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            q.add(i);
        }
        while(q.size() != 1) {
            q.poll();
            int k = q.element();
            q.poll();
            q.add(k);
        }
        System.out.println(q.peek());
    }
}
