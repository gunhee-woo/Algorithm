package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static Util.Constants.INPUT;

public class Sudoku_2580 {
    static int[][] map;
    static boolean[][] hLine, vLine, square;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        hLine = new boolean[9][10];
        vLine = new boolean[9][10];
        square = new boolean[9][10];
        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0) {
                    hLine[i][map[i][j]] = true;
                    vLine[j][map[i][j]] = true;
                    square[squareIndex(i, j)][map[i][j]] = true;
                }
            }
        }
        dfs(0);
    }

    private static int squareIndex(int x, int y) {
        return 3 * (x / 3) + y / 3;
    }

    private static void dfs(int k) {
        if(k == 81) {
            print();
            System.exit(0);
            return;
        }
        int x = k / 9;
        int y = k % 9;
        if(map[x][y] == 0) {
            for(int i = 1; i <= 9; i++) {
                if(!hLine[x][i] && !vLine[y][i] && !square[squareIndex(x, y)][i]) {
                    hLine[x][i] = true;
                    vLine[y][i] = true;
                    square[squareIndex(x, y)][i] = true;
                    map[x][y] = i;
                    dfs(k + 1);
                    map[x][y] = 0;
                    hLine[x][i] = false;
                    vLine[y][i] = false;
                    square[squareIndex(x, y)][i] = false;
                }
            }
        } else {
            dfs(k + 1);
        }
    }

    private static void print() {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
