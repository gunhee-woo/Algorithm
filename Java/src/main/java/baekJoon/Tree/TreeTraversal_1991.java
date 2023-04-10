package baekJoon.Tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class TreeTraversal_1991 {
    static int N;
    static String[][] arr;
    static Map<String, Integer> mp;
    static String answer = "";
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[27][3];
        mp = new HashMap<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3 ; j++) {
                arr[i][j] = st.nextToken();
            }
            mp.put(arr[i][0], i); // 각 노드에 대한 정보(값, 인덱스) 저장
        }
        preOrder(0);
        System.out.println(answer);
        answer = "";
        inOrder(0);
        System.out.println(answer);
        answer = "";
        postOrder(0);
        System.out.println(answer);
    }

    // 전위 순회
    private static void preOrder(int x) {
        if(answer.length() == N) {
            return;
        }
        answer += arr[x][0];
        if(!arr[x][1].equals(".")) {
            preOrder(mp.get(arr[x][1]));
        }
        if(!arr[x][2].equals(".")) {
            preOrder(mp.get(arr[x][2]));
        }
    }

    // 중위 순회
    private static void inOrder(int x) {
        if(answer.length() == N) {
            return;
        }
        if(!arr[x][1].equals(".")) {
            inOrder(mp.get(arr[x][1]));
        }
        answer += arr[x][0];
        if(!arr[x][2].equals(".")) {
            inOrder(mp.get(arr[x][2]));
        }
    }

    // 후위 순회
    private static void postOrder(int x) {
        if(answer.length() == N) {
            return;
        }
        if(!arr[x][1].equals(".")) {
            postOrder(mp.get(arr[x][1]));
        }
        if(!arr[x][2].equals(".")) {
            postOrder(mp.get(arr[x][2]));
        }
        answer += arr[x][0];
    }
}
