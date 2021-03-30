package AlgorithmStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Array {
    public static void main(String[] args) {
        String[] strings = {"Apple", "Kiwi", "Orange", "Banana", "Watermelon", "Cherry"};

        /** 문자열 **/
        /** 배열 => ArrayList **/
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(strings));

        /** ArrayList => 배열 **/
        strings = arr.toArray(new String[arr.size()]);

        /** 배열 한 번에 초기화 **/
        Integer[] integers = new Integer[10];
        Arrays.fill(integers, 10);
        System.out.println(Arrays.toString(integers));

        /** 정수 **/
        int[] ints = {1, 2, 3, 4, 5};
        /** 배열 => ArrayList **/
        ArrayList<Integer> intArrayList = Arrays.stream(ints).boxed().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(intArrayList.toString());

        /** 배열 => List **/
        List<Integer> intList = Arrays.stream(ints).boxed().collect(Collectors.toList());
        System.out.println(intList.toString());

        /** ArrayList, List => 배열 **/
        int[] ints2 = intArrayList.stream().mapToInt(Integer::intValue).toArray();
        ints2 = intArrayList.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(ints2));

        int[] ints3 = intList.stream().mapToInt(Integer::intValue).toArray();
        ints3 = intList.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(ints3));

        Integer[] integers2 = intArrayList.toArray(new Integer[intArrayList.size()]);
        System.out.println(Arrays.toString(integers2));

        /** ArrayList, Array 2차원 배열 **/
        ArrayList<Integer>[] arrayLists = (ArrayList<Integer>[]) new ArrayList[5];
        for(int i = 0; i < 5; i++) { // 초기화
            arrayLists[i] = new ArrayList<>();
            arrayLists[i].add(i);
        }
    }
}
