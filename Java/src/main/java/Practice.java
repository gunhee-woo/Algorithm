import java.util.*;

public class Practice {
    public static void main(String[] args) {

        long sum = 0;
        for(int i = 1; i <= 4000000; i++) sum += i;
        print(sum);
        String str = "dfdf";
        char c = 'a';
        c = str.charAt(0);
        String ss = new String(String.valueOf(c));
        String[] strs = {"adf", "Dfd"};

        for(int i = 0; i < ss.length(); i++) {

        }
        for(int i = 0; i < 4; i++) {

        }
        for(int i = 2; i <= 40; i *= 2) {

        }
    }

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[] fun(int[] arr) {
        arr[1] = 9;
        return arr;
    }

    public static void print(Object o) {
        System.out.print(o);
    }
}
