package BaekJoon.BinarySearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import static Util.Constants.INPUT;

// 이분탐색 알고리즘은 기본적으로 오름차순으로 정렬된 리스트에서만 사용할 수 있음
// 중앙값이 만약 찾고자하는 값보다 크다면 그 중앙값이 새로운 끝값이 되고
// 만약 찾고자하는 값보다 작다면 중앙값이 새로운 시작값이 되면서 탐색을 진행
// 시간복잡도는 최악의경우라도 O(logN)이라 굉장히 빠름
public class base {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr); // 이분탐색은 정렬이 필수!!!!!!!!!!!
        int target = Integer.parseInt(br.readLine());
        System.out.println(binarySearch(arr, target));
        System.out.println(lowerBound(arr, target));
        System.out.println(upperBound(arr, target));
        // Ex)
        // arr : 1 2 2 3 3 3 4 6 7
        // k : 3
        // true
        // 3
        // 6
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

    // 배열에서 찾으려는 target 값보다 같거나 큰 숫자의 첫 번째 인덱스를 반환
    public static int lowerBound(int[] arr, int target) {
        int start = 0;
        int end = arr.length; // 이진 탐색과 달리 정확한 값이 있는 곳을 찾는것이 아니므로 1을 빼지 않음
        while(start < end) {
            int mid = (end + start) / 2;
            if(arr[mid] >= target) { // 크거나 같을때의 가장 첫 번째 인덱스를 찾아야하므로 end = mid 로 계속 수행
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    // 배열에서 찾으려는 target 값을 초과하는 첫 번째 인덱스를 반환
    public static int upperBound(int[] arr, int target) {
        int start = 0;
        int end = arr.length;
        while(start < end) {
            int mid = (start + end) / 2;
            if(arr[mid] > target) { // 초과할때의 가장 첫 번째 인덱스를 찾아야하므로
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
