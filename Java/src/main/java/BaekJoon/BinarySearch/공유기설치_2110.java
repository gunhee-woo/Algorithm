package BaekJoon.BinarySearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// ��ǥ�� �ִ� ���� 1000000000 �̹Ƿ� �ܼ��� Ž���� ������ ��� �ð��ʰ�
// �Ÿ��� �������� �̺�Ž�� ����
// �ּҰŸ��� 1, �ִ�Ÿ��� arr[n - 1] - arr[0]
// ��� ���� �������� �����⸦ C�� �̻� ��ġ�� �� �ִ��� üũ
public class �����⼳ġ_2110 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int start = 1;
        int end = arr[N - 1] - arr[0];
        int answer = 0;
        while(start <= end) {
            int mid = (start + end) / 2; // => ����
            if(check(arr, mid, C)) { // �����⸦ C�� �̻� ��ġ�� �� ������
                answer = Math.max(answer, mid);
                start = mid + 1; // �����⸦ �ٿ��� �ȴ� => ������ ����
            } else { // �����⸦ �� ��ġ�ؾ� �ȴ� => ������ ����
                end = mid - 1;
            }
        }
        System.out.print(answer);
    }

    private static boolean check(int[] arr, int mid, int c) { // ��� ���� �������� ������ C�� �̻� ��ġ üũ
        int start = arr[0]; // ������
        int cnt = 1;
        for(int i = 1; i < arr.length; i++) {
            int d = arr[i] - start;
            if(mid <= d) { // ���ذŸ� �̻��̴� -> �����⸦ ��ġ �� �� �ִ�
                cnt++;
                start = arr[i];
            }
        }
        return cnt >= c;
    }
}
