package Programmers.BruteForce;

import java.util.ArrayList;
import java.util.List;

public class CheckTheDistance_2021_kakao_intern {
    static int[] ax1 = {0, 0, 1, -1};
    static int[] ay1 = {1, -1, 0, 0};
    static int[] ax2 = {0, 0, 2, -2};
    static int[] ay2 = {2, -2, 0, 0};
    static int[] ax3 = {-1, -1, 1, 1};
    static int[] ay3 = {-1, 1, 1, -1};
    public static void main(String[] args) {

    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i = 0; i < 5; i++) {
            String[][] map = new String[5][5];
            List<Point> list = new ArrayList<>();
            for(int j = 0; j < 5; j++) {
                String[] temps = places[i][j].split("");
                for(int k = 0; k < 5; k++) {
                    map[j][k] = temps[k];
                    if(map[j][k].equals("P")) list.add(new Point(j, k));
                }
            }
            if(check(list, map)) answer[i] = 1;
            else answer[i] = 0;

        }
        return answer;
    }

    public static boolean check(List<Point> list, String[][] map) {
        for(int i = 0; i < list.size(); i++) {
            int cx = list.get(i).x;
            int cy = list.get(i).y;
            for(int j = 0; j < 4; j++) {
                int nx = cx + ax1[j];
                int ny = cy + ay1[j];
                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if(map[nx][ny].equals("P")) {
                    System.out.println(1);
                    return false;
                }
            }
            for(int j = 0; j < 4; j++) {
                int nx = cx + ax2[j];
                int ny = cy + ay2[j];
                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if(map[nx][ny].equals("P")) {
                    if(cx == nx) {
                        if(cy < ny) {
                            if(cy + 1 >= 5) continue;
                            if(!map[cx][cy + 1].equals("X")) {
                                return false;
                            }
                        } else {
                            if(cy - 1 < 0) continue;
                            if(!map[cx][cy - 1].equals("X")) {
                                return false;
                            }
                        }
                    }
                    else if(cy == ny) {
                        if(cx < nx) {
                            if(cx + 1 >= 5) continue;
                            if(!map[cx + 1][cy].equals("X")) {
                                return false;
                            }
                        } else {
                            if(cx - 1 < 0) continue;
                            if(!map[cx - 1][cy].equals("X")) {
                                return false;
                            }
                        }

                    }
                }
            }
            for(int j = 0; j < 4; j++) {
                int nx = cx + ax3[j];
                int ny = cy + ay3[j];
                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if(map[nx][ny].equals("P")) {
                    if(!map[cx][ny].equals("X") || !map[nx][cy].equals("X")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static class Point {
        int x; int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
