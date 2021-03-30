package AlgorithmStudy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class ArrayRotate {
    static int N, M;
    static int[] d = {0, 1, 2}; // 90, 180, 270
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for(int i = 0; i < d.length; i++) {
            int[][] copy = copy(arr);
            copy = rotate(copy, d[i]);
            print(copy);
            System.out.println();
        }
    }

    static int[][] rotate(int[][] arr, int dir) {
        int[][] rotate;
        if(dir == 0 || dir == 2) { // 90, 270
            rotate = new int[M][N];
        } else { // 180
            rotate = new int[N][M];
        }
        for(int i = 0; i < rotate.length; i++) {
            for(int j = 0;  j < rotate[i].length; j++) {
                switch (dir) {
                    case 0:
                        rotate[i][j] = arr[N - 1 - j][i];
                        break;
                    case 1:
                        rotate[i][j] = arr[N - 1 - i][M - 1 - j];
                        break;
                    case 2:
                        rotate[i][j] = arr[j][M - 1 - i];
                        break;
                }
            }
        }
        return rotate;
    }

    static int[][] copy(int[][] arr) {
        int[][] temp = new int[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++) {
            temp[i] = arr[i].clone();
        }
        return temp;
    }

    static void print(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
