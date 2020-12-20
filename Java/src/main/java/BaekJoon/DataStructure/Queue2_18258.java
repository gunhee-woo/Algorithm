package BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

public class Queue2_18258 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        int head = 0, tail = 0;
        for(int i = 0; i < N; i++) {
            String order = br.readLine();
            if(order.startsWith("push")) {
                String[] strings = order.split(" ");
                arr[tail++] = strings[1];
            } else if(order.startsWith("pop")) {
                if(head == tail) sb.append("-1\n");
                else sb.append(arr[head++]).append("\n");
            } else if(order.startsWith("front")) {
                if(head == tail) sb.append("-1\n");
                else sb.append(arr[head]).append("\n");
            } else if(order.startsWith("back")) {
                if(head == tail) sb.append("-1\n");
                else sb.append(arr[tail - 1]).append("\n");
            } else if(order.startsWith("size")) {
                if(head == tail) sb.append("-1\n");
                else sb.append((tail - head)).append("\n");
            } else if(order.startsWith("empty")) {
                if(head == tail) sb.append("1\n");
                else sb.append("0\n");
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}
