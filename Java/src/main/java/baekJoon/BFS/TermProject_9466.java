package baekJoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static Util.Constants.INPUT;

// 사이클의 개수가 몇 개인지 찾는 문제

// 1. 각각의 학생을 방문했는지에 대한 여부 check
// 2. 방문할 때마다 몇 번째로 방문했는지 cnt
// 3. 방문할 때 가장 첫 번쨰로 시작한 학생이 누구인지 => 시작점, Cycle 확인을 위함
// -> 방문한 번호가 이전에 방문한 학생인지, 현재 사이클에 해당하는지 확인
// 3번 조건을 만족한다면 현재 방문했을때의 횟수(cnt)에서 이전에 방문했을때의 값을 빼주어 사이클 노드 개수를 구함

public class TermProject_9466 {
    static int MAX = 100001;
    static String[] student;
    static boolean[] check;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            student = br.readLine().split(" ");
            Arrays.fill(check, false);
            Queue<Integer> q = new LinkedList<>();
        }
    }
}
