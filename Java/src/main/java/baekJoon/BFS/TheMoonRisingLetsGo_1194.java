package baekJoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

// ��Ʈ����ũ + BFS
// Ű a ~ f �� ������ �ִ� Ű�� ���� ������ ��Ʈ����ũ�� ���� �迭�� ����
// � Ű�� ������ �ش� ��ǥ�� �湮�߳� ���߳ĸ� üũ�ؾ� ��
public class TheMoonRisingLetsGo_1194 {
    static int N, M;
    static String[][] map;
    static boolean[][][] check; // ����° �迭�� Ű�� ����, Ư���� Ű�� ������ �ش� ��ǥ�� �湮�߳� ���߳ĸ� üũ
    static int[] ax = {-1, 1, 0, 0};
    static int[] ay = {0, 0, -1, 1};
    static Set<String> door;
    static Map<String, Integer> keyMap; // ���ڿ� ��Ʈ����ũ�� ����� �ε����� ����
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];
        check = new boolean[N][M][1 << 6]; // A ~ F 6�� �̹Ƿ� 1 << 6 (64)�� �ִ�ũ�⸦ �������־�� ��
        keyMap = new HashMap<>();
        for(int i = 0; i < 6; i++) {
            keyMap.put(String.valueOf((char) (i + 97)), i);
        }
        door = new HashSet<>(Arrays.asList("A", "B", "C", "D", "E", "F"));
        Point start = new Point(0, 0, 0, 0);
        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                map[i][j] = str[j];
                if(map[i][j].equals("0")) {
                    start = new Point(i, j, 0, 0);
                }
            }
        }
        boolean isEscape = false;
        int answer = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        map[start.x][start.y] = ".";
        check[start.x][start.y][0] = true;
        while(!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.peek().y;
            int cn = q.peek().n;
            int ck = q.peek().key;
            q.poll();
            if(map[cx][cy].equals("1")) {
                isEscape = true;
                answer = cn;
                break;
            }
            for(int i = 0; i < 4; i++) {
                int nx = cx + ax[i];
                int ny = cy + ay[i];
                int nn = cn + 1;
                int nk = ck;
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny].equals("#")) continue;
                if(!check[nx][ny][nk]) {
                    if(map[nx][ny].equals(".") || map[nx][ny].equals("1")) {
                        check[nx][ny][nk] = true;
                        q.add(new Point(nx, ny, nn, nk));
                    } else {
                        if(keyMap.containsKey(map[nx][ny])) {
                            nk = nk | (1 << keyMap.get(map[nx][ny])); // ��Ʈ����ũ ���� ����
                            check[nx][ny][nk] = true;
                            q.add(new Point(nx, ny, nn, nk));
                        }
                        else if(door.contains(map[nx][ny])) {
                            int ix = keyMap.get(map[nx][ny].toLowerCase());
                            if((nk & (1 << ix)) != 0) { // ��Ʈ����ũ Ž�� ����, ��Ʈ���� �����Ѵ� => key�� �����Ѵ�
                                check[nx][ny][nk] = true;
                                q.add(new Point(nx, ny, nn, nk));
                            }
                        }
                    }
                }
            }
        }
        if(isEscape) System.out.print(answer);
        else System.out.print("-1");
    }

    private static class Point {
        int x; int y; int n; int key;
        public Point(int x, int y, int n, int key) {
            this.x = x;
            this.y = y;
            this.n = n;
            this.key = key;
        }
    }

    private static void print() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
