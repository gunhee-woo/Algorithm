package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

// 골드 5

// 스택이 비어있는 경우 현재 탑의 왼쪽에는 탑이 존재하지 않음 => 현재 위치 탑을 스택에 넣고 0을 결과리스트에 저장
// 스택이 비어있지 않은 경우 현재 탑보다 큰 탑을 만날 때까지 탐색 낮은 탑은 스택에서 pop을 해줌
// 큰 탑을 만나게 되면 큰 탑의 인덱스를 결과리스트에 저장하고 현재 탑을 스택에 넣어줌
// 현재 탑을 스택에 넣는 이유는 앞으로 오른쪽에서 오는 탑에서 신호를 받을 수 있기 때문

public class Top_2493 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>(); // 각 탑 인덱스 저장 용도
        int[] ints = new int[N + 1]; // 탑 높이 저장
        for(int i = 1; i <= N; i++) {
            int r = Integer.parseInt(st.nextToken());
            map.put(r, i); // 각 탑에 대한 인덱스 저장 <높이, 인덱스>
            ints[i] = r;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(ints[1]);
        sb.append(0 + " "); // 초기값 스택에 넣음
        for(int i = 2; i <= N; i++) {
            while(!stack.empty() && stack.peek() < ints[i]) { // 스택이 비어있지 않은 경우 탐색
                stack.pop();
                if(stack.empty()) { // 초기에 바로 더 큰 탑이 오른쪽에서 올 경우
                   break;
                } else {
                    if(stack.peek() > ints[i]) {
                        break;
                    }
                }
            }
            if(stack.empty()) { // 스택이 비어있는 경우
                sb.append(0 + " ");
                stack.push(ints[i]);
            } else { // 스택이 비어있지 않은 경우 현재 탑 스택에 저장
                sb.append(map.get(stack.peek())).append(" ");
                stack.push(ints[i]);
            }

        }
        System.out.print(sb.toString());
        br.close();
    }
}
