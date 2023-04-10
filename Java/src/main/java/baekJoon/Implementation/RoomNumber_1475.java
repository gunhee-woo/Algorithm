package baekJoon.Implementation;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

import static Util.Constants.INPUT;

public class RoomNumber_1475 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        Scanner sc = new Scanner(System.in);
        final String str = sc.next();
        int result = 0;
        int[] arr = new int[10];
        Arrays.fill(arr, 0);
        for(int i = 0; i < str.length(); i++) {
            int n = str.charAt(i) - '0';
            arr[n]++;
        }
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            if(i != 6 && i != 9) {
                max = Math.max(max, arr[i]);
            }
        }
        result = Math.max(max, (arr[6] + arr[9] + 1) / 2);
        System.out.println(result);
        sc.close();
    }
}
