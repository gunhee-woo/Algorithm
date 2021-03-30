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
         * 트리맵은 이진 트리를 기반으로 함
         * 트리맵은 객체를 저장하면 자동으로 키를 기준으로 오름차순 정렬
         * 키값이 작은것이 왼쪽 자식 노드에 높은것이 오른쪽 자식 노드에 저장
         * 트리맵은 일반적으로 성능이 HashMap 보다 떨어짐 => 데이터를 저장과 동시에 정렬하기 때문
         *
         * 트리맵은 이진탐색트리의 문제점을 보완한 레드블랙트리로 이루어져 있음
         * 이진탐색트리는 값이 전체 트리에 잘 분산되어 있다면 효율성에 문제가 없지만
         * 데이터가 한쪽으로 편향되게 들어올 경우 한쪽 방면으로 치우쳐진 트리가 되어 비효율적이게 됨
         * 따라서 이러한 점을 보완하기 위해 레드블랙트리는 부모 노드보다 작은 값의 노드는 왼쪽, 큰 값의 노드는 오른쪽으로 배치
         * 데이터의 추가나 삭제시 한쪽으로 치우쳐지지 않도록 균형을 맞춰줌
         *
         * 트리맵은 트리구조로 이루어져 있기에 항상 정렬이 되어있어 최댓값, 최솟값을 바로 가져오는 메소드를 지원
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

        // 1. 맵을 리스트로 변환
        List<String> keyList = new ArrayList<>(map.keySet());
        List<Integer> valueList = new ArrayList<>(map.values());
        List entryList = new ArrayList(map.entrySet());
        System.out.println(keyList.toString());
        System.out.println(valueList.toString());
        System.out.println(entryList.toString());

        // 2. 맵 탐색
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
