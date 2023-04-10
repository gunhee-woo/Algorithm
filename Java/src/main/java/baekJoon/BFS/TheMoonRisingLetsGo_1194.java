package baekJoon.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static Util.Constants.INPUT;

// 비트마스크 + BFS
// 키 a ~ f 중 가지고 있는 키에 대한 정보를 비트마스크를 통해 배열에 저장
// 어떤 키를 가지고 해당 좌표에 방문했냐 안했냐를 체크해야 함
public class TheMoonRisingLetsGo_1194 {
    static int N, M;
    static String[][] map;
    static boolean[][][] check; // 세번째 배열은 키를 저장, 특정한 키를 가지고 해당 좌표를 방문했냐 안했냐를 체크
    static int[] ax = {-1, 1, 0, 0};
    static int[] ay = {0, 0, -1, 1};
    static Set<String> door;
    static Map<String, Integer> keyMap; // 문자와 비트마스크에 사용할 인덱스를 저장
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream(INPUT));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];
        check = new boolean[N][M][1 << 6]; // A ~ F 6개 이므로 1 << 6 (64)로 최대크기를 설정해주어야 함
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
                            nk = nk | (1 << keyMap.get(map[nx][ny])); // 비트마스크 삽입 연산
                            check[nx][ny][nk] = true;
                            q.add(new Point(nx, ny, nn, nk));
                        }
                        else if(door.contains(map[nx][ny])) {
                            int ix = keyMap.get(map[nx][ny].toLowerCase());
                            if((nk & (1 << ix)) != 0) { // 비트마스크 탐색 연산, 비트값이 존재한다 => key가 존재한다
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
