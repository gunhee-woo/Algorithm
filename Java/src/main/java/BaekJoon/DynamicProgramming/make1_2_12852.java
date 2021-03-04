package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static Util.Constants.INPUT;


public class make1_2_12852 {
    static int[] d;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        d = new int[N];
        d[1] = 0;
        for(int i = 2; i <= N; i++) {
            if(i % 2 == 0) {

            }
        }
    }
}
