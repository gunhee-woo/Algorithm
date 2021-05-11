package Programmers.Graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static Util.Constants.INPUT;

public class RacewayConstruction_2020_kakao_intern_4 {
    static int answer = 987654321;
    static int[] ax = {0, 1, 0, -1};
    static int[] ay = {1, 0, -1, 0};
    static boolean[][] check;
    static int[][] d;
    static int len;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "dfdf";
        str.split("\\{,\\}");
        str.substring(1, str.length() - 1);
        List<String> list = new ArrayList<>();
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        list = list.stream().distinct().collect(Collectors.toList());
    }

    public int solution(int[][] board) {
        len = board.length;
        d = new int[len][len];
        check = new boolean[len][len];
        Arrays.fill(d, 987654321);
        dfs(0, 0, 0, 0, board);
        dfs(0, 0, 0, 1, board);
        return answer;
    }

    // dir = 1 이면 아래로 , dir = 0 이면 오른쪽으로, dir = 2 이면 왼쪽으로, dir = 3이면 위쪽
    public static void dfs(int x, int y, int cost, int dir, int[][] board) {
        // if(x < 0 || x >= board.length || y < 0 || y >= board.length) return;
        // if(board[x][y] == 1) return;
        if(x == len - 1 && y == len - 1) {
            answer = Math.min(answer, cost);
            return;
        }
        if(dir == 1) { // 차의 방향이 아래
            for(int i = 0; i < 4; i++) {
                if(i == 3) continue;
                int nx = x + ax[i];
                int ny = y + ay[i];
                if(isOverRange(nx, ny)) continue;
                if(board[nx][ny] == 1) continue;
                if(i == 1) dfs(nx, ny, cost + 100, 1, board);
                else {
                    dfs(nx, ny, cost + 600, 0, board);
                    dfs(nx, ny, cost + 600, 2, board);
                }
            }
            // dfs(x + 1, y, cost + 100, 1, board);
            // dfs(x, y + 1, cost + 600, 0, board);
            // dfs(x, y - 1, cost + 600, 2, board);
        } else if(dir == 0) { // 차의 방향이 오른쪽
            for(int i = 0; i < 4; i++) {
                if(i == 2) continue;
                int nx = x + ax[i];
                int ny = y + ay[i];
                if(isOverRange(nx, ny)) continue;
                if(board[nx][ny] == 1) continue;
                if(i == 0) dfs(nx, ny, cost + 100, 0, board);
                else {
                    dfs(nx, ny, cost + 600, 1, board);
                    dfs(nx, ny, cost + 600, 3, board);
                }
            }
            // dfs(x + 1, y, cost + 600, 1, board);
            // dfs(x, y + 1, cost + 100, 0, board);
            // dfs(x - 1, y, cost + 600, 3, board);
        } else if(dir == 2) { // 차의 방향이 왼쪽
            for(int i = 0; i < 4; i++) {
                if(i == 0) continue;
                int nx = x + ax[i];
                int ny = y + ay[i];
                if(isOverRange(nx, ny)) continue;
                if(board[nx][ny] == 1) continue;
                if(i == 2) dfs(nx,ny, cost + 100, 2, board);
                else {
                    dfs(nx, ny, cost + 600, 1, board);
                    dfs(nx, ny, cost + 600, 3, board);
                }
            }
            // dfs(x + 1, y, cost + 600, 1, board);
            // dfs(x, y - 1, cost + 100, 2, board);
            // dfs(x - 1, y, cost + 600, 3, board);
        } else { // 차의 방향이 위쪽
            for(int i = 0; i < 4; i++) {
                if(i == 1) continue;
                int nx = x + ax[i];
                int ny = y + ay[i];
                if(isOverRange(nx, ny)) continue;
                if(board[nx][ny] == 1) continue;
                if(i == 3) dfs(nx, ny, cost + 100, 3, board);
                else {
                    dfs(nx, ny, cost + 600, 0, board);
                    dfs(nx, ny, cost + 600, 2, board);
                }
            }
            // dfs(x - 1, y, cost + 100, 3, board);
            // dfs(x, y + 1, cost + 600, 0, board);
            // dfs(x, y - 1, cost + 600, 2, board);
        }
    }

    public static boolean isOverRange(int x, int y) {
        return x < 0 || x >= len || y < 0 || y >= len;
    }
}
