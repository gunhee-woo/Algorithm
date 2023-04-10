package baekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import static Util.Constants.INPUT;

// �������� + �̺�Ž��
// �̺�Ž��ó�� �߰� ���� �������� �ʰ� ���� 0�� �������� ������Ʈ
// �ִ밡 20���̹Ƿ� int ������ Ŀ�� �� �� ����
public class �ο��_2470 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int start = 0; int end = N - 1;
        int answer = Integer.MAX_VALUE;
        int[] list = new int[2];
        while(start < end) {
            int sum = arr[start] + arr[end];
            if(answer > Math.abs(sum)) {
                answer = Math.abs(sum);
                list[0] = arr[start];
                list[1] = arr[end];
                if(sum == 0) break;
            }
            if(sum < 0) { // ���� 0���� �����Ƿ� start �ε����� �ڷ� �Ű� �� ū ���� ���ϵ��� ��
                start++;
            } else { // ���� 0���� ũ�Ƿ� end �ε����� ������ �Ű� �� ���� ���� ���ϵ��� ��
                end--;
            }
        }
        System.out.print(list[0] + " " + list[1]);
    }
}
