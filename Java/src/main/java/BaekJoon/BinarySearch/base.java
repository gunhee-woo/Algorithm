package BaekJoon.BinarySearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import static Util.Constants.INPUT;

// 이진탐색 알고리즘은 기본적으로 오름차순으로 정렬된 리스트에서만 사용할 수 있음
// 중앙값이 만약 찾고자하는 값보다 크다면 그 중앙값이 새로운 끝값이 되고
// 만약 찾고자하는 값보다 작다면 중앙값이 새로운 시작값이 되면서 탐색을 진행
// 시간복잡도는 최악의경우라도 O(logN)이라 굉장히 빠름
public class base {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr); // 이진탐색은 정렬이 필수!!!!!!!!!!!
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
