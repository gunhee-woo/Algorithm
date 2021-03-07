package BaekJoon.Recursion;

import java.util.Scanner;

public class Multiple_1629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();
        System.out.print(power(a, b, c));
    }

    private static long power(long a, long b, long c) {
        if(b == 1) return a % c;
        long val = power(a, b / 2, c);
        val = val * val % c;
        if(b % 2 == 0) return val % c;
        return val * a % c;
    }

}
