package AlgorithmStudy;

import java.util.*;

public class SortTip {
    static int[] intArr = {5, 8, 7, 9, 1, 3, 2, 6, 4, 0};
    static char[] charArr = {'c', 'b', 'z', 'i', 'w'};
    static String[] stringArr = {"abc", "cba", "acb", "aac", "aab"};

    public static void main(String[] args) {
        intSort();
        intReverseSort();
        charSort();
        charReverseSort();
        stringSort();
        stringReverseSort();
        personSort();
    }

    private static <T> void printArrayResult(T[] objects) {
        for (T object : objects) System.out.print(object + " ");
        System.out.println();
    }

    private static void intSort() {
        int[] arr = intArr;
        Arrays.sort(arr);
        printArrayResult(Arrays.stream(arr).boxed().toArray());
    }

    private static void intReverseSort() {
        int[] arr = intArr;
        Integer[] arrInteger = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).toArray(Integer[]::new);
        printArrayResult(arrInteger);
        arr = Arrays.stream(arrInteger).mapToInt(Integer::intValue).toArray();
        printArrayResult(Arrays.stream(arr).boxed().toArray());
    }

    private static void charSort() {
        char[] arr = charArr;
        Arrays.sort(arr);
        for(char c : arr) System.out.print(c + " ");
        System.out.println();
    }

    private static void charReverseSort() {
        char[] arr = charArr;
        Character[] carr = new Character[arr.length];
        for(int i = 0; i < arr.length; i++) carr[i] = arr[i];
        Arrays.sort(carr, Collections.reverseOrder());
        printArrayResult(carr);
    }

    private static void stringSort() {
        String[] arr = stringArr;
        Arrays.sort(arr);
        printArrayResult(arr);
    }

    private static void stringReverseSort() {
        String[] arr = stringArr;
        Arrays.sort(arr, Collections.reverseOrder());
        printArrayResult(arr);
    }

    static class Person {
        int age;
        String name;
        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

    }

    private static final Comparator<Person> ascendingComparator = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            // 오름차순
            if(o1.age == o2.age) return o1.name.compareTo(o2.name);
            return o1.age - o2.age;
        }
    };

    private static final Comparator<Person> descendingComparator = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            // 내림차순
            if(o1.age == o2.age) return o2.name.compareTo(o1.name);
            return o2.age - o1.age;
        }
    };

    private static void personSort() {
        Person p1 = new Person(20, "aaa");
        Person p2 = new Person(30, "bbb");
        Person p3 = new Person(20, "ccc");
        Person[] p = {p1, p2, p3};
        // 오름차순
        Arrays.sort(p, ascendingComparator);
        for(int i = 0; i < p.length; i++) System.out.println(p[i].age + " " + p[i].name);
        // 내림차순
        Arrays.sort(p, descendingComparator);
        for(int i = 0; i < p.length; i++) System.out.println(p[i].age + " " + p[i].name);
    }

    private static void comparableSort() {
        List<Point> list = new ArrayList<>();
        Point p1 = new Point(9, 1);
        list.add(p1);
        Point p2 = new Point(5, 5);
        list.add(p2);
        Point p4 = new Point(5, 6);
        list.add(p4);
        Point p3 = new Point(1, 9);
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

        // 리턴값이 양수이면 자리바뀜 음수나 0이면 그대로 유지
//        @Override
//        public int compareTo(Point o) {
//            if(this.x < o.x) return 1; // 내림차순
//            else if(this.x == o.x) {
//                if(this.y > o.y) return 1; // 오름차순
//            }
//            return -1;
//        }

        @Override
        public int compareTo(Point o) {
            if(this.x == o.x) return o.y - this.y;
            else return this.x - o.x;
        }
    }
}
