package AlgorithmStudy;

import java.util.*;

public class MapDataStructure {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> hashMap = new HashMap<>();

        mapFunc();

        SortedMap<String, Integer> sortedMap = new TreeMap<>();
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        /**
         * Ʈ������ ���� Ʈ���� ������� ��
         * Ʈ������ ��ü�� �����ϸ� �ڵ����� Ű�� �������� �������� ����
         * Ű���� �������� ���� �ڽ� ��忡 �������� ������ �ڽ� ��忡 ����
         * Ʈ������ �Ϲ������� ������ HashMap ���� ������ => �����͸� ����� ���ÿ� �����ϱ� ����
         *
         * Ʈ������ ����Ž��Ʈ���� �������� ������ �����Ʈ���� �̷���� ����
         * ����Ž��Ʈ���� ���� ��ü Ʈ���� �� �л�Ǿ� �ִٸ� ȿ������ ������ ������
         * �����Ͱ� �������� ����ǰ� ���� ��� ���� ������� ġ������ Ʈ���� �Ǿ� ��ȿ�����̰� ��
         * ���� �̷��� ���� �����ϱ� ���� �����Ʈ���� �θ� ��庸�� ���� ���� ���� ����, ū ���� ���� ���������� ��ġ
         * �������� �߰��� ������ �������� ġ�������� �ʵ��� ������ ������
         *
         * Ʈ������ Ʈ�������� �̷���� �ֱ⿡ �׻� ������ �Ǿ��־� �ִ�, �ּڰ��� �ٷ� �������� �޼ҵ带 ����
         */

        treeMap.put("c", 3);
        treeMap.put("a", 1);
        treeMap.put("b", 2);

        System.out.println("Min key : " + treeMap.firstEntry().getKey() + ", value : " + treeMap.firstEntry().getValue());
        System.out.println("Max key : " + treeMap.lastEntry().getKey() + ", value : " + treeMap.lastEntry().getValue());

        TreeMap<Integer, String> treeMap1 = new TreeMap<>();
        treeMap1.put(1, "a");
        treeMap1.put(2, "b");
        treeMap1.put(3, "c");
        System.out.println("Min key : " + treeMap1.firstEntry().getKey() + ", value : " + treeMap1.firstEntry().getValue());
        System.out.println("Max key : " + treeMap1.lastEntry().getKey() + ", value : " + treeMap1.lastEntry().getValue());
    }

    static void mapFunc() {
        Map<String, Integer> map = new HashMap<>();

        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        // 1. ���� ����Ʈ�� ��ȯ
        List<String> keyList = new ArrayList<>(map.keySet());
        List<Integer> valueList = new ArrayList<>(map.values());
        List entryList = new ArrayList(map.entrySet());
        System.out.println(keyList.toString());
        System.out.println(valueList.toString());
        System.out.println(entryList.toString());

        // 2. �� Ž��
        for(java.util.Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println("key : " + key + ", value : " + value);
        }
        Iterator<java.util.Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            System.out.println("Key : " + entry.getKey() + ", value : " + entry.getValue());
        }
    }
}
