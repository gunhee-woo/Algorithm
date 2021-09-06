package BaekJoon.Simulation.SamsungProblem_A;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

public class Snake_3190 {
    static int[] ax = {0, 0, 1, -1}; // 오른쪽 왼쪽 아래쪽 위쪽
    static int[] ay = {1, -1, 0, 0};
    static int[] dl = {3, 2, 0, 1};
    static int[] dr = {2, 3, 1, 0};
    static int N, K, L;
    static int[][] map;
    static Map<Integer, Character> mp;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        for(int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1; // 사과
        }
        L = Integer.parseInt(br.readLine());
        mp = new HashMap<>();
        for(int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            char b = st.nextToken().charAt(0);
            mp.put(a, b);
        }
        Snake snake = new Snake(new LinkedList<>(), 0);
        snake.dq.add(new Point(1, 1));
        int time = 0;
        while(true) {
            time++;
            int nx = snake.dq.peek().x + ax[snake.dir];
            int ny = snake.dq.peek().y + ay[snake.dir];
            if(nx <= 0 || nx > N || ny <= 0 || ny > N || isCollideSelf(snake, nx, ny)) {
                break;
            }
            snake.dq.offerFirst(new Point(nx, ny));
            if(map[nx][ny] == 1) {
                map[nx][ny] = 0;
            } else {
                snake.dq.pollLast();
            }
            if(mp.containsKey(time)) {
                char c = mp.get(time);
                if(c == 'L') {
                    snake.dir = dl[snake.dir];
                } else if(c == 'D') {
                    snake.dir = dr[snake.dir];
                }
            }
        }
        System.out.println(time);
    }

    public static boolean isCollideSelf(Snake snake, int nx, int ny) {
        for(Point p : snake.dq) {
            int cx = p.x;
            int cy = p.y;
            if(nx == cx && ny == cy) return true;
        }
        return false;
    }

    public static void printSnake(Snake snake, int nx, int ny) {
        StringBuilder sb = new StringBuilder();
        for(Point p : snake.dq) {
            sb.append(p.x).append(" ").append(p.y).append(" ");
        }
        sb.append(" ").append(nx).append(" ").append(ny).append("   ").append(snake.dir);
        System.out.println(sb.toString());
    }

    public static class Snake {
        Deque<Point> dq; int dir;
        public Snake(Deque<Point> dq, int dir) {
            this.dq = dq;
            this.dir = dir;
        }
    }

    public static class Point {
        int x; int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
