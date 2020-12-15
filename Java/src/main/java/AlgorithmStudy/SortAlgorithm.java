package AlgorithmStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortAlgorithm {
    public static void main(String[] args) {
        /**
         * String Sort Example
         */
        String[] strings = {"Apple", "Kiwi", "Orange", "Banana", "Watermelon", "Cherry"};
        System.out.println("기본 : " + Arrays.toString(strings));

        /** 오름차순 정렬 **/
        Arrays.sort(strings);

        System.out.println("오름차순 정렬 : " + Arrays.toString(strings));

        /** 내림차순 정렬 **/
        Arrays.sort(strings, Collections.reverseOrder());

        System.out.println("내림차순 정렬 : " + Arrays.toString(strings));

        Integer[] integers = {1, 25, 12, 100, 99, 0, 50};
        System.out.println("기본 : " + Arrays.toString(integers));

        /** Comparator 직접 구현 내림차순 정렬 **/
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        System.out.println("직접구현 내림차순 정렬 : " + Arrays.toString(integers));

        /** 람다를 사용한 오름차순 정렬 **/
        Arrays.sort(integers, (o1, o2) -> o1 - o2);

        System.out.println("람다활용 오름차순 정렬 : " + Arrays.toString(integers));

        /** 스트림을 활용한 내림차순 정렬 **/
        System.out.print("스트림활용 내림차순 정렬 : ");
        Arrays.stream(integers).sorted(Collections.reverseOrder()).forEach(it -> System.out.print(it + ", "));
        System.out.println();

        /** 배열 부분 내림차순 정렬 **/
        Arrays.sort(integers, 0, 4, Collections.reverseOrder());
        System.out.println("배열 부분 정렬 : " + Arrays.toString(integers));

        /** 커스텀(객체) 정렬 **/
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        Arrays.sort(strings, (o1, o2) -> o2.length() - o1.length());
        Arrays.stream(strings).sorted((o1, o2) -> o2.length() - o1.length()).forEachOrdered(it -> System.out.print(it + ", "));
        System.out.println();
        System.out.println("커스텀 정렬(String 길이 내림차순 정렬) : " + Arrays.toString(strings));

        /** 배열 => ArrayList **/
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(strings));

        /** ArrayList => 배열 **/
        strings = arr.toArray(new String[arr.size()]);

        /** ArrayList 오름차순 정렬 **/
        Collections.sort(arr);
        System.out.println(arr.toString());

        /** ArrayList 내림차순 정렬 **/
        Collections.sort(arr, Collections.reverseOrder());
        System.out.println(arr.toString());
    }
}
