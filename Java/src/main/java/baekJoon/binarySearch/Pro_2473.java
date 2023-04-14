//package BaekJoon.BinarySearch;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//import static Util.Constants.INPUT;
//
//// �� ��� + ���ο� ���
//public class �����_2473 {
//    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream(INPUT));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
//        Arrays.sort(arr);
//        int start = 0; int end = N - 1;
//        long answer = Long.MAX_VALUE;
//        long[] list = new long[3];
//        boolean isFind = false;
//        while(start < end) {
//            long sum = arr[start] + arr[end];
//            if(sum < 0) {
//                int mid = end - 1;
//                while(arr[mid] > 0) {
//                    long sum2 = sum + arr[mid];
//                    if(answer > Math.abs(sum2)) {
//                        answer = Math.abs(sum2);
//                        list[0] = arr[start];
//                        list[1] = arr[mid];
//                        list[2] = arr[end];
//                        if(sum2 == 0) {
//                            isFind = true;
//                            break;
//                        }
//                    }
//                    mid--;
//                }
//            } else {
//                int mid = start + 1;
//                while(arr[mid] < 0) {
//                    long sum2 = sum + arr[mid];
//                    if(answer > Math.abs(sum2)) {
//                        answer = Math.abs(sum2);
//                        list[0] = arr[start];
//                        list[1] = arr[mid];
//                        list[2] = arr[end];
//                        if(sum2 == 0) {
//                            isFind = true;
//                            break;
//                        }
//                    }
//                    mid++;
//                }
//            }
//            if(isFind) break;
//            if(sum < 0) { // ���� 0���� �����Ƿ� start �ε����� �ڷ� �Ű� �� ū ���� ���ϵ��� ��
//                start++;
//            } else { // ���� 0���� ũ�Ƿ� end �ε����� ������ �Ű� �� ���� ���� ���ϵ��� ��
//                end--;
//            }
//        }
//        System.out.print(list[0] + " " + list[1] + " " + list[2]);
//    }
//}

package baekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import static Util.Constants.INPUT;

// �� ��� + ���ο� ���
// ������ ����̹Ƿ� �ִ� 30�� => long �� ����ؾ� ��
public class Pro_2473 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(arr);
        long answer = Long.MAX_VALUE;
        long[] list = new long[3];
        for(int i = 0; i < N - 2; i++) {
            int start = i + 1; int end = N - 1;
            while(start < end) {
                long sum = arr[start] + arr[end] + arr[i];
                if(answer > Math.abs(sum)) {
                    answer = Math.abs(sum);
                    list[0] = arr[start];
                    list[1] = arr[i];
                    list[2] = arr[end];
                    if(sum == 0) break;
                }
                if(sum < 0) start++;
                else end--;
            }
        }
        Arrays.sort(list);
        System.out.print(list[0] + " " + list[1] + " " + list[2]);
    }
}

// lowerBound Ǯ��
// �ϴ� �� ����� ���� ���� �� ���� 0���� ����� ���� Ÿ�ϰ����� ��� lowerBound�� 0�� ����� ���� ����