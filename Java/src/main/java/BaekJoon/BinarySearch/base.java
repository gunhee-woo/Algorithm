package BaekJoon.BinarySearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import static Util.Constants.INPUT;

// ����Ž�� �˰������� �⺻������ ������������ ���ĵ� ����Ʈ������ ����� �� ����
// �߾Ӱ��� ���� ã�����ϴ� ������ ũ�ٸ� �� �߾Ӱ��� ���ο� ������ �ǰ�
// ���� ã�����ϴ� ������ �۴ٸ� �߾Ӱ��� ���ο� ���۰��� �Ǹ鼭 Ž���� ����
// �ð����⵵�� �־��ǰ��� O(logN)�̶� ������ ����
public class base {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr); // ����Ž���� ������ �ʼ�!!!!!!!!!!!
        int target = Integer.parseInt(br.readLine());
        System.out.print(binarySearch(arr, target));
    }

    public static boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while(start <= end) {
            mid = (start + end) / 2;
            if(target > arr[mid]) {
                start = mid + 1;
            } else if(target < arr[mid]) {
                end = mid - 1;
            } else { // target == arr[mid]
                return true;
            }
        }
        return false;
    }
}