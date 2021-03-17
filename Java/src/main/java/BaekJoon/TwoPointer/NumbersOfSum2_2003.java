package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// ��ǥ���� �� ������ �˰���
// �ð����⵵ O(N)
// �� ������ �˰����� ��� ���Ұ� �ڿ����̾�� �ϰ� ���ϰ��� �ϴ� ���� �ڿ����̾�� ���� ����
// �ΰ��� �����Ͱ� ������ �����ϸ鼭 ������ ������ ���Ҹ� ���Ͽ� �������� ����
// s,e��� �� �����Ͱ� ���� ��, e�� �ڷ� ������ ���� ���� �ѱ� ���Ҹ� sum�� ���ϰ�
// s�� �ڷ� ������ ���� ���� �ѱ� ���Ҹ� sum���� ���� ���
// ���� ������( [s, e) )�� ���ϰ��� �ϴ� �� M�� ���ٸ� ���++
public class NumbersOfSum2_2003 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = 0, sum = 0, s = 0, e = 0;
        while(true) {
            if(sum >= M) sum -= arr[s++];
            else if(e == N) break;
            else sum += arr[e++];
            if(sum == M) result++;
        }
        System.out.print(result);
    }
}
