package AlgorithmStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        Point p1 = new Point(1, 9);
        list.add(p1);
        Point p2 = new Point(5, 5);
        list.add(p2);
        Point p4 = new Point(5, 6);
        list.add(p4);
        Point p3 = new Point(9, 1);
        list.add(p3);
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).x + " " + list.get(i).y);
        }

    }

    public static class Point implements Comparable<Point>{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

//        @Override
//        public int compareTo(Point o) {
//            if(this.x < o.x) return 1; // 내림차순
//            else if(this.x == o.x) {
//                if(this.y > o.y) return 1; // 오름차순
//            }
//            return 1;
//        }

        @Override
        public int compareTo(Point o) {
            if(this. y < o.y) return 1;
            return -1;
        }
    }
}
