package BaekJoon.BinarySearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

// �̺�Ž�� ���빮��
// ������ ������ ���̷� ���ؾ� ��
// �������� : ������ ���̰� �ִ� 1,000,000,000 �̹Ƿ� int �� ������ �Ѿ�⿡ long ������ �ؾ���
public class �����ڸ���_2805 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(arr);
        long start = 0;
        long end = arr[N - 1];
        long answer = 0;
        while(start <= end) {
            long mid = (start + end) / 2; // ����, ���ܱ��� ����
            long sum = 0;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] > mid) // ������ ���� �� �����Ƿ�
                    sum += arr[i] - mid;
            }
            if(sum >= M) { // ��� M������ ������ ������ �Ѵٴ� ������ �����Ƿ�
                answer = Math.max(answer, mid);
                start = mid + 1; // �������� �ϴ� ������ ������ �ٿ��� ��, ���̸� �ִ�� �ϴ� ���� ã�ƾ� �ϹǷ� => ���ܱ� ���̸� ����
            } else { // �������� �ϴ� ������ ������ �÷��� �� => ���ܱ� ���̸� ����
                end = mid - 1;
            }
        }
        System.out.print(answer);
    }
}
