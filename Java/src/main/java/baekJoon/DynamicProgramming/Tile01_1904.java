package baekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

// 전형적인 피보나치 변형 문제
// 예시를 대입해보면 피보나치 수열임을 알 수 있음
// 그치만 MAX가 1000000 이므로 int 크기를 넘어가서 long 타입으로 값을 저장해야 한다
// 그리고 for문에서 값을 계산할때마다 15746을 나누는 연산을 수행해야 한다
public class Tile01_1904 {
    static int MAX = 1000001;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long d[] = new long[MAX];
        d[1] = 1;
        d[2] = 2;
        for(int i = 3; i <= N; i++)
            d[i] = (d[i - 1] + d[i - 2]) % 15746;
        System.out.print(d[N]);
    }
}
