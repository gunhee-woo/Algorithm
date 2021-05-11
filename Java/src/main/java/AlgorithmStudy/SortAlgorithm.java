package AlgorithmStudy;

import java.util.*;

public class SortAlgorithm {
    public static void main(String[] args) {
        /**
         * String Sort Example
         */
        String[] strings = {"Apple", "Kiwi", "Orange", "Banana", "Watermelon", "Cherry"};
        System.out.println("�⺻ : " + Arrays.toString(strings));

        /** �������� ���� **/
        Arrays.sort(strings);

        System.out.println("�������� ���� : " + Arrays.toString(strings));

        /** �������� ���� **/
        Arrays.sort(strings, Collections.reverseOrder());

        System.out.println("�������� ���� : " + Arrays.toString(strings));

        Integer[] integers = {1, 25, 12, 100, 99, 0, 50};
        System.out.println("�⺻ : " + Arrays.toString(integers));

        /** Comparator ���� ���� �������� ���� **/
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        System.out.println("�������� �������� ���� : " + Arrays.toString(integers));

        /** ���ٸ� ����� �������� ���� **/
        Arrays.sort(integers, (o1, o2) -> o1 - o2);

        System.out.println("����Ȱ�� �������� ���� : " + Arrays.toString(integers));

        /** ��Ʈ���� Ȱ���� �������� ���� **/
        System.out.print("��Ʈ��Ȱ�� �������� ���� : ");
        Arrays.stream(integers).sorted(Collections.reverseOrder()).forEach(it -> System.out.print(it + ", "));
        System.out.println();

        /** �迭 �κ� �������� ���� **/
        Arrays.sort(integers, 0, 4, Collections.reverseOrder());
        System.out.println("�迭 �κ� ���� : " + Arrays.toString(integers));

        /** Ŀ����(��ü) ���� **/
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        Arrays.sort(strings, (o1, o2) -> o2.length() - o1.length());
        Arrays.stream(strings).sorted((o1, o2) -> o2.length() - o1.length()).forEachOrdered(it -> System.out.print(it + ", "));
        System.out.println();
        System.out.println("Ŀ���� ����(String ���� �������� ����) : " + Arrays.toString(strings));

        /** �迭 => ArrayList **/
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(strings));

        /** ArrayList => �迭 **/
        strings = arr.toArray(new String[arr.size()]);

        /** ArrayList �������� ���� **/
        Collections.sort(arr);
        System.out.println(arr.toString());

        /** ArrayList �������� ���� **/
        Collections.sort(arr, Collections.reverseOrder());
        System.out.println(arr.toString());
    }
}
