package baekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;

// ���Ʈ������ Ǯ�� �ð��ʰ� �߻�
// B[k] => k���� ���� ������ ������ ������
// 1. A[i][j]���� i�࿡ ���� ���ڵ��� ��� i�� ����̴�
// 2. min(mid/i, N)�� i��° �࿡�� mid���� ����(������ k���� ����) ���ڵ��� ����
// 3. min�� ���� ������ mid�� N�� �Ѿ �� �����Ƿ�
// 4. 1���� N���� ��� i�࿡ ���� m/i�� �����ϸ� ī��Ʈ
// 5. O(logK)�� �ð� ���⵵
public class K_number_1300 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int left = 1, right = K, answer = 0;
        while(left <= right) {
            long cnt = 0;
            int mid = (left + right) / 2;
            for(int i = 1; i <= N; i++) cnt += Math.min(mid / i, N); // �� �࿡ ���ؼ� mid���� ���� ���ڵ��� ������ ��
            if(cnt < K) left = mid + 1;
            else {
                answer = mid;
                right = mid - 1;
            }
        }
        System.out.print(answer);
    }
}
