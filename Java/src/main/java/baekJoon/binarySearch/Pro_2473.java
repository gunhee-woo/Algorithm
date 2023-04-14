//package BaekJoon.BinarySearch;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//import static Util.Constants.INPUT;
//
//// 두 용액 + 새로운 용액
//public class 세용액_2473 {
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
//            if(sum < 0) { // 합이 0보다 작으므로 start 인덱스를 뒤로 옮겨 더 큰 값을 더하도록 함
//                start++;
//            } else { // 합이 0보다 크므로 end 인덱스를 앞으로 옮겨 더 작은 값을 더하도록 함
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

// 두 용액 + 새로운 용액
// 세가지 용액이므로 최대 30억 => long 형 사용해야 함
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

// lowerBound 풀이
// 일단 두 용액의 합을 구함 이 합을 0으로 만드는 값을 타켓값으로 삼아 lowerBound로 0에 가까운 값을 구함