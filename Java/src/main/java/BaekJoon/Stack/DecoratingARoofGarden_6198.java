package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

import static Util.Constants.INPUT;

/**
 * *************************************************************************************
 * 첫 번째 줄에 빌딩의 개수 N이 입력된다.(1 ≤ N ≤ 80,000)
 * 두 번째 줄 부터 N+1번째 줄까지 각 빌딩의 높이가 hi 입력된다. (1 ≤ hi ≤ 1,000,000,000)
 * => 빌딩의 수의 합 결과를 int 자료형으로 받을 경우 초과가 일어나게 됨
 * 따라서, 자료형을 long 으로 바꾸어 해결해야 함
 */

// 스택에 저장된 것은 오른쪽 빌딩을 관찰할 수 있는 빌딩들을 의미하며 스택의 사이즈는 빌딩의 수를 의미함
// 현재 빌딩보다 오른쪽의 빌딩이 작다면 현재 빌딩에서 오른쪽 빌딩을 볼 수 있다는 것이므로 카운트를 함
// 따라서 현재 빌딩 보다 작은 빌딩을 만날때 마다 현재 스택의 사이즈를 결과값에 더함

// 골드 5
public class DecoratingARoofGarden_6198 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long result = 0;
        stack.push(Integer.parseInt(br.readLine()));
        for(int i = 1; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            while(!stack.empty() && stack.peek() <= value) {
                stack.pop();
            }
            result += stack.size();
            stack.push(value);
        }
        System.out.println(result);
        br.close();
    }
}
